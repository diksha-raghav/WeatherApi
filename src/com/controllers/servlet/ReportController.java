package com.controllers.servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dao.Service.reportViewerService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet("/ReportController")
@MultipartConfig
public class ReportController extends HttpServlet {
	final static Logger logger = Logger.getLogger(ReportController.class);
	reportViewerService rpv =new reportViewerService();
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		

	}
	
	String [] formName=new String[20];
	String dateFrom;
	String dateTo;
	int size;
	XSSFWorkbook workbook;
	int loc=0;
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);    
	String fileName="";
	

	
	@SuppressWarnings("deprecation")
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doPost(request,response); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
try {
	if(request.getParameter("reporttype").toString().equalsIgnoreCase("datareport"))
	{
		fileName="Form_Wise_Detailed_Report_";
		String [] state=request.getParameterValues("State").clone();
		
		String [] formArray=request.getParameterValues("form").clone();
		loc=0;
		for(int i=0;i<formName.length;i++)
			{formName[i]=null;
			}
		if (Integer.parseInt(formArray[0])==100)
			for(int i=1;i<=15;i++)
			{formName[i]=""+(i+100);
			}
			
		else
			for(int i=0;i<formArray.length;i++)
			{
				//System.out.println("dahsdkajshdkjasdad:     "+formArray[i]);
				formName[i]=formArray[i];
			}
		for(int i=0;i<formName.length;i++)
		//	System.out.println("FORM NAME      ::::::     "+formName[i]);
		
		
		dateFrom=request.getParameter("fdate").toString();
		dateTo=request.getParameter("tdate").toString();
		//System.out.println(state);
		
		workbook=rpv.getReport(state, formName, dateFrom, dateTo);
	}
	else if(request.getParameter("reporttype").toString().equalsIgnoreCase("countreport"))
	{
		fileName="User_Wise_Form_Count_";
		String state=request.getParameter("State1").toString();
		//System.out.println(state);
		String district=request.getParameter("district1")==null?"all":request.getParameter("district1").toString();
		String user=request.getParameter("user")==null?"all":request.getParameter("user").toString();
		dateFrom=request.getParameter("fdate").toString();
		dateTo=request.getParameter("tdate").toString();
		workbook=rpv.getReport(state, district, user,dateFrom, dateTo);
	}
	
	// report daily attendance
	else if(request.getParameter("reporttype").toString().equalsIgnoreCase("dailyreport"))
	{
		fileName="User_Wise_Daily_Form_Count_";
		String state=request.getParameter("State2").toString();
		dateFrom=request.getParameter("fdate").toString();
		dateTo=request.getParameter("tdate").toString();
		workbook=rpv.getReport(state, dateFrom, dateTo);
	}
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);
		byte [] outArray = outByteStream.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length);
		response.setHeader("Content-Disposition", "attachment; filename="+fileName+dateFrom+"_to_"+dateTo+".xlsx");
		response.setIntHeader("Refresh", 1);
		OutputStream outStream = response.getOutputStream();
		outStream.write(outArray);
		
		
}
catch(Exception e)
{
	
	System.out.println("Servlet Error:   ::"+e);
	e.printStackTrace();
}
	}
}
