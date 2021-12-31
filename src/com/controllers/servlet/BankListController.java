package com.controllers.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dao.Service.IFSCService;

/**
 * Servlet implementation class BankListController
 */
@WebServlet("/BankListController")
public class BankListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static  List<String> bankList ;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bankList=IFSCService.getBanks();
		JSONObject json = new JSONObject();
		json.put("banklist", bankList);
		response.getWriter().write(json.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
