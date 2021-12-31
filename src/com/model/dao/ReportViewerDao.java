package com.model.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletOutputStream;

import com.dao.util.DBUtil;
import com.mode.entities.User_Registration;
import com.dao.Service.ReportGenerator;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

public class ReportViewerDao {
	
	ReportGenerator rg=new ReportGenerator();
	final static Logger logger = Logger.getLogger(ViewDao.class);
	FileOutputStream outputStream;
	ServletOutputStream os;
	XSSFWorkbook workbook = new XSSFWorkbook();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
	String stateCondition=".state in (\"";
	String head[]= {"SL No","Name","Designation","Contact No","State"};
	String dailyReportHead[]={"Date","User","District","Form Count"};
	Map<Integer, String> formMapi = Stream.of(new Object[][] { 
		{101,"bankcscdata"},{102,"ground_truthingdata"},{103,"individual_lossdata"},{104,"cce_observationdata"},{105,"general_investigationdata"},{106,"publicity_materialsdata"},{107,"meetingdata"},{108,"awarenessdata"},{109,"field_visit"},{110,"office_visit"},{111,"area_sown_report"},{112,"weather_report"},{113,"weather_station_inspection"},{114,"media_reports_publications"},{115,"insured_crop_verification"},
	 }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
	Map<String, String> formMap = Stream.of(new Object[][] { 
		{"bankcscdata","Bank_CSC Visit"},{"ground_truthingdata","Crop Health Monitoring"},{"individual_lossdata","Supervision of Loss Assessment Surveys"},{"cce_observationdata","CCE Supervision"},{"general_investigationdata","General Investigation"},{"publicity_materialsdata","Publicity Materials or Other Modes"},{"meetingdata","Meetings Attended or Organised"},{"awarenessdata","Awareness and Publicity Campaign"},{"field_visit","Field Visit"},{"office_visit","Office Visit"},{"area_sown_report","Area Sown Report"},{"weather_report","Weather Report"},{"weather_station_inspection","Weather Station Inspection"},{"media_reports_publications","Media Reports Publications"},{"insured_crop_verification","Insured Crop Verification"},{"attendance_form","Attendance Form"},
	 }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));
	String[] formnames= {"bankcscdata","ground_truthingdata","individual_lossdata","cce_observationdata","general_investigationdata","publicity_materialsdata","meetingdata","awarenessdata","field_visit","office_visit","area_sown_report","weather_report","weather_station_inspection","media_reports_publications","insured_crop_verification"};
	public ReportViewerDao() {
	}

	public XSSFWorkbook getReport(String state[], String[] form, String fdate, String tdate) 
    {
		if(state.length==32)
			stateCondition="";
		else
		{
		for(int i=0;i<state.length;i++)
		{
			if(i==0)
			stateCondition=stateCondition+state[i]+"\"";
			else
				stateCondition=stateCondition+",\""+state[i]+"\"";
		}
		stateCondition=stateCondition+") and";
		}
		Connection con = null;
		try 
		{	
			con = DBUtil.getConn();
			for(int iter=0;iter<form.length;iter++)
			{
				if(form[iter]!=null)
				{
					String formName=formMapi.get(Integer.parseInt(form[iter]));
			Statement statement = con.createStatement();
			String stateCondition1;
			if(!stateCondition.equals(""))
			stateCondition1=formName+stateCondition;
			else
				stateCondition1=stateCondition;
			String query="select "+formName+".*,user_details.Designation,user_details.mobile1,group_concat(CROPNAME.CROPNAME) CROPNAME from "+formName+" inner join user_details on "+formName+".empID=user_details.empID left join CROPNAME on "+formName+".refID = CROPNAME.refID and CROPNAME.formid="+form[iter]+" where "+stateCondition1+" date(dateandtime) between date(\""+fdate+"\") and date(\""+tdate+"\") and "+formName+".empID>10 and user_details.active_inactive<>0 group by "+formName+".refID;";
			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
	        String [][] formheader;
	        
	        formheader=	rg.getFormHeaders().get(formName).clone();
	        	
	        	 XSSFSheet sheet;
	        	 sheet = workbook.createSheet(formMap.get(formName));
	        	 int rowCount = 0;
				Row row;
				int columnCount = 0;
				row = sheet.createRow(rowCount++);
				int j=0;
				for (int i = 0; i < formheader.length; i++)
				{
					//System.out.print("   "+entry.getValue());
					//if(!(formheader[i][0].equalsIgnoreCase("image")||formheader[i][0].equalsIgnoreCase("document")))
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(formheader[i][1]);
				}
				
				while (rs.next()) {
				columnCount = 0;
				row = sheet.createRow(rowCount++);
				for (int i = 0; i < formheader.length; i++)
			{
								
					//System.out.print("   "+rs.getString(formheader[i][0]));
					//System.out.print("   "+formheader[i][0]);
					
					if(formheader[i][0].equalsIgnoreCase("image")||formheader[i][0].equalsIgnoreCase("document") || formheader[i][0].equalsIgnoreCase("image2")|| formheader[i][0].equalsIgnoreCase("image3")|| formheader[i][0].equalsIgnoreCase("image4"))
					{
						Cell cell = row.createCell(columnCount++);
					    cell.setCellType(CellType.FORMULA);  
				        cell.setCellFormula("HYPERLINK(\"https://dm.aicofindia.com:3000/static/"+rs.getString(formheader[i][0])+"\", \"click to view image\")"); 
				       
					}
					/*else if(formheader[i][0].equalsIgnoreCase("refid"))
					{   Cell cell = row.createCell(columnCount++);
						Statement statement1 = con.createStatement();
						String query1="select CROPNAME from cropname where FORMID ="+form[iter]+" and REFID = "+rs.getString(formheader[i][0]); 
						ResultSet rs1 = statement1.executeQuery(query1);
						String cropName="";
						int crops=0;
						while (rs1.next()) 
						{
							if(crops==0)
								cropName=rs1.getString("cropname");
							else
								cropName+=","+rs1.getString("cropname");
							crops++;
						}
						cell.setCellValue(cropName);
						//Date date=(Date) new SimpleDateFormat("yyyy.mm.dd  - HH:mm:ss z").parse(rs.getString(formheader[i][0]));
						//cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(date));
						//cell.setCellValue(date.toString());
					}
				*/
					else
						{Cell cell = row.createCell(columnCount++);
						cell.setCellValue(rs.getString(formheader[i][0]));}
			}
				
				
				//System.out.println("");
				
				
			}
				
				XSSFTable my_table = sheet.createTable();
			CTTable cttable = my_table.getCTTable();
		    
		    /* Let us define the required Style for the table */    
		    CTTableStyleInfo table_style = cttable.addNewTableStyleInfo();
		    table_style.setName("TableStyleMedium9");   
		        
		        /* Set Table Style Options */
		    table_style.setShowColumnStripes(false); //showColumnStripes=0
		    table_style.setShowRowStripes(true); //showRowStripes=1
		    
		    /* Define the data range including headers */
		    //System.out.println("ROWWWWWW      :      "+rowCount+"COLUMN   :L       "+columnCount);
		    AreaReference my_data_range = new AreaReference(new CellReference(0, 0), new CellReference(rowCount>1?rowCount-1:1, columnCount-1));
		    
		    /* Set Range to the Table */
		        cttable.setRef(my_data_range.formatAsString());
		        cttable.setDisplayName("MYTABLE"+iter);      /* this is the display name of the table */
		  //  cttable.setName("form");    /* This maps to "displayName" attribute in <table>, OOXML */            
		   // cttable.setId(1L);
		    
		    CTTableColumns columns = cttable.addNewTableColumns();
		    columns.setCount((long)columnCount); //define number of columns

		    HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		    for (int i = 0; i < columnCount; i++)
		    {
		    CTTableColumn column = columns.addNewTableColumn();   
		  column.setName("Column" + i);      
		        column.setId((long)(i+1));
		        sheet.autoSizeColumn(i);
		    }
		    }
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				outputStream.close();

				
			} catch (Exception e) {
				//e.printStackTrace();
//				logger.error(e);
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return workbook;
		

		
		}
    
	public XSSFWorkbook getReport(String state, String district, String user, String fdate, String tdate) 
    {
	   
	   String userCon;
	   
	   XSSFSheet sheet;
	  
	  // System.out.println(fdate);
	   sheet = workbook.createSheet("Count "+fdate+" to "+tdate);
		
		Connection con = null;
		try 
		{	
			con = DBUtil.getConn();
			Map <Integer,String[]> empdetails=new LinkedHashMap <Integer,String[]>();
			Map <Integer, Map<String,Integer>> formCount= new HashMap <Integer, Map<String,Integer>>();
			XSSFFont font= workbook.createFont();
	        font.setFontHeightInPoints((short)10);
	        font.setFontName("Arial");
	        font.setColor(IndexedColors.WHITE.getIndex());
	        font.setBold(true);
	        font.setItalic(false);
	 
	         // Create cell style
	        CellStyle style=workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());  
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
            style.setAlignment(HorizontalAlignment.RIGHT);
	        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	      //  style.setAlignment(CellStyle.ALIGN_CENTER);
	        // Setting font to style
	        style.setFont(font);
			if(state.equalsIgnoreCase("all"))
				{userCon="";
				
				}
			else if(district.equalsIgnoreCase("all"))
			{
				userCon=" user_details.state = \""+state+"\" and ";
				
			}
			else if(user.equalsIgnoreCase("all"))
			{
				userCon=" user_details.district = \""+district+"\" and ";
				
			}
			else
			{
				userCon=" user_details.empID = \""+user+"\" and ";
				
			}
			for(int iter=0;iter<formnames.length;iter++)
			{
				String formName=formnames[iter];
				
					
			Statement statement = con.createStatement();
			Statement statement1 = con.createStatement();
			String query1="select empID,trim(User) User,Designation,mobile1,state from user_details where "+userCon+" empID>10 and active_inactive<>0 order by trim(User);";
			String query="select user_details.empID, count(*) count from "+formName+" inner join user_details on "+formName+".empID=user_details.empID where"+userCon+" date("+formName+".dateandtime) between date(\""+fdate+"\") and date(\""+tdate+"\") and user_details.empID>10 and user_details.active_inactive<>0 group by user_details.empID;";
			//System.out.println(query1);
			ResultSet rs1 = statement1.executeQuery(query1);
			ResultSet rs = statement.executeQuery(query);
			while (rs1.next())
			{
				int count, eid;
				String s[]=new String[4];
				
				eid=Integer.parseInt(rs1.getString("empID"));
				s[0]=rs1.getString("User");
				s[1]=rs1.getString("Designation");
				s[2]=rs1.getString("mobile1");
				s[3]=rs1.getString("state");
				empdetails.put(eid, s);
				
			}

			while (rs.next())
			{
				int eid,count;
				Map<String,Integer> fCount=new HashMap<String,Integer>();
				count=Integer.parseInt(rs.getString("count"));
				eid=Integer.parseInt(rs.getString("empID"));
				if(!formCount.containsKey(eid))
				{
					fCount.put(formName, count);
					formCount.put(eid, fCount);
				}
				else 
				{
					//fCount.put(formName, count);
					
					fCount=formCount.get(eid);
					fCount.put(formName, count);
					formCount.put(eid, fCount);
					
				}
			}
			
			
			}	
	        	
	        	int rowCount = 0;
				Row row;
				int columnCount = 0;
				row = sheet.createRow(rowCount++);
				int j=0;
				for (int i = 0; i < head.length; i++)
				{
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(head[i]);
					
				}
				for (int i = 0; i < formnames.length; i++)
				{
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(formMap.get(formnames[i]));
				}
				Cell cell2 = row.createCell(columnCount++);
				cell2.setCellValue("Total - (User-wise)");
				 cell2.setCellStyle(style);
			//	columnCount = 0;
				//row = sheet.createRow(rowCount++);
				
				   for (Map.Entry<Integer, String[]> entry : empdetails.entrySet())
				   {
					   columnCount = 0;
					   row = sheet.createRow(rowCount++);
					   Cell cell = row.createCell(columnCount++);
					   cell.setCellValue(rowCount-1);
					   String details[]=entry.getValue().clone();
					   for(int i=0;i<details.length;i++)
					   {
						  
						   Cell cell1 = row.createCell(columnCount++);
						   cell1.setCellValue(details[i]);
					   }
					  if(formCount.containsKey(entry.getKey()))
					  {
					   Map<String, Integer> countDetails=formCount.get(entry.getKey());
					   for (int i = 0; i < formnames.length; i++)
					   {
						   Cell cell1 = row.createCell(columnCount++);
						   if(countDetails.containsKey(formnames[i]))
							   cell1.setCellValue(countDetails.get(formnames[i]));
						   else
							   cell1.setCellValue(0);
					   }
					  }
					  else
					  {
						  for (int i = 0; i < formnames.length; i++)
						   {
							   Cell cell1 = row.createCell(columnCount++);
							   cell1.setCellValue(0);
						   }
					  }
					   Cell cell3 = row.createCell(columnCount++);
					   cell3.setCellFormula("SUM(F"+rowCount+":T"+rowCount+")");
					   cell3.setCellStyle(style);
				   }
				   
			 
			        // Setting cell style
			       if(!empdetails.isEmpty())
			       { row = sheet.createRow(rowCount);
				   Cell cell=row.createCell(0);
				   cell.setCellValue("Total - (Form-wise)");
				   cell.setCellStyle(style);
			
				   int cellref=5;
				   for(char i='F';i<='U';i++)
				   {
					   Cell cell1=row.createCell(cellref++);
					   cell1.setCellFormula("SUM("+i+"2"+":"+i+""+(rowCount)+")");
					   cell1.setCellStyle(style);
				   }
				   CellRangeAddress cra = new CellRangeAddress(rowCount, rowCount, 0, 4);
				   sheet.addMergedRegion(cra);
			       }
			       sheet.createFreezePane( 2, 1 );
			XSSFTable my_table = sheet.createTable();
			
			CTTable cttable = my_table.getCTTable();
		    
		    /* Let us define the required Style for the table */    
		    CTTableStyleInfo table_style = cttable.addNewTableStyleInfo();
		    table_style.setName("TableStyleMedium9");   
		        
		        /* Set Table Style Options */
		    table_style.setShowColumnStripes(false); //showColumnStripes=0
		    table_style.setShowRowStripes(true); //showRowStripes=1
		    
		    /* Define the data range including headers */
		    //System.out.println("ROWWWWWW      :      "+rowCount+"COLUMN   :L       "+columnCount);
		    AreaReference my_data_range = new AreaReference(new CellReference(0, 0), new CellReference(rowCount>1?rowCount-1:1, columnCount-1));
		    
		    /* Set Range to the Table */
		        cttable.setRef(my_data_range.formatAsString());
		        cttable.setDisplayName("MYTABLE");      /* this is the display name of the table */
		  //  cttable.setName("form");    /* This maps to "displayName" attribute in <table>, OOXML */            
		   // cttable.setId(1L);
		    
		    CTTableColumns columns = cttable.addNewTableColumns();
		    columns.setCount((long)columnCount); //define number of columns

		        /* Define Header Information for the Table */
		    for (int i = 0; i < columnCount; i++)
		    {
		    CTTableColumn column = columns.addNewTableColumn();   
		  column.setName("Column" + i);      
		        column.setId((long)(i+1));
		        sheet.autoSizeColumn(i);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				outputStream.close();

				
			} catch (Exception e) {
				//e.printStackTrace();
//				logger.error(e);
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return workbook;
		

		
		}
/////////////////////////////Daily Report///////////////////////////	
	public XSSFWorkbook getReport(String state, String fdate, String tdate) 
    {
		XSSFSheet sheet;
		sheet = workbook.createSheet("Count "+fdate+" to "+tdate);
		Connection con = null;
		try 
		{	
			con = DBUtil.getConn();
			XSSFFont font= workbook.createFont();
		    font.setFontHeightInPoints((short)10);
		    font.setFontName("Arial");
		    font.setColor(IndexedColors.WHITE.getIndex());
		    font.setBold(true);
		    font.setItalic(false);
		    // Create cell style
		    CellStyle style=workbook.createCellStyle();
		    style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());  
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
	        style.setAlignment(HorizontalAlignment.RIGHT);
		    style.setFont(font);
				
		    Statement statement = con.createStatement();
		    String query="select CAST(a.DATEOFSUBMISSION as DATE), b.User, b.District, count(a.USERID) from VBAK as a inner join user_details as b on a.USERID = b.empID where b.State = '"+state+"' and a.DATEOFSUBMISSION >= '"+fdate+"' and a.DATEOFSUBMISSION < '"+tdate+"' group by a.USERID, CAST(a.DATEOFSUBMISSION as DATE) order by CAST(a.DATEOFSUBMISSION as DATE) ;";
		    System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			int rowCount = 1;
			while (rs.next())
			{
				String s[]=new String[4];
				
				s[0]=rs.getString("CAST(a.DATEOFSUBMISSION as DATE)");
				s[1]=rs.getString("b.User");
				s[2]=rs.getString("b.District");
				s[3]=rs.getString("count(a.USERID)");
	
				Row row = sheet.createRow(rowCount++);
				int columnCount = 0;
				
	            Cell cell = row.createCell(columnCount++);
	            cell.setCellValue(s[0]);
	 
	            cell = row.createCell(columnCount++);
	            cell.setCellValue(s[1]);
	            
	            cell = row.createCell(columnCount++);
	            cell.setCellValue(s[2]);
	            
	            cell = row.createCell(columnCount++);
	            cell.setCellValue(s[3]);
					
			}
			int rowCount2 = 0;
			Row row;
			int columnCount = 0;
			row = sheet.createRow(rowCount2++);
			for (int i = 0; i < dailyReportHead.length; i++)
			{
				Cell cell = row.createCell(columnCount++);
				cell.setCellValue(dailyReportHead[i]);
			}
			
			XSSFTable my_table = sheet.createTable();
			CTTable cttable = my_table.getCTTable();
		    
		    /* Let us define the required Style for the table */    
		    CTTableStyleInfo table_style = cttable.addNewTableStyleInfo();
		    table_style.setName("TableStyleMedium9");   
		        
		    /* Set Table Style Options */
		    table_style.setShowColumnStripes(false); //showColumnStripes=0
		    table_style.setShowRowStripes(true); //showRowStripes=1
		    
		    /* Define the data range including headers */
		    AreaReference my_data_range = new AreaReference(new CellReference(0, 0), new CellReference(rowCount>1?rowCount-1:1, columnCount-1));
		    
		    /* Set Range to the Table */
		    cttable.setRef(my_data_range.formatAsString());
		    cttable.setDisplayName("MYTABLE");      /* this is the display name of the table */
		    CTTableColumns columns = cttable.addNewTableColumns();
		    columns.setCount((long)columnCount); //define number of columns

		    /* Define Header Information for the Table */
		    for (int i = 0; i < columnCount; i++)
		    {
		    	CTTableColumn column = columns.addNewTableColumn();   
		    	column.setName("Column" + i);      
		        column.setId((long)(i+1));
		        sheet.autoSizeColumn(i);
		    }
				
		}catch (Exception e) {
				e.printStackTrace();
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
		}
		finally {
			try {
					if (con != null) {
						con.close();
					}
					outputStream.close();
				} catch (Exception e) {
					String message = "";
					for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
						message = message + System.lineSeparator() + stackTraceElement.toString();
					}
					logger.error(e + System.lineSeparator() + message);
				}
			}
			return workbook;
    }
	
}
