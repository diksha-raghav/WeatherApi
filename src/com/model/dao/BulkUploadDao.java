package com.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dao.util.CommonsUtil;
import com.dao.util.DBUtil;
import com.dao.util.QuotationUtils;
import com.mode.entities.IntermediaryDetails;
import com.mode.entities.User_Registration;

public class BulkUploadDao {
	final static Logger logger = Logger.getLogger(BulkUploadDao.class);

	public static String checkType(XSSFRow row) {
		String mismatcherror = "";
		for (int col = 0; col < 24; col++) {
//			////System.out.println(col);
			Cell cell = row.getCell(col);
			if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
				// //////System.out.println(col);
				continue;
			} else {
				CellType celltype = cell.getCellTypeEnum();

//				if (col == 16 && (celltype != CellType.NUMERIC || celltype != CellType.STRING))
//					if (col == 16 && ( celltype != CellType.STRING))
				if (col == 16 && (celltype != CellType.NUMERIC)) {
//					mismatcherror = "Kindly check the format for ";
					mismatcherror = mismatcherror + "Bank Account Number";
				}
//				if (col == 7 || col == 8 || col == 9 || col == 13 || col == 14) removed date from the validation check
				if (col == 7 || col == 8 || col == 9 || col == 13 || col == 14) {
					if (celltype != CellType.NUMERIC && celltype != CellType.FORMULA) {
						// //System.out.println("string:" + col + " " + celltype);
						if (col == 7)
							mismatcherror = mismatcherror + ",Date(YYYY-MM-DD)";
						if (col == 8)
							mismatcherror = mismatcherror + ",Mobile Number(Numeric)";
						if (col == 9)
							mismatcherror = mismatcherror + ",Alternate Mobile Number(Numeric)";
						if (col == 13)
							mismatcherror = mismatcherror + ",Experience in Crop Insurance(Numeric)";
						if (col == 14)
							mismatcherror = mismatcherror + ",Experience in Crop Insurance in months(Numeric)";
					}

				} else {
					if (celltype != CellType.STRING) {
						// //System.out.println("string:" + col + " " + celltype);

						if (col == 0)
							mismatcherror = mismatcherror + " Level";
						if (col == 1)
							mismatcherror = mismatcherror + " ,State";
						if (col == 2)
							mismatcherror = mismatcherror + " ,District";
						if (col == 3)
							mismatcherror = mismatcherror + " ,L4";
						if (col == 4)
							mismatcherror = mismatcherror + " ,L5";
						if (col == 5)
							mismatcherror = mismatcherror + ", Username";
						if (col == 6)
							mismatcherror = mismatcherror + " ,Designation";
						if (col == 10)
							mismatcherror = mismatcherror + " ,Email";
						if (col == 11)
							mismatcherror = mismatcherror + " ,Education Qualification";
						if (col == 12)
							mismatcherror = mismatcherror + ",Office Location";
						if (col == 15)
							mismatcherror = mismatcherror + ",Gender";
						if (col == 17)
							mismatcherror = mismatcherror + ",Bank IFSC";
						if (col == 18)
							mismatcherror = mismatcherror + ",Bank Name";
						if (col == 19)
							mismatcherror = mismatcherror + ",Bank Branch Name";
						if (col == 20)
							mismatcherror = mismatcherror + ",Bank Branch State";
						if (col == 21)
							mismatcherror = mismatcherror + ",Bank Branch Address";
						if (col == 22)
							mismatcherror = mismatcherror + ",Intermediary Name";
						if (col == 23)
							mismatcherror = mismatcherror + ",Intermediary Type";

					}
//					return mismatcherror;
				}

			}
		}
		if (!"".equals(mismatcherror)) {
			mismatcherror = "Please correct the format for " + mismatcherror;
		} else {
			mismatcherror = "correct";
		}
		return mismatcherror;
	}

	public static void perform_operation(File file, int inserted_rows_count, int failed_rows_count) {
//		Connection con = null;
		try {

			FileInputStream fi = new FileInputStream(file);
			// ArrayList<User_Registration> UserDetailsList = new ArrayList<>();
			XSSFWorkbook workbook = new XSSFWorkbook(fi);

			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			style.setFont(font);

			CellStyle style1 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setColor(IndexedColors.GREEN.getIndex());
			style1.setFont(font1);

			CellStyle Hstyle = workbook.createCellStyle();
			Font Hfont = workbook.createFont();
			Hfont.setBold(true);
			Hstyle.setFont(Hfont);

			XSSFSheet sheet = workbook.getSheet("UserForm");
			int rows = sheet.getPhysicalNumberOfRows();
			// //System.out.println("Rows are " + rows);
//			 ////System.out.println(rows);
			// ArrayList<Integer> invalid_rows=new ArrayList<>();
			XSSFRow rowstart = sheet.getRow(0);
			Cell cResult = rowstart.createCell(24);
			cResult.setCellValue("Reason");
			cResult.setCellStyle(Hstyle);

			XSSFRow row;
			for (int r = 1; r < rows; r++) {
//				//////System.out.println("r is " + r);
				row = sheet.getRow(r);
				if (CommonsUtil.isRowEmpty(row)) {
					continue;
				}
				String errors_in_column_validation = checkType(row);
				// //System.out.println(errors_in_column_validation);
				if (!"correct".equals(errors_in_column_validation)) {
					// ////System.out.println("in if");
					Cell c24 = row.createCell(24);
					c24.setCellValue(errors_in_column_validation);
					c24.setCellStyle(style);
					// Write RESULT-MISMATCH DATATYPE, EMP_ID=NULL
				}

				else {
					// //////System.out.println("in else");
					String State = null;
					String District = null;
					String User = null;
					String Designation = null;
					String level = null;
					String l5 = null;
					String l4 = null;
					String dob = null;
					String mobile1 = null;
					String mobile2 = null;
					String email = null;
					String education_qualification = null;
					String office_location = null;
					Integer exp_crop_ins_year = Integer.MIN_VALUE;
					Integer exp_crop_ins_month = Integer.MIN_VALUE;
					String bank_branch_address = null;
					String bank_state = null;
					String bank_name = null;
					String banf_ifsc = null;
					String bank_account_number = null;
					String gender = null;
					String bank_branch = null;
					String intermediaryName = null;
					String intermediaryType = null;
					if (row.getCell(0) != null) {
						level = row.getCell(0).getStringCellValue();
					}
					if (row.getCell(1) != null) {
						State = row.getCell(1).getStringCellValue();
					}
					if (row.getCell(2) != null) {
						District = row.getCell(2).getStringCellValue();
					}
					if (row.getCell(3) != null) {
						l4 = row.getCell(3).getStringCellValue();
					}
					if (row.getCell(4) != null) {
						l5 = row.getCell(4).getStringCellValue();
					}
					if (row.getCell(5) != null) {
						User = row.getCell(5).getStringCellValue();
					}
					if (row.getCell(6) != null) {
						Designation = row.getCell(6).getStringCellValue();
					}
					if (row.getCell(7) != null) {
						// dob=row.getCell(7).getDateCellValue().toString();
						/*
						 * //////System.out.println((row.getCell(7).getDateCellValue())); System.out
						 * .println(new
						 * SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue()));
						 */
						try {
							dob = new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (row.getCell(8) != null) {
						mobile1 = Long.toString((long) row.getCell(8).getNumericCellValue());
					}
					if (row.getCell(9) != null) {
						mobile2 = Long.toString((long) row.getCell(9).getNumericCellValue());
					}
					if (row.getCell(10) != null) {
						email = row.getCell(10).getStringCellValue();
					}
					if (row.getCell(11) != null) {
						education_qualification = row.getCell(11).getStringCellValue();
					}
					if (row.getCell(12) != null) {
						office_location = row.getCell(12).getStringCellValue();
					}
					if (row.getCell(13) != null) {
						exp_crop_ins_year = (int) row.getCell(13).getNumericCellValue();
					}
					if (row.getCell(14) != null) {
						exp_crop_ins_month = (int) row.getCell(14).getNumericCellValue();
					}

					if (row.getCell(15) != null) {
						gender = row.getCell(15).getStringCellValue();
					}
					if (row.getCell(16) != null) {
//						bank_account_number = row.getCell(16).getStringCellValue();
						bank_account_number = String.valueOf(row.getCell(16).getNumericCellValue());
					}

					if (row.getCell(18) != null) {
						bank_name = row.getCell(18).getStringCellValue();
					}
					if (row.getCell(17) != null) {
						banf_ifsc = row.getCell(17).getStringCellValue();
					}
					if (row.getCell(19) != null) {
						bank_branch = row.getCell(19).getStringCellValue();
					}
					if (row.getCell(20) != null) {
						bank_state = row.getCell(20).getStringCellValue();
					}
					if (row.getCell(21) != null) {
						bank_branch_address = row.getCell(21).getStringCellValue();
					}
					if (row.getCell(23) != null) {
						intermediaryName = row.getCell(23).getStringCellValue();
					}
					if (row.getCell(22) != null) {
						intermediaryType = row.getCell(22).getStringCellValue();
					}

					IntermediaryDetails id = null;
//					////System.out.println(intermediaryType);
					if (intermediaryType.equals("Broker") || intermediaryType.equals("BROKER")) {
						Map<String, IntermediaryDetails> interDetailMap = IntermediaryDao.getInterMapDetails();
						id = interDetailMap.get(intermediaryName);
					} else {
						id = new IntermediaryDetails(intermediaryType, intermediaryName, null, null, null, null);
					}

					User_Registration user = new User_Registration(level, State, District, l5, l4, User, Designation,
							dob, mobile1, mobile2, email, education_qualification, office_location, exp_crop_ins_year,
							exp_crop_ins_month, null, null, gender, bank_account_number, null, banf_ifsc, bank_name,
							bank_branch, bank_state, bank_branch_address);

					processTemplate(user, id, row, style, style1, inserted_rows_count);
//					BulkQuotationController.progress = (r) * 100 / rows; // rows count
					// //////System.out.println(BulkQuotationController.progress);
				}

				// FileOutputStream out = new FileOutputStream(new
				// File(".\\datafiles\\Template.xlsx"));
			}

			failed_rows_count = rows - inserted_rows_count;

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			for (int i = 0; i <= 24; i++)
				sheet.autoSizeColumn(i);
			out.close();

			workbook.close();
			// //////System.out.println(UserDetailsList);
			// //////System.out.println(invalid_rows);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		// TODO Auto-generated method stub

	}

	public static void perform_operation1(File file, int inserted_rows_count, int failed_rows_count) {
		Connection con = null;
		try {

			FileInputStream fi = new FileInputStream(file);
			// ArrayList<User_Registration> UserDetailsList = new ArrayList<>();
			XSSFWorkbook workbook = new XSSFWorkbook(fi);

			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			style.setFont(font);

			CellStyle style1 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setColor(IndexedColors.GREEN.getIndex());
			style1.setFont(font1);

			CellStyle Hstyle = workbook.createCellStyle();
			Font Hfont = workbook.createFont();
			Hfont.setBold(true);
			Hstyle.setFont(Hfont);

			XSSFSheet sheet = workbook.getSheet("UserForm");
			int rows = sheet.getPhysicalNumberOfRows();
			// //System.out.println("Rows are " + rows);
//			 ////System.out.println(rows);
			// ArrayList<Integer> invalid_rows=new ArrayList<>();
			XSSFRow rowstart = sheet.getRow(0);
			Cell cResult = rowstart.createCell(24);
			cResult.setCellValue("Reason");
			cResult.setCellStyle(Hstyle);

			con = DBUtil.getConn();
			XSSFRow row;
			for (int r = 1; r < rows; r++) {
//				//////System.out.println("r is " + r);
				row = sheet.getRow(r);
				if (CommonsUtil.isRowEmpty(row)) {
					continue;
				}
				String errors_in_column_validation = checkType(row);
				// //System.out.println(errors_in_column_validation);
				if (!"correct".equals(errors_in_column_validation)) {
					// ////System.out.println("in if");
					Cell c24 = row.createCell(24);
					c24.setCellValue(errors_in_column_validation);
					c24.setCellStyle(style);
					// Write RESULT-MISMATCH DATATYPE, EMP_ID=NULL
				}

				else {
					// //////System.out.println("in else");
					String State = null;
					String District = null;
					String User = null;
					String Designation = null;
					String level = null;
					String l5 = null;
					String l4 = null;
					String dob = null;
					String mobile1 = null;
					String mobile2 = null;
					String email = null;
					String education_qualification = null;
					String office_location = null;
					Integer exp_crop_ins_year = Integer.MIN_VALUE;
					Integer exp_crop_ins_month = Integer.MIN_VALUE;
					String bank_branch_address = null;
					String bank_state = null;
					String bank_name = null;
					String banf_ifsc = null;
					String bank_account_number = null;
					String gender = null;
					String bank_branch = null;
					String intermediaryName = null;
					String intermediaryType = null;
					if (row.getCell(0) != null) {
						level = row.getCell(0).getStringCellValue();
					}
					if (row.getCell(1) != null) {
						State = row.getCell(1).getStringCellValue();
					}
					if (row.getCell(2) != null) {
						District = row.getCell(2).getStringCellValue();
					}
					if (row.getCell(3) != null) {
						l4 = row.getCell(3).getStringCellValue();
					}
					if (row.getCell(4) != null) {
						l5 = row.getCell(4).getStringCellValue();
					}
					if (row.getCell(5) != null) {
						User = row.getCell(5).getStringCellValue();
					}
					if (row.getCell(6) != null) {
						Designation = row.getCell(6).getStringCellValue();
					}
					if (row.getCell(7) != null) {
						// dob=row.getCell(7).getDateCellValue().toString();
						/*
						 * //////System.out.println((row.getCell(7).getDateCellValue())); System.out
						 * .println(new
						 * SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue()));
						 */
						try {
							dob = new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (row.getCell(8) != null) {
						mobile1 = Long.toString((long) row.getCell(8).getNumericCellValue());
					}
					if (row.getCell(9) != null) {
						mobile2 = Long.toString((long) row.getCell(9).getNumericCellValue());
					}
					if (row.getCell(10) != null) {
						email = row.getCell(10).getStringCellValue();
					}
					if (row.getCell(11) != null) {
						education_qualification = row.getCell(11).getStringCellValue();
					}
					if (row.getCell(12) != null) {
						office_location = row.getCell(12).getStringCellValue();
					}
					if (row.getCell(13) != null) {
						exp_crop_ins_year = (int) row.getCell(13).getNumericCellValue();
					}
					if (row.getCell(14) != null) {
						exp_crop_ins_month = (int) row.getCell(14).getNumericCellValue();
					}

					if (row.getCell(15) != null) {
						gender = row.getCell(15).getStringCellValue();
					}
					if (row.getCell(16) != null) {
//						bank_account_number = row.getCell(16).getStringCellValue();
						bank_account_number = String.valueOf(row.getCell(16).getNumericCellValue());
					}

					if (row.getCell(17) != null) {
						bank_name = row.getCell(17).getStringCellValue();
					}
					if (row.getCell(18) != null) {
						banf_ifsc = row.getCell(18).getStringCellValue();
					}
					if (row.getCell(19) != null) {
						bank_branch = row.getCell(19).getStringCellValue();
					}
					if (row.getCell(20) != null) {
						bank_state = row.getCell(20).getStringCellValue();
					}
					if (row.getCell(21) != null) {
						bank_branch_address = row.getCell(21).getStringCellValue();
					}
					if (row.getCell(23) != null) {
						intermediaryName = row.getCell(23).getStringCellValue();
					}
					if (row.getCell(22) != null) {
						intermediaryType = row.getCell(22).getStringCellValue();
					}

					IntermediaryDetails id = null;
//					////System.out.println(intermediaryType);
					if (intermediaryType.equals("Broker") || intermediaryType.equals("BROKER")) {
						Map<String, IntermediaryDetails> interDetailMap = IntermediaryDao.getInterMapDetails();
						id = interDetailMap.get(intermediaryName);
					} else {
						id = new IntermediaryDetails(intermediaryType, intermediaryName, null, null, null, null);
					}

					User_Registration user = new User_Registration(level, State, District, l5, l4, User, Designation,
							dob, mobile1, mobile2, email, education_qualification, office_location, exp_crop_ins_year,
							exp_crop_ins_month, null, null, gender, bank_account_number, null, banf_ifsc, bank_name,
							bank_branch, bank_state, bank_branch_address);

					processTemplate1(user, id, row, style, style1, con, inserted_rows_count);
//					BulkQuotationController.progress = (r) * 100 / rows; // rows count
					// //////System.out.println(BulkQuotationController.progress);
				}

				// FileOutputStream out = new FileOutputStream(new
				// File(".\\datafiles\\Template.xlsx"));
			}

			failed_rows_count = rows - inserted_rows_count;

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			for (int i = 0; i <= 24; i++)
				sheet.autoSizeColumn(i);
			out.close();

			workbook.close();
			// //////System.out.println(UserDetailsList);
			// //////System.out.println(invalid_rows);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					String message = "";
//					//////////System.out.println("in the exception and code is " + e.getErrorCode());
					for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
						message = message + System.lineSeparator() + stackTraceElement.toString();
					}
					logger.error(e + System.lineSeparator() + message);
					// TODO Auto-generated catch block
				}
			}
		}

		// TODO Auto-generated method stub

	}

	public static void processTemplate(User_Registration user, IntermediaryDetails id, XSSFRow row, CellStyle style,
			CellStyle style1, int inserted_rows_count) throws SQLException, IOException, ParseException {
		String errormsg = QuotationUtils.ValidateQuotation(user, id);
		logger.info("Validation error message" + errormsg);

		int status = 0;
		if (errormsg.equals("Success") || errormsg.equals("Invalid Alternate Mobile Number,\n")) {
			try {
				status = BulkUploadDao.insertbulk_new(user, id);
				logger.info("Insert Status" + status);
			} catch (Exception e) {
				logger.error(e);
			}
			if (status == 1062) {
				// write RESULT-DUPLICATE MOBILE NUMBER, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("DUPLICATE MOBILE NUMBER . User already exists .");
				c24.setCellStyle(style);

			} else if (status == 0) {
				// write RESULT-OTHER ERROR WHILE INSERTING, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("OTHER ERROR WHILE INSERTING");
				c24.setCellStyle(style);

			} else {
				// write RESULT-DONE, EMPID- status

				Cell c24 = row.createCell(24);
				c24.setCellValue("DONE");
				c24.setCellStyle(style1);

				inserted_rows_count++;
			}
		} else {
			// write RESULT-errormsg, EMPID- NULL

			Cell c24 = row.createCell(24);
			c24.setCellValue(errormsg);
			c24.setCellStyle(style);
		}
	}

	public static void processTemplate1(User_Registration user, IntermediaryDetails id, XSSFRow row, CellStyle style,
			CellStyle style1, Connection con, int inserted_rows_count)
			throws SQLException, IOException, ParseException {
		String errormsg = QuotationUtils.ValidateQuotation(user, id);
		logger.info("Validation error message" + errormsg);

		int status = 0;
		if (errormsg.equals("Success") || errormsg.equals("Invalid Alternate Mobile Number,\n")) {
			try {
				status = BulkUploadDao.insertbulk(user, id, con);
				logger.info("Insert Status" + status);
			} catch (Exception e) {
				logger.error(e);
			}
			if (status == 1062) {
				// write RESULT-DUPLICATE MOBILE NUMBER, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("DUPLICATE MOBILE NUMBER . User already exists .");
				c24.setCellStyle(style);

			} else if (status == 0) {
				// write RESULT-OTHER ERROR WHILE INSERTING, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("OTHER ERROR WHILE INSERTING");
				c24.setCellStyle(style);

			} else {
				// write RESULT-DONE, EMPID- status

				Cell c24 = row.createCell(24);
				c24.setCellValue("DONE");
				c24.setCellStyle(style1);

				inserted_rows_count++;
			}
		} else {
			// write RESULT-errormsg, EMPID- NULL

			Cell c24 = row.createCell(24);
			c24.setCellValue(errormsg);
			c24.setCellStyle(style);
		}
	}

	public static int insertbulk(User_Registration data, IntermediaryDetails id, Connection con) throws SQLException {
		String revert = "invalid";
		try {
			// ////System.out.println("entered in insert");
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"insert into user_details(level,State,District,l5,l4,User,Designation,dob,mobile1,mobile2,email,education_qualification,office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,gender,bank_account_number,photo,banf_ifsc,bank_name,bank_branch,bank_state,bank_branch_address,intermediary_name, intermediary_spoc, intermediary_address, intermediary_mobile, intermediary_mail, intermediary_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, data.getLevel());
			ps.setString(2, data.getState().toUpperCase());
			ps.setString(3, data.getDistrict());
			ps.setString(4, data.getL5());
			ps.setString(5, data.getL4());
			ps.setString(6, data.getUser());
			ps.setString(7, data.getDesignation());
			// Date startDate=(Date) new
			// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
			// ps.setDate(8, startDate);
			ps.setString(8, data.getDob());
			ps.setString(9, data.getMobile1());
			ps.setString(10, data.getMobile2());
			ps.setString(11, data.getEmail());
			ps.setString(12, data.getEducation_qualification());
			ps.setString(13, data.getOffice_location());
			ps.setInt(14, data.getExp_crop_ins_year());
			ps.setInt(15, data.getExp_crop_ins_month());
			ps.setString(16, data.getPhoto_card());
			ps.setString(17, data.getCard_id());
			ps.setString(18, data.getGender());
			// FileInputStream fin = new FileInputStream(data.getCard_photo());
			// ps.setBlob(19, fin);
			ps.setString(19, data.getBank_account_number());
			// FileInputStream fin1 = new FileInputStream(data.getPhoto());
			// ps.setBlob(20, fin1);
			ps.setString(20, data.getPhoto());
			ps.setString(21, data.getBanf_ifsc());
			ps.setString(22, data.getBank_name());
			ps.setString(23, data.getBank_branch());
			ps.setString(24, data.getBank_state());
			ps.setString(25, data.getBank_branch_address());

			ps.setString(26, id.getIntermediaryName());
			// ////System.out.println(id.getIntermediaryName());
			ps.setString(27, id.getIntSpocName());
			// ////System.out.println(id.getIntSpocName());
			ps.setString(28, id.getIntermediaryAddress());
			// ////System.out.println(id.getIntermediaryAddress());
			ps.setString(29, id.getIntermediaryMobile());
			// ////System.out.println(id.getIntermediaryMobile());
			ps.setString(30, id.getIntermediaryMail());
			// ////System.out.println(id.getIntermediaryMobile());
			ps.setString(31, id.getIntermediaryType());
			// ////System.out.println(id.getIntermediaryType());
			// ps.setString(26, data.getRelative_loc_photocard());
			// ps.setString(27, data.getRelative_loc_photo());
			// ps.executeUpdate();
			int primkey = 0;
			if (ps.executeUpdate() > 0) {
				// , Statement.RETURN_GENERATED_KEYS
				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					primkey = generatedKeys.getInt(1);
				}
				String sql = "INSERT INTO user_login(username,password,empID,active_deactive) VALUES("
						+ data.getMobile1() + ",MD5('" + data.getDob() + "')," + primkey + ",1)";
				// //////////System.out.println(sql);
				PreparedStatement ps1 = con.prepareStatement(sql);
				if (ps1.executeUpdate() > 0) {
					con.commit();
					con.setAutoCommit(true);
					return primkey;
				} else {
					return 0;
				}
				// System.out.print(primkey);
			}
			// int
			// Emp_Id=fetch_Emp_Id(data.getLevel(),data.getState(),data.getDistrict(),data.getL5(),data.getL4(),data.getUser(),data.getDesignation(),data.getDob(),data.getMobile1(),data.getMobile2(),data.getEmail(),data.getEducation_qualification(),data.getOffice_location(),data.getExp_crop_ins_year(),data.getExp_crop_ins_month(),data.getPhoto_card(),data.getCard_id(),data.getGender(),data.getCard_photo(),data.getPhoto(),data.getBanf_ifsc(),data.getBank_name(),data.getBank_branch(),data.getBank_state(),data.getBank_branch_address());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Fatal Exception", e);
			revert = "invalid";
//			logger.error(e);
			if (e.getErrorCode() == 1062) {
				String message = "";
//				//////////System.out.println("in the exception and code is " + e.getErrorCode());
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
				revert = "duplicate";
				con.rollback();
				return 1062;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Fatal Exception", e);
//			logger.error(e);
			String message = "";
//			//////////System.out.println("in the exception and code is " + e.getErrorCode());
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			con.rollback();
		}
		return 0;
	}

	public static int insertbulk_new(User_Registration data, IntermediaryDetails id) throws SQLException {
		String revert = "invalid";

		try (Connection con = DBUtil.getConn()) {
			// ////System.out.println("entered in insert");

			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(
					"insert into user_details(level,State,District,l5,l4,User,Designation,dob,mobile1,mobile2,email,education_qualification,office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,gender,bank_account_number,photo,banf_ifsc,bank_name,bank_branch,bank_state,bank_branch_address,intermediary_name, intermediary_spoc, intermediary_address, intermediary_mobile, intermediary_mail, intermediary_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, data.getLevel());
				ps.setString(2, data.getState().toUpperCase());
				ps.setString(3, data.getDistrict());
				ps.setString(4, data.getL5());
				ps.setString(5, data.getL4());
				ps.setString(6, data.getUser());
				ps.setString(7, data.getDesignation());
				// Date startDate=(Date) new
				// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
				// ps.setDate(8, startDate);
				ps.setString(8, data.getDob());
				ps.setString(9, data.getMobile1());
				ps.setString(10, data.getMobile2());
				ps.setString(11, data.getEmail());
				ps.setString(12, data.getEducation_qualification());
				ps.setString(13, data.getOffice_location());
				ps.setInt(14, data.getExp_crop_ins_year());
				ps.setInt(15, data.getExp_crop_ins_month());
				ps.setString(16, data.getPhoto_card());
				ps.setString(17, data.getCard_id());
				ps.setString(18, data.getGender());
				// FileInputStream fin = new FileInputStream(data.getCard_photo());
				// ps.setBlob(19, fin);
				ps.setString(19, data.getBank_account_number());
				// FileInputStream fin1 = new FileInputStream(data.getPhoto());
				// ps.setBlob(20, fin1);
				ps.setString(20, data.getPhoto());
				ps.setString(21, data.getBanf_ifsc());
				ps.setString(22, data.getBank_name());
				ps.setString(23, data.getBank_branch());
				ps.setString(24, data.getBank_state());
				ps.setString(25, data.getBank_branch_address());

				ps.setString(26, id.getIntermediaryName());
				// ////System.out.println(id.getIntermediaryName());
				ps.setString(27, id.getIntSpocName());
				// ////System.out.println(id.getIntSpocName());
				ps.setString(28, id.getIntermediaryAddress());
				// ////System.out.println(id.getIntermediaryAddress());
				ps.setString(29, id.getIntermediaryMobile());
				// ////System.out.println(id.getIntermediaryMobile());
				ps.setString(30, id.getIntermediaryMail());
				// ////System.out.println(id.getIntermediaryMobile());
				ps.setString(31, id.getIntermediaryType());
				// ////System.out.println(id.getIntermediaryType());
				// ps.setString(26, data.getRelative_loc_photocard());
				// ps.setString(27, data.getRelative_loc_photo());
				// ps.executeUpdate();
				int primkey = 0;
				
				if (ps.executeUpdate() > 0) {
					// , Statement.RETURN_GENERATED_KEYS
					// Retrieves any auto-generated keys created as a result of executing this
					// Statement object
					ResultSet generatedKeys = ps.getGeneratedKeys();
					if (generatedKeys.next()) {
						primkey = generatedKeys.getInt(1);
					}
					String sql = "INSERT INTO user_login(username,password,empID,active_deactive) VALUES("
							+ data.getMobile1() + ",MD5('" + data.getDob() + "')," + primkey + ",1)";
					// //////////System.out.println(sql);
					PreparedStatement ps1 = con.prepareStatement(sql);
					if (ps1.executeUpdate() > 0) {
						con.commit();
						con.setAutoCommit(true);
						return primkey;
					} else {
						return 0;
					}
					// System.out.print(primkey);
				}
				// int
				// Emp_Id=fetch_Emp_Id(data.getLevel(),data.getState(),data.getDistrict(),data.getL5(),data.getL4(),data.getUser(),data.getDesignation(),data.getDob(),data.getMobile1(),data.getMobile2(),data.getEmail(),data.getEducation_qualification(),data.getOffice_location(),data.getExp_crop_ins_year(),data.getExp_crop_ins_month(),data.getPhoto_card(),data.getCard_id(),data.getGender(),data.getCard_photo(),data.getPhoto(),data.getBanf_ifsc(),data.getBank_name(),data.getBank_branch(),data.getBank_state(),data.getBank_branch_address());
			} catch (SQLException e) {
//				e.printStackTrace();
				logger.error("Fatal Exception", e);
				revert = "invalid";
//			logger.error(e);
				if (e.getErrorCode() == 1062) {

					logger.error("Fatal Exception ", e);
					revert = "duplicate";
					con.rollback();
					return 1062;
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Fatal Exception", e);
//			logger.error(e);
				String message = "";
//			//////////System.out.println("in the exception and code is " + e.getErrorCode());
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
				con.rollback();
			}
		}
		return 0;
	}

	public static String fetch_path() throws SQLException {
		// TODO Auto-generated method stub

		String query = "SELECT * FROM userdetails_master where document_type='BulkUpload'";
		try (Connection conn = DBUtil.getConn();) {
			ResultSet rs = conn.createStatement().executeQuery(query);
			// //System.out.println(query);

			while (rs.next()) {
//				////System.out.println(rs.getString(3));
				return rs.getString(3);
			}

		}
		return null;

	}

	public static void perform_operationBasedOnState(File file, int inserted_rows_count, int failed_rows_count,
			List<String> state) {
//		Connection con = null;
		try {

			FileInputStream fi = new FileInputStream(file);
			// ArrayList<User_Registration> UserDetailsList = new ArrayList<>();
			XSSFWorkbook workbook = new XSSFWorkbook(fi);

			CellStyle style_error = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			style_error.setFont(font);

			CellStyle style_correct = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setColor(IndexedColors.GREEN.getIndex());
			style_correct.setFont(font1);

			CellStyle Hstyle_basedonstate = workbook.createCellStyle();
			Font Hfont = workbook.createFont();
			Hfont.setBold(true);
			Hstyle_basedonstate.setFont(Hfont);

			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			// System.out.println("Rows are " + rows);
//			 //System.out.println(rows);
			// ArrayList<Integer> invalid_rows=new ArrayList<>();
			XSSFRow rowstart = sheet.getRow(0);
			Cell cResult = rowstart.createCell(24);
			cResult.setCellValue("Reason");
			cResult.setCellStyle(Hstyle_basedonstate);

			XSSFRow row;
			for (int r = 1; r < rows; r++) {
//				////System.out.println("r is " + r);
				row = sheet.getRow(r);
				if (CommonsUtil.isRowEmpty(row)) {
					continue;
				}
				String errors_in_column_validation = checkType(row);
				// System.out.println(errors_in_column_validation);
				if (!"correct".equals(errors_in_column_validation)) {
					// //System.out.println("in if");
					Cell c24 = row.createCell(24);
					c24.setCellValue(errors_in_column_validation);
					c24.setCellStyle(style_error);
					// Write RESULT-MISMATCH DATATYPE, EMP_ID=NULL
				}

				else {
					// ////System.out.println("in else");
					String State = null;
					String District = null;
					String User = null;
					String Designation = null;
					String level = null;
					String l5 = null;
					String l4 = null;
					String dob = null;
					String mobile1 = null;
					String mobile2 = null;
					String email = null;
					String education_qualification = null;
					String office_location = null;
					Integer exp_crop_ins_year = Integer.MIN_VALUE;
					Integer exp_crop_ins_month = Integer.MIN_VALUE;
					String bank_branch_address = null;
					String bank_state = null;
					String bank_name = null;
					String banf_ifsc = null;
					String bank_account_number = null;
					String gender = null;
					String bank_branch = null;
					String intermediaryName = null;
					String intermediaryType = null;
					if (row.getCell(0) != null) {
						level = row.getCell(0).getStringCellValue();
					}
					if (row.getCell(1) != null) {
						State = row.getCell(1).getStringCellValue();
					}
					if (row.getCell(2) != null) {
						District = row.getCell(2).getStringCellValue();
					}
					if (row.getCell(3) != null) {
						l4 = row.getCell(3).getStringCellValue();
					}
					if (row.getCell(4) != null) {
						l5 = row.getCell(4).getStringCellValue();
					}
					if (row.getCell(5) != null) {
						User = row.getCell(5).getStringCellValue();
					}
					if (row.getCell(6) != null) {
						Designation = row.getCell(6).getStringCellValue();
					}
					if (row.getCell(7) != null) {
						// dob=row.getCell(7).getDateCellValue().toString();
						/*
						 * ////System.out.println((row.getCell(7).getDateCellValue())); System.out
						 * .println(new
						 * SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue()));
						 */
						try {
							dob = new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(7).getDateCellValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (row.getCell(8) != null) {
						mobile1 = Long.toString((long) row.getCell(8).getNumericCellValue());
					}
					if (row.getCell(9) != null) {
						mobile2 = Long.toString((long) row.getCell(9).getNumericCellValue());
					}
					if (row.getCell(10) != null) {
						email = row.getCell(10).getStringCellValue();
					}
					if (row.getCell(11) != null) {
						education_qualification = row.getCell(11).getStringCellValue();
					}
					if (row.getCell(12) != null) {
						office_location = row.getCell(12).getStringCellValue();
					}
					if (row.getCell(13) != null) {
						exp_crop_ins_year = (int) row.getCell(13).getNumericCellValue();
					}
					if (row.getCell(14) != null) {
						exp_crop_ins_month = (int) row.getCell(14).getNumericCellValue();
					}

					if (row.getCell(15) != null) {
						gender = row.getCell(15).getStringCellValue();
					}
					if (row.getCell(16) != null) {
//						bank_account_number = row.getCell(16).getStringCellValue();
						bank_account_number = String.valueOf(row.getCell(16).getNumericCellValue());
					}

					if (row.getCell(18) != null) {
						bank_name = row.getCell(18).getStringCellValue();
					}
					if (row.getCell(17) != null) {
						banf_ifsc = row.getCell(17).getStringCellValue();
					}
					if (row.getCell(19) != null) {
						bank_branch = row.getCell(19).getStringCellValue();
					}
					if (row.getCell(20) != null) {
						bank_state = row.getCell(20).getStringCellValue();
					}
					if (row.getCell(21) != null) {
						bank_branch_address = row.getCell(21).getStringCellValue();
					}
					if (row.getCell(23) != null) {
						intermediaryName = row.getCell(23).getStringCellValue();
					}
					if (row.getCell(22) != null) {
						intermediaryType = row.getCell(22).getStringCellValue();
					}

					IntermediaryDetails id = null;
//					//System.out.println(intermediaryType);
					if (intermediaryType.equals("Broker") || intermediaryType.equals("BROKER")) {
						Map<String, IntermediaryDetails> interDetailMap = IntermediaryDao.getInterMapDetails();
						id = interDetailMap.get(intermediaryName);
					} else {
						id = new IntermediaryDetails(intermediaryType, intermediaryName, null, null, null, null);
					}

					User_Registration user = new User_Registration(level, State, District, l5, l4, User, Designation,
							dob, mobile1, mobile2, email, education_qualification, office_location, exp_crop_ins_year,
							exp_crop_ins_month, null, null, gender, bank_account_number, null, banf_ifsc, bank_name,
							bank_branch, bank_state, bank_branch_address);

					processTemplateBasedOnState(user, id, row, Hstyle_basedonstate, style_correct, inserted_rows_count,
							state);
//					BulkQuotationController.progress = (r) * 100 / rows; // rows count
					// ////System.out.println(BulkQuotationController.progress);
				}

				// FileOutputStream out = new FileOutputStream(new
				// File(".\\datafiles\\Template.xlsx"));
			}

			failed_rows_count = rows - inserted_rows_count;

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			for (int i = 0; i <= 24; i++)
				sheet.autoSizeColumn(i);
			out.close();

			workbook.close();
			// ////System.out.println(UserDetailsList);
			// ////System.out.println(invalid_rows);
		} catch (Exception e) {
			logger.error("Fatal exception", e);
		}

		// TODO Auto-generated method stub

	}

	public static void processTemplateBasedOnState(User_Registration user, IntermediaryDetails id, XSSFRow row,
			CellStyle style, CellStyle style1, int inserted_rows_count, List<String> state)
			throws SQLException, IOException, ParseException {
		String errormsg = QuotationUtils.ValidateQuotationBasedOnState(user, id, state);
		logger.info("Validation error message" + errormsg);

		int status = 0;
		if (errormsg.equals("Success") || errormsg.equals("Invalid Alternate Mobile Number,\n")) {
			try {
				status = BulkUploadDao.insertbulk_new(user, id);
				logger.info("Insert Status" + status);
			} catch (Exception e) {
				logger.error("Fatal exception", e);
			}
			if (status == 1062) {
				// write RESULT-DUPLICATE MOBILE NUMBER, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("DUPLICATE MOBILE NUMBER . User already exists .");
				c24.setCellStyle(style);

			} else if (status == 0) {
				// write RESULT-OTHER ERROR WHILE INSERTING, EMPID-NULL in Excel

				Cell c24 = row.createCell(24);
				c24.setCellValue("OTHER ERROR WHILE INSERTING");
				c24.setCellStyle(style);

			} else {
				// write RESULT-DONE, EMPID- status

				Cell c24 = row.createCell(24);
				c24.setCellValue("DONE");
				c24.setCellStyle(style1);

				inserted_rows_count++;
			}
		} else {
			// write RESULT-errormsg, EMPID- NULL
			// System.out.println("Error message is " + errormsg);

			Cell c24 = row.createCell(24);
			c24.setCellValue(errormsg);
			c24.setCellStyle(style);

		}
	}
}
