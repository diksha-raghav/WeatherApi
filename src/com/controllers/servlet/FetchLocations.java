package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dao.Service.FetchLocationService;

/**
 * Servlet implementation class FetchLocations
 */
@WebServlet("/FetchLocations")
public class FetchLocations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static JSONObject location_hierarchy_all;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchLocations() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		location_hierarchy_all = FetchLocationService.getLocations();
		// //////////System.out.println(location_hierarchy_all);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// httpResponse.sendRedirect("/app/NewUser.jsp?status=obj");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
//		out.print(location_hierarchy_all);
		out.flush();
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
