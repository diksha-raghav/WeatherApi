package com.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dao.util.BankUtil;

/**
 * Servlet implementation class IFSCController
 */
@WebServlet("/IFSCController")
public class IFSCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static JSONObject bankdetail;
	static {
		BankUtil.getAllBank();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IFSCController() {
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
		// TODO Auto-generated method stub
		String ifsc = request.getParameter("bank_ifsc");
		// "SBIN0006278";//"ALLA0210775";//request.getParameter("bank_ifsc");
//		System.out.print(ifsc);

		bankdetail = BankUtil.getAllBank();
		// System.out.print(bankdetail.get(ifsc));
		// String bank[]=IFSCService.getBank(ifsc);

		JSONObject obj = new JSONObject();
		obj.put("bank", bankdetail.get(ifsc));
		System.out.println(obj);
		response.getWriter().write(obj.toString());
		// request.setAttribute("bank", bank);
		// JSONObject json = new JSONObject();
		// JSONArray bankdetails = new JSONArray();

		/*
		 * json.put("bank", bank[0]); json.put("branch", bank[1]); json.put("bankstate",
		 * bank[2]); json.put("addr", bank[3]);
		 */
		// bankdetails.add(bank[0]);
		// bankdetails.add(bank[1]);
		// bankdetails.add(bank[2]);
		// bankdetails.add(bank[3]);
		// json.put("bank", bankdetails);
		// System.out.println(json);
		/* response.getWriter().write(bankdetail.toString()); */
		// response.getWriter().write(json.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/app/UserRegistration.jsp");
		 * dispatcher.forward(request, response);
		 */
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
