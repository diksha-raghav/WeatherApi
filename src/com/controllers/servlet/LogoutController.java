package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.model.dao.UserDao;

@WebServlet(name = "Logout", urlPatterns = { "/Logout" }) // set in web.xml
public class LogoutController extends HttpServlet {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}
	final static Logger logger = Logger.getLogger(LogoutController.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pwOut = response.getWriter();
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		logger.info("username- " + request.getSession(false).getAttribute("username").toString()
				+ "  Info-  Successfully logged out");

		//// //////////System.out.println("Entered into the logout controller");
		// remove session
		HttpSession session = request.getSession(false);
		session.invalidate();
//		response.sendRedirect("Login.jsp");

		// print confirmation message and redirect to home page
		// pwOut.print("You have successfully logged out");
		response.setContentType("text/html");
//		RequestDispatcher view = request.getRequestDispatcher("/Login");
		// view.forward(request, response);
		httpResponse.sendRedirect("/WeatherApi/Login.jsp");
		pwOut.close();

	}

}
