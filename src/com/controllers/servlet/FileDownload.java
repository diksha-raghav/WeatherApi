package com.controllers.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mode.entities.User_Registration;
import com.model.dao.DetailsDao;
import com.model.dao.ViewDao;

@WebServlet(name = "FileDownload", urlPatterns = { "/FileDownload" })
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ViewDao ViewDao;

	public void init() {
		ViewDao = new ViewDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//// ////System.out.println("doget called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mobile1 = request.getParameter("mobile1");
		String path = DetailsDao.fetch_path();
		////System.out.println(path);
		String file = ViewDao.filePath(mobile1);
		////System.out.println(file);
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ file + "\"");
		FileInputStream fileInputStream = new FileInputStream(path+File.separator+file);
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    doGet(request, response);
	  }
}
