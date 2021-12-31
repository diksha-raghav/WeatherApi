package com.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.dao.IntermediaryDao;

/**
 * Servlet implementation class AutofillController
 */
@WebServlet("/AutofillController")
public class AutofillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutofillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String name = request.getParameter("intermediary_name");
		JSONObject autofill_obj = new JSONObject();
		JSONArray details = new JSONArray();
		
		String intermediary_spoc=IntermediaryDao.getInterMapDetails().get(name).getIntSpocName();
		details.add(intermediary_spoc);
		String intermediary_mail=IntermediaryDao.getInterMapDetails().get(name).getIntermediaryMail();
		details.add(intermediary_mail);
		String intermediary_mobile=IntermediaryDao.getInterMapDetails().get(name).getIntermediaryMobile();
		details.add(intermediary_mobile);
		String intermediary_address=IntermediaryDao.getInterMapDetails().get(name).getIntermediaryAddress();
		details.add(intermediary_address);
		
		autofill_obj.put("Details", details);
		response.setContentType("application/json");
		////System.out.println(autofill_obj);
		response.getWriter().write(autofill_obj.toString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
