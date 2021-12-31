package com.controllers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.dao.Service.LiveUsersService;

/**
 * Servlet implementation class LiveTotalFormCountController
 */
@WebServlet("/LiveTotalFormCountController")
public class LiveTotalFormCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LiveTotalFormCountController.class);
    JSONObject myObj = new JSONObject(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiveTotalFormCountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 int formcount=LiveUsersService.fetchformcount();
         myObj.put("formcount",formcount);
         ////System.out.println(myObj);
        response.getWriter().write(myObj.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		logger.info("Total live Users Form Count" + formcount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
