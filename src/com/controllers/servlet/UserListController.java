package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.Service.DistrictService;
import com.dao.Service.UserListService;

import java.util.Collections;

/**
 * Servlet implementation class DistrictController
 */
@WebServlet("/fetchUserList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListController() {
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
       // System.out.println("called");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
//		state = "RAJASTHAN";
		JSONArray user_list = UserListService.getDistrict(state,district);
		// //////////System.out.println(dist_list);
		//Collections.sort(user_list);
		JSONObject json = new JSONObject();
		json.put("users", user_list);
		// //////////System.out.println(json);
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
