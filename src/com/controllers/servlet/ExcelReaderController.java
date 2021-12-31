package com.controllers.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.JSONArray;
//import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
//import org.json.JSONObject;

import com.dao.Service.UserDaoService;

@WebServlet(name = "ExcelReader", urlPatterns = { "/ExcelReader*" }) // set in web.xml
public class ExcelReaderController extends HttpServlet {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}
	final static Logger logger = Logger.getLogger(ExcelReaderController.class);

	private static final long serialVersionUID = 1L;

//	public static final String Read_file_path = "D:\\WeatherApi\\DM_Form.xlsx";
//	public static final String Generate_file_path = "D:\\WeatherApi\\NewSheet.xlsx";
	public static final String Read_file_path = "F:\\\\Weatherdata\\\\DMApp Data\\\\data\\\\DM_Form.xlsx";
	public static final String Generate_file_path = "F:\\\\Weatherdata\\\\DMApp Data\\\\Generated_File\\\\\\NewSheet.xlsx";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try (XSSFWorkbook workbook = WorkbookName();) {
		try (XSSFWorkbook workbook = WorkbookName();) {
			if (request.getParameter("CountState") != null && request.getParameter("CountDate") != null) {
				// //////////System.out.println(request.getParameter("CountState"));
				// //////////System.out.println(request.getParameter("CountDate"));
				Set<String> name = new HashSet<String>();
				try {
					name = countUsers(request.getParameter("CountState"), request.getParameter("CountDate"), workbook);
					logger.info("Count of Live users=" + name.size() + " in " + request.getParameter("CountState")
							+ "on " + request.getParameter("CountDate"));

				} catch (ParseException e) {
					String message = "";
					for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
						message = message + System.lineSeparator() + stackTraceElement.toString();
					}
					logger.info(e + System.lineSeparator() + message);
				}

				response.getWriter().write(name.toString());

			} else {
				Iterator<Sheet> sheetIterator = workbook.sheetIterator();
				List<String> SheetName = new ArrayList<String>();
				int i = 0;
				while (sheetIterator.hasNext()) {
					Sheet sheet = sheetIterator.next();
					// //////////System.out.println(sheet.getSheetName()+" "+
					// workbook.isSheetHidden(i));
					if (workbook.isSheetHidden(i))
						i++;
					else {
						SheetName.add(sheet.getSheetName());
						i++;
					}
				}
//			if (!(request.getSession(false).getAttribute("role").toString().equalsIgnoreCase("admin"))) {
				List<String> stateList = new ArrayList<String>();
				// //////////System.out.println(stateList);
				stateList = UserDaoService.getStateList(request.getSession(false).getAttribute("username").toString());
				request.setAttribute("StateList", stateList);

//			}

				Iterator<Sheet> sheetIterator1 = workbook.sheetIterator();
				i = 0;
				Map<String, List<String>> districtMap = new HashMap<>();
				List<String> states;

				while (sheetIterator1.hasNext()) {
					Sheet sheet = sheetIterator1.next();
					// //////////System.out.println("Sjeet in iterator is"+sheet.getSheetName());
					if (workbook.isSheetHidden(i)) {
						i++;
					} else {
						i++;
						// Sheet sheet =workbook.getSheetAt(0);
						DataFormatter dataFormatter = new DataFormatter();
						int rowcount = 0, colDistrict = 0, colState = 0;
						Iterator<Row> rowIterator = sheet.rowIterator();
						while (rowIterator.hasNext()) {
							int cellcount = 0;
							String state = null;
							String district = null;

							Row row = rowIterator.next();
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {

								Cell cell = cellIterator.next();
								// String cellValue = dataFormatter.formatCellValue(cell);
								Cell cellValue = row.getCell(cellcount, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

								if (cellValue == null) {
									//// ////////System.out.println(rowcount+" "+cellcount);
									cellcount++;
									continue;
								}
								if (rowcount == 0) {
									//// ////////System.out.println(cellValue+" sheetname- "+sheet.getSheetName());
									if (cellValue.toString().trim().equalsIgnoreCase("State")) {
										colState = cellcount;
										//// ////////System.out.println("State column- "+colState+" sheetname-
										//// "+sheet.getSheetName());
									}
									if (cellValue.toString().trim().equalsIgnoreCase("District")) {
										colDistrict = cellcount;
									}
								} else {
									if (cellcount == colState) {
										state = cellValue.toString();
										// if(sheet.getSheetName().equals("Awareness & Publicity Campaign"))
										// //////////System.out.println(rowcount+" "+colState+" "+state+" "+cellValue);

									}
									if (state != null) {
										if (cellcount == colDistrict)
											district = cellValue.toString();
									}
								}
								if (state != null && district != null && state != "" && district != "") {

									List<String> list = districtMap.get(state);
									if (list == null) {
										list = new ArrayList<>();
										//// ////////System.out.println(state+" "+sheet.getSheetName());
										districtMap.put(state, list);
									}
									if (!(list.contains(district))) {
										list.add(district);
									}
								}
								cellcount++;
							}
							rowcount++;
						}
					}
				}

				if (!(districtMap.keySet().isEmpty())) {
					states = new ArrayList<>(districtMap.keySet());
					Collections.sort(states);
					//// ////////System.out.println(states);
				}

				/*
				 * for(Map.Entry m :districtMap.entrySet()){
				 * 
				 * //////////System.out.println(m.getKey()+" "+m.getValue()); }
				 */

				request.setAttribute("SheetList", SheetName);
				request.setAttribute("StateDistrictList", districtMap);
				RequestDispatcher view = request.getRequestDispatcher("app/dmf.jsp");
				view.forward(request, response);
			}
		}
	}

	private Set<String> countUsers(String CountState, String CountDate, XSSFWorkbook workbook) throws ParseException {
		// TODO Auto-generated method stub

		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		Set<String> name = new HashSet<String>();
		int unknownCount = 1;

		while (sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			//// ////////System.out.println("Cout datae ius"+CountDate);
			Date countDate = new SimpleDateFormat("yyyy-MM-dd").parse(CountDate);
			DataFormatter dataFormatter = new DataFormatter();
			int rowcount = 0, colDate = 0, colName = 0, colState = 0, totalcell = 0;
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				int cellcount = 0;
				Row row = rowIterator.next();
				List<String> values = new ArrayList<String>();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					if (rowcount == 0) {

						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						if (!(cellValue.equals("")))
							totalcell++;
						if (cellValue.trim().equalsIgnoreCase("State")) {
							colState = cellcount;
						}
						if (cellValue.trim().equalsIgnoreCase("Date of Visit")) {
							colDate = cellcount;
						}
						if (cellValue.trim().equalsIgnoreCase("Your Name")) {
							colName = cellcount;
						}
					} else {
						Cell cellVal = row.getCell(cellcount, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
						// String cellValue=cellVal.toString();
						String cellValue = "";
						if (cellVal == null && cellcount <= totalcell)
							cellValue = "-";
						else if (cellcount <= totalcell)
							cellValue = cellVal.toString();
						else
							break;
						values.add(cellValue);

						if (values.size() == totalcell && values.get(colDate) != "") {
							String[] date = (values.get(colDate)).split(" ");
							//// ////////System.out.println("date= "+date[0]);
							Date date2 = new SimpleDateFormat("dd-MMM-yyyy").parse(date[0]);
							// //////////System.out.println("date2= "+date2);
							// //////////System.out.println("countDate= "+countDate);
							/*
							 * if(CountState.equals("All")) {
							 * 
							 * if(date2.compareTo(countDate)==0) { if(values.get(colName).isBlank()) {
							 * 
							 * name.add("Unknown"+unknownCount++);
							 * 
							 * } else name.add(values.get(colName)); } } else {
							 */
							//// ////////System.out.println(values.get(1));

							if (values.get(colState).equalsIgnoreCase(CountState)
									&& (date2.compareTo(countDate) == 0)) {
								if (values.get(colName).equals("-")) {
									name.add("Unknown" + unknownCount++);
								} else
									name.add(values.get(colName));
							}
							// }
						}
					}
					cellcount++;
				}

				rowcount++;
			}
		}
		return name;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {

			String from_date = request.getParameter("from_date");
			String to_date = request.getParameter("to_date");
			String State = request.getParameter("State");
			String sheet = request.getParameter("sheet");
			String District = request.getParameter("District");

			if (generateExcel(from_date, to_date, State, sheet, District)) {
				if (ReadFile(from_date, to_date, State, sheet, response, request)) {
					logger.info("File downloaded");
					File f = new File(Generate_file_path);
					f.delete();
				}
			} else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/WeatherApi/ExcelReader?status=error");
			}
		} catch (IOException | ParseException e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.info(e + System.lineSeparator() + message);
		}

	}

	public static XSSFWorkbook WorkbookName() {
		try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(Read_file_path)));) {
			return workbook;
		} catch (Exception e) {
			logger.error("Fatal exception", e);
		}
		return null;

	}

	public boolean generateExcel(String from_date, String to_date, String State, String sheetName, String District)
			throws IOException, ParseException {

//		try (XSSFWorkbook workbook = WorkbookName()) {

		// Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from_date);
		// Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to_date);
		//// ////////System.out.println("formDate-330 "+from_date);
		try (XSSFWorkbook workbook = WorkbookName();
				OutputStream fileOut = new FileOutputStream(Generate_file_path);
				XSSFWorkbook wb_template = new XSSFWorkbook();
				FileOutputStream out = new FileOutputStream(Generate_file_path);) {
			wb_template.write(fileOut);
			boolean flag = false;
			List<Boolean> count = new ArrayList<Boolean>();
			if (sheetName.equals("All")) {
				Iterator<Sheet> sheetIterator = workbook.sheetIterator();
				int j = 0;
				while (sheetIterator.hasNext()) {
					Sheet sheet = sheetIterator.next();
					if (workbook.isSheetHidden(j)) {
						j++;
					} else {
						j++;
						count.add(CreateFile(workbook, wb_template, from_date, to_date, State, sheet.getSheetName(),
								District));
						// //////////System.out.println("=> " + sheet.getSheetName());
					}
				}
				for (boolean i : count)
					if (i)
						flag = true;

			} else {
				flag = CreateFile(workbook, wb_template, from_date, to_date, State, sheetName, District);
			}

			wb_template.write(out);
			return flag;
		} catch (Exception e) {
			logger.error("Fatal exception", e);
		}
		return false;
	}

//	}

	public Boolean CreateFile(XSSFWorkbook workbook, XSSFWorkbook wb_template, String fromDate, String toDate,
			String State, String sheetName, String District) throws ParseException {

		// Getting the Sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		DataFormatter dataFormatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.rowIterator();
		
		int ReadExcel_rowcount = 0;
		boolean flag = false;

		XSSFSheet sh = (XSSFSheet) wb_template.createSheet(sheetName);
		int colNum = 0, colDate = 0, colDistrict = 0;
		int totalcell = 0, WriteExcelrowCount = 1;

		while (rowIterator.hasNext()) {
			int ReadExcelcellcount = 0;
			Row row = rowIterator.next();
			List<String> values = new ArrayList<String>();
			Row row1 = sh.createRow(ReadExcel_rowcount); // Tells row from which data should be read
			Row r1 = sh.createRow(WriteExcelrowCount); // Tells row at which data should be write

			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				if (ReadExcel_rowcount == 0) {

					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					// Cell cellVal = row.getCell(cellcount,
					// Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					// String cellValue=cellVal.toString();
					row1.createCell(ReadExcelcellcount).setCellValue(cellValue);
					if (!(cellValue.equals("")) || (cellValue.equals(null)))
						totalcell++;

					if (cellValue.trim().equalsIgnoreCase("State")) {
						colNum = ReadExcelcellcount;
					}
					if (cellValue.trim().equalsIgnoreCase("Date of Visit")) {
						colDate = ReadExcelcellcount;
					}
					if (cellValue.trim().equalsIgnoreCase("District")) {
						colDistrict = ReadExcelcellcount;
					}

				} else {
					int WriteExcelcellCount = 0;

					Cell cellVal = row.getCell(ReadExcelcellcount, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String cellValue = "";
					if (cellVal == null && ReadExcelcellcount <= totalcell)
						cellValue = "-";
					else if (ReadExcelcellcount <= totalcell)
						cellValue = dataFormatter.formatCellValue(cellVal);
					else
						break;

					values.add(cellValue);

					if (values.size() == totalcell) {
						if (!(values.get(colDate).equals(""))) {
							String dateformat_Excel = "yyyy-MM-dd";
							String dateformat_html = "yyyy-MM-dd";

							String[] date = (values.get(colDate)).split(" ");
							Date date2 = new SimpleDateFormat(dateformat_Excel).parse(date[0]);
							Date from_date = new SimpleDateFormat(dateformat_html).parse(fromDate);
							Date to_date = new SimpleDateFormat(dateformat_html).parse(toDate);
							if (State.equals("All")) {
								if (date2.compareTo(from_date) >= 0 && date2.compareTo(to_date) <= 0) {
									flag = true;
									for (String curVal : values) {

										r1.createCell(WriteExcelcellCount++).setCellValue(curVal);
									}
									WriteExcelrowCount++;
								}
							} else {
								if (District.equals("All")) {

									if (values.get(colNum).equalsIgnoreCase(State)
											&& (date2.compareTo(from_date) >= 0 && date2.compareTo(to_date) <= 0)) {
										flag = true;
										for (String curVal : values) {

											r1.createCell(WriteExcelcellCount++).setCellValue(curVal);
										}
										WriteExcelrowCount++;

									}
								} else {
									if (values.get(colNum).equalsIgnoreCase(State)
											&& values.get(colDistrict).equalsIgnoreCase(District)
											&& (date2.compareTo(from_date) >= 0 && date2.compareTo(to_date) <= 0)) {
										flag = true;
										for (String curVal : values) {
											r1.createCell(WriteExcelcellCount++).setCellValue(curVal);
										}
										WriteExcelrowCount++;

									}

								}
							}
						}
					}
				}

				ReadExcelcellcount++;
			}
			ReadExcel_rowcount++;
		}
		return flag;
	}

	protected boolean ReadFile(String from_date, String to_date, String State, String sheetName,
			HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {

		File file = new File(Generate_file_path);
		boolean result = false;
		if (!file.exists()) {
			logger.error(file + " File does not exists on server");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/WeatherApi/ExcelReader?status=Internalerror");

		} else {
			ServletContext ctx = getServletContext();
			InputStream fis = new FileInputStream(file);
			String mimeType = ctx.getMimeType(Generate_file_path);
			response.setContentType(mimeType != null ? mimeType : "application/octet-stream");

			response.setCharacterEncoding("UTF8");
			response.setContentLength((int) file.length());
			// response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + State + "_" + sheetName + "_" + from_date + "_" + to_date + ".xlsx");

			try (ServletOutputStream os = response.getOutputStream();) {
				byte[] bufferData = new byte[60000];

				int read = 0;
				while ((read = fis.read(bufferData)) != -1) {
					os.write(bufferData, 0, read);
					result = true;
				}
				os.flush();
				os.close();
				fis.close();
				logger.info(
						State + "_" + sheetName + "_" + from_date + "_" + to_date + ".xlsx file downloaded by user- "
								+ request.getSession(false).getAttribute("username").toString());
				// //////////System.out.println(" downloaded at client successfully");

			}
		}
		return result;

	}
}