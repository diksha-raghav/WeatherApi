package com.controllers.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.ViewDao;

/**
 * Servlet implementation class statusChangeController
 */
@WebServlet("/statusChangeController")
public class statusChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public statusChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ViewDao ViewDao;

    public void init() {
        ViewDao = new ViewDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("doGet Called");
			String[] mob;
			mob = request.getParameterValues("result[]");
//			String mobile1 = request.getParameter("mobile1");
			String status = request.getParameter("status");
			for (int i=0; i < mob.length; ++i) {
				   System.out.println(mob[i]); 
			}
			System.out.println(status);
			ViewDao.changeStatus(mob, status);
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewController");
		    //dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
