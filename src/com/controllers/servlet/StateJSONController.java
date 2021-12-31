package com.controllers.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.Service.StateJSONService;

/**
 * Servlet implementation class StateJSONController
 */
@WebServlet(name = "State", urlPatterns = { "/StateJSONController" })
public class StateJSONController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StateJSONController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray state_list = new JSONArray();
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if ("admin".equalsIgnoreCase(String.valueOf(request.getSession(false).getAttribute("role")))) {
			state_list = StateJSONService.getstatelistwithjsonarray();
		} else {
			List<Object> state = (List<Object>) request.getSession(false).getAttribute("Login_State");
			for (Object stateo : state)
				state_list.add(String.valueOf(stateo));

//			//System.out.println("JSONARrray list is "+state_list);
		}
		Collections.sort(state_list);
		JSONObject json = new JSONObject();
		json.put("States", state_list);
		// //////////System.out.println(json);
		response.setContentType("application/json");
		response.getWriter().write(json.toString());

//		RequestDispatcher view=request.getRequestDispatcher("/app/NewUser.jsp");
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// //////////System.out.println("Do post called ");
		doGet(request, response);
	}

}
