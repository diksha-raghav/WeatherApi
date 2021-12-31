package com.controllers.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Service.SOS_Service;
import com.mode.entities.SOS_Message;
import com.mode.entities.User_Registration;
import com.model.dao.SOSDao;
import com.model.dao.ViewDao;

/**
 * Servlet implementation class SOSController
 */
@WebServlet("/SOSController")
public class SOSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SOSController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		try {
			
			List<SOS_Message> sos_details = SOS_Service.sosdetails();
			request.setAttribute("sos_details", sos_details);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/SOS.jsp");
		dispatcher.forward(request, response);
	}

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller called");
		try {
			String[] refid =request.getParameterValues("refid[]");
			String[] remark = request.getParameterValues("remark[]");
			//System.out.println(refid.toString());
			//System.out.println(remark.toString());
			int length_refid = refid.length;
			int length_remark = remark.length;
			
			System.out.println("Refrence ID length"+length_refid);
			System.out.println("Remark length"+length_remark);
			
			boolean status1 = true;
			boolean status2 = true;
			
			for(int i=0; i<length_remark ; i++) {
				String Ref_id = refid[i];
				//System.out.println(Ref_id.length());
				String RO_remark = remark[i];
				
				if(RO_remark !="") {
					System.out.println("refid--" + Ref_id);
					System.out.println("remark--" + RO_remark);
					status2 = SOS_Service.update_status(refid);
					status1 = SOS_Service.insertRemark(RO_remark, Ref_id);		
				}
				else {
					System.out.println("refid--" + Ref_id);
					System.out.println("remark--" + RO_remark);
				}
				
				
			}
			
			if(status1 && status2) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/app/SOS.jsp?status=valid");
			}
			else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/app/SOS.jsp?status=invalid");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
