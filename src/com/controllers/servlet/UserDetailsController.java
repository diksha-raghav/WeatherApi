package com.controllers.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.model.dao.IntermediaryDao;

/**
 * Servlet implementation class UserDetailsController
 */
@WebServlet("/UserDetailsController")
@MultipartConfig
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(UserDetailsController.class);

	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {

			JSONObject broker_obj = new JSONObject();
			broker_obj.put("Broker", IntermediaryDao.getInterMap().get("Broker"));
			request.setAttribute("interMap", broker_obj);

			/*
			 * JSONObject autofill_obj = new JSONObject(); Map<String, IntermediaryDetails>
			 * interDetailMap= IntermediaryDao.getInterMapDetails(); for
			 * (HashMap.Entry<String, IntermediaryDetails> set : interDetailMap.entrySet())
			 * { JSONArray details=new JSONArray(); details.add(set.getValue());
			 * autofill_obj.put(set.getKey(), details); } //////System.out.println(autofill_obj);
			 * request.setAttribute("interDetailMap", autofill_obj);
			 */

			RequestDispatcher view = request.getRequestDispatcher("/app/NewUser.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			// TODO Auto-generated catch block

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// //////////System.out.println("post!!");

		// //////System.out.println(request.getParameter("intermediary_details"));
		try {
			logger.info("Inside new Intermediary Controller");
			
			if (IntermediaryDao.getParameters(request, response) == 1) // util class method
			{
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect(
						"/WeatherApi/app/NewUser.jsp?status=done&mobile=" + request.getParameter("mobile1"));
				// httpResponse.sendRedirect(request.getContextPath() +
				// "/app/NewUser.jsp?status=done");
			} else if (IntermediaryDao.getParameters(request, response) == 1062) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/WeatherApi/app/NewUser.jsp?status=duplicate");
			} else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/WeatherApi/app/NewUser.jsp?status=invalid");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}
}
/*
 * User_RegistrationUtil ob2 = new User_RegistrationUtil(); // util class object
 * try { if (ob2.User_Registration_method(request, response) == 1) // util class
 * method { HttpServletResponse httpResponse = (HttpServletResponse) response;
 * httpResponse.sendRedirect("/WeatherApi/app/NewUser.jsp?status=done"); //
 * httpResponse.sendRedirect(request.getContextPath() + //
 * "/app/NewUser.jsp?status=done"); } else if
 * (ob2.User_Registration_method(request, response) == 1062) {
 * HttpServletResponse httpResponse = (HttpServletResponse) response;
 * httpResponse.sendRedirect("/WeatherApi/app/NewUser.jsp?status=duplicate"); }
 * else { HttpServletResponse httpResponse = (HttpServletResponse) response;
 * httpResponse.sendRedirect("/WeatherApi/app/NewUser.jsp?status=invalid"); } }
 * catch (IOException e) { // TODO Auto-generated catch block String message =
 * ""; for (StackTraceElement stackTraceElement :
 * Thread.currentThread().getStackTrace()) { message = message +
 * System.lineSeparator() + stackTraceElement.toString(); } logger.error(e +
 * System.lineSeparator() + message); } catch (Exception e) { // TODO
 * Auto-generated catch block String message = ""; for (StackTraceElement
 * stackTraceElement : Thread.currentThread().getStackTrace()) { message =
 * message + System.lineSeparator() + stackTraceElement.toString(); }
 * logger.error(e + System.lineSeparator() + message); } }
 */
