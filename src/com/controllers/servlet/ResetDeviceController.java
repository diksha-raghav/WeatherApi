package com.controllers.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.Service.ResetDeviceService;
import com.graphbuilder.struc.LinkedList;

/**
 * Servlet implementation class ResetDeviceController
 */
@WebServlet("/ResetDeviceController")
public class ResetDeviceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ResetDeviceController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetDeviceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONArray mobile_array = null;
		List<String> state_list = new ArrayList<String>();
		String mobile = request.getParameter("mobileNumber");
		if ("admin".equalsIgnoreCase(String.valueOf(request.getSession(false).getAttribute("role")))) {
			mobile_array = ResetDeviceService.getMobileNumbers(mobile);
		} else {
			List<Object> state = (List<Object>) request.getSession(false).getAttribute("Login_State");
			for (Object stateo : state)
				state_list.add(String.valueOf(stateo));
			mobile_array = ResetDeviceService.getMobileNumbers(mobile,state_list);

//			System.out.println("JSONARrray list is "+state_list);
		}

		Collections.sort(mobile_array);
		JSONObject mobile_obj = new JSONObject();
		mobile_obj.put("Mobile", mobile_array);
//		System.out.println(mobile_obj);
		response.setContentType("application/json");
		response.getWriter().write(mobile_obj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			logger.info("Inside ResetDevice Controller");

			ResetDeviceService.getParameters(request, response);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/WeatherApi/app/ResetDeviceId.jsp?status=done");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
	}

}
