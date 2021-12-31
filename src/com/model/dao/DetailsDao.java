package com.model.dao;

//import java.io.FileInputStream;	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.mode.entities.User_Registration;

public class DetailsDao {
	final static Logger logger = Logger.getLogger(DetailsDao.class);
	String revert = "invalid";

	public static String fetch_path() {
		Connection con = null;
		String path = null;
		try {
			con = DBUtil.getConn();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select master_location from userdetails_master where document_type = 'UserDetails' ");
			rs.next();
			path = rs.getString("master_location");
			// //////System.out.println(path);
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					String message = "";
					for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
						message = message + System.lineSeparator() + stackTraceElement.toString();
					}
					logger.error(e + System.lineSeparator() + message);
				}
			}
		}
		return path;
	}

	/*
	 * public boolean insert_user_login(String mobile_no, String DOB, int Emp_Id)
	 * throws SQLException { Connection con = null; String sql =
	 * "INSERT INTO user_login(username,password,empID,active_deactive) VALUES(" +
	 * mobile_no + ",MD5(" + DOB + ")," + Emp_Id + ",1)";
	 * ////////////System.out.println(sql); try { con = DBUtil.getConn();
	 * con.setAutoCommit(false); Statement ps = con.createStatement(); if
	 * (ps.execute(sql)) { con.commit(); con.setAutoCommit(true); return true; }
	 * else { con.rollback(); return false; } } catch (Exception e) { String message
	 * = "";for(StackTraceElement stackTraceElement :
	 * Thread.currentThread().getStackTrace()) { message = message +
	 * System.lineSeparator() + stackTraceElement.toString(); }
	 * logger.error(e+System.lineSeparator()+message); con.rollback(); return false;
	 * } finally { if (con != null) { con.close(); } }
	 * 
	 * }
	 */
	public int insert(User_Registration data) throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"insert into user_details(level,State,District,l5,l4,User,Designation,dob,mobile1,mobile2,email,education_qualification,office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,gender,bank_account_number,photo,banf_ifsc,bank_name,bank_branch,bank_state,bank_branch_address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
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
//			logger.error(e);
			String message = "";
//			//////////System.out.println("in the exception and code is " + e.getErrorCode());
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			con.rollback();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return 0;
	}

	public static int update_path(int eid, String relative_loc_photocard, String relative_loc_photo)
			throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getConn();
			PreparedStatement pst = con.prepareStatement(
					"update user_details set relative_loc_photocard=?, relative_loc_photo=? where empID ='" + eid
							+ "' ");
			pst.setString(1, relative_loc_photocard);
			pst.setString(2, relative_loc_photocard);
			int success = pst.executeUpdate();
			if (success > 0) {
				return 1;
			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return 0;
	}
}