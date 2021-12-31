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
 * Servlet implementation class LiveUsersStateController
 */
@WebServlet("/LiveUsersStateController")
public class LiveUsersStateController extends HttpServlet {
	final static Logger logger = Logger.getLogger(LiveUsersStateController.class);
	private static final long serialVersionUID = 1L;
	JSONObject myObj = new JSONObject();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiveUsersStateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LiveUsers> userbystate=LiveUsersService.fetchcountbyState();
		JSONArray State = new JSONArray();
		JSONArray Count = new JSONArray();
		for(LiveUsers x:userbystate)
		{
			State.add(x.getState());
			Count.add(x.getCount());
		}
        myObj.put("State",State);
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
