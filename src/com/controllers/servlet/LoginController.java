package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.Service.UserDaoService;
import com.dao.Service.UserStateMappingService;
import com.model.dao.IntermediaryDao;
import com.model.dao.UserDao;

@WebServlet(name = "Login", urlPatterns = { "/Login" }) // set in web.xml
public class LoginController extends HttpServlet {

	final static Logger logger = Logger.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;

	private UserDao dao;

	public LoginController() {

	}

	@Override
	public void init() throws ServletException {
		//// //System.out.println("Inside marketing controller");
		// logger.info("Inside marketing controller");

		IntermediaryDao.loadIntermediary();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pwOut = response.getWriter();
		String redirectPage = "Login.jsp"; // default page

		// pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
		// ////////////System.out.println(request.getContextPath() + "/Login.jsp");
//		RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
//		view.include(request, response);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/Login.jsp");

	}

	// forward response to request

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//// //////////System.out.println("In do post");
		PrintWriter pwOut = response.getWriter();
		// get input from jsp
		String user_name = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			String role = UserDaoService.isuservalid(user_name, password);

			if (user_name == null || password == null) {
				request.setAttribute("Invalid", "Wrong");
				logger.error("Username or password not entered");
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/WeatherApi/Login.jsp");
			}
			// Validate Login
			else if (!("invalid".equals(role))) {

				HttpSession session = request.getSession();
				request.setAttribute("Invalid", "Right");
				session.setAttribute("username", user_name);
				session.setAttribute("role", role);
				List<String> state = new UserStateMappingService().getStatesFromUsersService(user_name);

				session.setAttribute("Login_State", state);
				logger.info("Login successfull- " + user_name);
				logger.info("Login successfull- " + user_name);
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect(request.getContextPath() + "/app/HomePage.jsp");

			}
			// if input is not stored in database print error message and reload page
			else {

				request.setAttribute("Invalid", "Wrong"); /* setAttribute for invalid user */
				// ////////////System.out.println("Username password dint match");
				// ////////////System.out.println(request.getContextPath() + "/Login.jsp");

				// RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
				// view.include(request, response);
				logger.error("Invalid user- " + user_name);
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/WeatherApi/Login.jsp?status=invalid");

			}
		} catch (Exception e) {
			logger.error(e);
		}

		pwOut.close();
	}
}
