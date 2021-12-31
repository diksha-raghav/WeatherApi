package com.controllers.servlet;

import java.io.IOException;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.Service.SubDistrictService;

/**
 * Servlet implementation class SubdistrictsController
 */
@WebServlet("/fetchSubDistricts")
public class SubdistrictsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubdistrictsController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String state = request.getParameter("state");
		String district = request.getParameter("district");
//		state = "RAJASTHAN";
//		district="JHALAWAR";
		// //////////System.out.println(state+" "+district);
//		state = "RAJASTHAN";
		JSONArray dist_list = SubDistrictService.getSubDistrict(state, district);
		Collections.sort(dist_list);
		// //////////System.out.println(dist_list);
		JSONObject json = new JSONObject();
		json.put("district", dist_list);
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
