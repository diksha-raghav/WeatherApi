package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import com.dao.Service.MobileAjaxService;

/**
 * Servlet implementation class MobileAjaxController
 */
@WebServlet("/MobileAjaxController")
public class MobileAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static JSONObject mobile_hierarchy_all;
	public static List mobileList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MobileAjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile = request.getParameter("mobile1");

		mobileList = MobileAjaxService.getMobileList();

		JSONObject json = new JSONObject();
		//////System.out.println("The mobile is " + mobile);
		//////System.out.println(mobileList);
		//////System.out.println("Mobile comparison is " + mobileList.contains(mobile));
		if (mobileList.contains(mobile)) {
			json.put("mobile", "true");
			response.getWriter().write(json.toString());
			//////System.out.println(json);
		} else {
			json.put("mobile", "false");
			response.getWriter().write(json.toString());
			//////System.out.println(json);
		}
		// itr.next();
		// }
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

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
