package com.controllers.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.dao.Service.BulkUploadService;
import com.model.dao.BulkUploadDao;

@WebServlet("/BulkUploadController")
@MultipartConfig
public class BulkUploadController extends HttpServlet {
	final static Logger logger = Logger.getLogger(BulkUploadController.class);
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		// System.setProperty("current.date.time", dateFormat.format(new Date()));

	}

	@SuppressWarnings("deprecation")
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doPost(request,response); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int inserted_rows_count = 0, failed_rows_count = 0;
//		 String path = "D:/WeatherApi/Project/EXCELUPLOAD";
		// //////System.out.println("started");

		String path = null;
		try {
			path = BulkUploadDao.fetch_path();
		} catch (Exception e) {
			logger.error("Fatal Exception : ", e);
		}

		// private static final String dir ="ExcelUpload";
		Part part = request.getPart("fileUploader");
		String fileName = part.getSubmittedFileName();
		// //System.out.println("Path is " + path);
//		fileName = fileName.replaceAll("[^a-zA-Z0-9]", " ").trim();
		String locfile = path + File.separator + fileName;

		// ////System.out.println(locfile);

		File file = new File(locfile);
		file.mkdirs();
		// ////////System.out.println(path_photocard);
		if (fileName != null && !"".equals(fileName)) {
			part.write(locfile);
		}

		if ("admin".equalsIgnoreCase(String.valueOf(request.getSession(false).getAttribute("role")))) {
			BulkUploadService.exceloperation(file, inserted_rows_count, failed_rows_count);
		} else {
			List<String> stateList = new LinkedList<String>();
			List<Object> state = (List<Object>) request.getSession(false).getAttribute("Login_State");
			for (Object stateo : state)
				stateList.add(String.valueOf(stateo).toUpperCase());
			BulkUploadService.exceloperationBasedOnState(file, inserted_rows_count, failed_rows_count, stateList);
		}

		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setContentLength((int) file.length());
		String responsefileName = "RF_" + fileName;
		response.setHeader("Content-Disposition", "attachment; filename=\"" + responsefileName + "\"");

		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;
		while ((read = fis.read(bufferData)) != -1) {
			os.write(bufferData, 0, read);
		}

		os.flush();
		os.close();
		fis.close();
		file.delete();

	}
}
