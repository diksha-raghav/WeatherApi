package com.controllers.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.Service.LiveUsersService;
import com.mode.entities.LiveUsers;

/**
 * Servlet implementation class LiveUsersFormController
 */
@WebServlet("/LiveUsersFormController")
public class LiveUsersFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LiveUsersFormController.class);
	JSONObject myObj = new JSONObject();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiveUsersFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LiveUsers> userbyform=LiveUsersService.fetchcountbyForm();
		JSONArray Form = new JSONArray();
		JSONArray Count = new JSONArray();
		for(LiveUsers x:userbyform)
		{
			Form.add(x.getState());
			Count.add(x.getCount());
		}
        myObj.put("Form",Form);
        myObj.put("Count",Count);
//        System.out.print(myObj);
        response.getWriter().write(myObj.toString());
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
