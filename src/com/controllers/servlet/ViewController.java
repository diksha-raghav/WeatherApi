package com.controllers.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.ViewDao;

import com.mode.entities.User_Registration;

/**

 */
@WebServlet(name = "ViewController", urlPatterns = { "/ViewController" })
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ViewDao ViewDao;

	public void init() {
		ViewDao = new ViewDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//////// //System.out.println("doget called");
		List<User_Registration> listUser;
		if ("admin".equalsIgnoreCase(String.valueOf(request.getSession(false).getAttribute("role")))) {
			listUser = ViewDao.getAllUsers();
		} else {
			List<String> stateList = new LinkedList<String>();
			List<Object> state = (List<Object>) request.getSession(false).getAttribute("Login_State");
			for (Object stateo : state)
				stateList.add(String.valueOf(stateo));
			listUser = ViewDao.getAllUsers(stateList);

		}
		request.setAttribute("listUser", listUser);
	    request.setAttribute("totaluser", listUser.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/view.jsp");
		dispatcher.forward(request, response);

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
