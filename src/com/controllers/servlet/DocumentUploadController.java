package com.controllers.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import com.dao.Service.DocumentUploadService;


/**
 * Servlet implementation class DocumentUploadController
 */
@WebServlet("/DocumentUploadController")
@MultipartConfig

public class DocumentUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static JSONObject json;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Part> files = (List<Part>) request.getParts();
		Map<String, Object> resultsMap = DocumentUploadService.uploadDoc(files);
		int inserted = (int) resultsMap.get("passed");
		int failed = (int) resultsMap.get("failed");
		String files_failed = (String) resultsMap.get("FilesFailedMesasge");
		System.out.println(inserted);
		System.out.println(failed);
		System.out.println(files_failed);
		request.setAttribute("successful", "No. of successful inserted files :");
		request.setAttribute("inserted", inserted);
		request.setAttribute("unsuccessful", "No. of unsuccessful files :");
		request.setAttribute("failed", failed);
		if(!files_failed.equals(""))
		{
			request.setAttribute("errorfiles", "Error in inserting files : ");
			request.setAttribute("files_failed", files_failed);
		}
		RequestDispatcher req = request.getRequestDispatcher("/app/BulkDocument.jsp");
		req.forward(request, response);

	}

}
