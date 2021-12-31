package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.util.CommonsUtil;
import com.dao.util.DBUtil;
import com.mode.entities.IntermediaryDetails;
import com.mode.entities.User_Registration;

public class EditDao {
	final static Logger logger = Logger.getLogger(EditDao.class);

	public List<User_Registration> listUser(String mobile1) throws SQLException {

		List<User_Registration> users = new ArrayList<User_Registration>();

		Connection con = null;
		try {
			con = DBUtil.getConn();

			PreparedStatement pst = con.prepareStatement("SELECT * FROM user_details WHERE mobile1=?");
			pst.setString(1, mobile1); // set name like this (The '1' means first occurance of a question mark '?')
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				User_Registration user = new User_Registration();
				user.setLevel(rs.getString("level"));
				user.setState(rs.getString("State"));
				user.setDistrict(rs.getString("District"));
				user.setL5(rs.getString("l5"));
				user.setL4(rs.getString("l4"));
				user.setUser(rs.getString("User"));
				user.setDesignation(rs.getString("Designation"));
				user.setDob(rs.getString("dob"));
				user.setMobile1(rs.getString("mobile1"));
				user.setMobile2(rs.getString("mobile2"));
				user.setEmail(rs.getString("email"));
				user.setEducation_qualification(rs.getString("education_qualification"));
				user.setOffice_location(rs.getString("office_location"));
				user.setDoc_type(rs.getString("doc_type"));
				user.setExp_crop_ins_year(rs.getInt("exp_crop_ins_year"));
				user.setExp_crop_ins_month(rs.getInt("exp_crop_ins_month"));
				user.setPhoto_card(rs.getString("photo_card"));
				user.setCard_id(rs.getString("card_id"));
				user.setGender(rs.getString("gender"));
				// user.setPhoto_card(rs.getString("photo_card"));
				user.setPhoto(rs.getString("photo"));
				user.setBanf_ifsc(rs.getString("banf_ifsc"));
				user.setBank_name(rs.getString("bank_name"));
				user.setBank_branch(rs.getString("bank_branch"));
				user.setBank_state(rs.getString("bank_state"));
				user.setBank_branch_address(rs.getString("bank_branch_address"));
				System.out.println(rs.getString("bank_account_number"));
				if((rs.getString("bank_account_number")) !=null){
					user.setBank_account_number(rs.getString("bank_account_number").isEmpty() ? rs.getString("bank_account_number")
							: CommonsUtil.scientificNotationToString(
									Double.parseDouble(rs.getString("bank_account_number"))));
					
				}
				
				
				users.add(user);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
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

		return users;
	}

	public List<IntermediaryDetails> listIntermediary(String mobile1) throws SQLException {
		List<IntermediaryDetails> intermediaries = new ArrayList<IntermediaryDetails>();
		Connection con = null;
		try {
			con = DBUtil.getConn();

			PreparedStatement pst = con.prepareStatement("SELECT * FROM user_details WHERE mobile1=?");
			pst.setString(1, mobile1); // set name like this (The '1' means first occurance of a question mark '?')
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				IntermediaryDetails intermediary = new IntermediaryDetails();

				intermediary.setIntermediaryType(rs.getString("intermediary_type"));
				intermediary.setIntermediaryMail(rs.getString("intermediary_mail"));
				intermediary.setIntermediaryName(rs.getString("intermediary_name"));
				intermediary.setIntSpocName(rs.getString("intermediary_spoc"));
				intermediary.setIntermediaryAddress(rs.getString("intermediary_address"));
				intermediary.setIntermediaryMobile(rs.getString("intermediary_mobile"));
				// intermediary.setIntermediaryId(rs.getString("intermediaryId"));
				intermediaries.add(intermediary);

			}
		} catch (SQLException e) {
//			e.printStackTrace();
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

		return intermediaries;
	}

	public boolean updateUser(User_Registration data, IntermediaryDetails id) throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getConn();
			// PreparedStatement ps=con.prepareStatement("insert into
			// user_details(level,State,District,l5,l4,User,Designation,dob,mobile1,mobile2,email,education_qualification,office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,gender,card_photo,photo,banf_ifsc,bank_name,bank_branch,bank_state,bank_branch_address)
			// values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(
					"update user_details set level=?, state=?, district=?, l5=?, l4=?, User=?, designation=?, dob=?, mobile2=?, email=?, education_qualification=?, office_location=?, exp_crop_ins_year=?, exp_crop_ins_month=?, doc_type=?,photo_card=?,card_id=?, gender=?, banf_ifsc=?, bank_name=?, bank_branch=?, bank_state=?,bank_branch_address=?, intermediary_type = ?, intermediary_name =?, intermediary_spoc =?, intermediary_mobile =?, intermediary_mail =?, intermediary_address=?"
							+ "where mobile1=?");

			ps.setString(1, data.getLevel());
			ps.setString(2, data.getState());
			ps.setString(3, data.getDistrict());
			ps.setString(4, data.getL5());
			ps.setString(5, data.getL4());
			ps.setString(6, data.getUser());
			ps.setString(7, data.getDesignation());
			// Date startDate=(Date) new
			// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
			// ps.setDate(8, startDate);
			ps.setString(8, data.getDob());
			ps.setString(9, data.getMobile2());
			ps.setString(10, data.getEmail());
			ps.setString(11, data.getEducation_qualification());
			ps.setString(12, data.getOffice_location());
			ps.setInt(13, data.getExp_crop_ins_year());
			ps.setInt(14, data.getExp_crop_ins_month());
			ps.setString(15, data.getDoc_type());
			ps.setString(16, data.getPhoto_card());
			ps.setString(17, data.getCard_id());
			ps.setString(18, data.getGender());
			// FileInputStream fin = new FileInputStream(data.getCard_photo());
			// ps.setBlob(19, fin);
			// ps.setString(19, data.getCard_photo());
			// FileInputStream fin1 = new FileInputStream(data.getPhoto());
			// ps.setBlob(20, fin1);
			// ps.setString(20, data.getPhoto());
			ps.setString(19, data.getBanf_ifsc());
			ps.setString(20, data.getBank_name());
			ps.setString(21, data.getBank_branch());
			ps.setString(22, data.getBank_state());
			ps.setString(23, data.getBank_branch_address());
			ps.setString(24, id.getIntermediaryType());
			ps.setString(25, id.getIntermediaryName());
			ps.setString(26, id.getIntSpocName());
			ps.setString(27, id.getIntermediaryMobile());
			ps.setString(28, id.getIntermediaryMail());
			ps.setString(29, id.getIntermediaryAddress());
			ps.setString(30, data.getMobile1());
			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			return false;
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	public boolean updateUserWithouDoc(User_Registration data, IntermediaryDetails id) throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getConn();
			// PreparedStatement ps=con.prepareStatement("insert into
			// user_details(level,State,District,l5,l4,User,Designation,dob,mobile1,mobile2,email,education_qualification,office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,gender,card_photo,photo,banf_ifsc,bank_name,bank_branch,bank_state,bank_branch_address)
			// values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(
					"update user_details set level=?, state=?, district=?, l5=?, l4=?, User=?, designation=?, dob=?, mobile2=?, email=?, education_qualification=?, office_location=?, exp_crop_ins_year=?, exp_crop_ins_month=?, doc_type=?,card_id=?, gender=?, banf_ifsc=?, bank_name=?, bank_branch=?, bank_state=?,bank_branch_address=?, intermediary_type=?, intermediary_name = ?, intermediary_spoc =?, intermediary_mobile =?, intermediary_mail =?, intermediary_address =? "
							+ "where mobile1=?");

			ps.setString(1, data.getLevel());
			ps.setString(2, data.getState());
			ps.setString(3, data.getDistrict());
			ps.setString(4, data.getL5());
			ps.setString(5, data.getL4());
			ps.setString(6, data.getUser());
			ps.setString(7, data.getDesignation());
			// Date startDate=(Date) new
			// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
			// ps.setDate(8, startDate);
			ps.setString(8, data.getDob());

			ps.setString(9, data.getMobile2());
			ps.setString(10, data.getEmail());
			ps.setString(11, data.getEducation_qualification());
			ps.setString(12, data.getOffice_location());
			ps.setInt(13, data.getExp_crop_ins_year());
			ps.setInt(14, data.getExp_crop_ins_month());
			ps.setString(15, data.getDoc_type());
			// ps.setString(16, data.getPhoto_card());
			ps.setString(16, data.getCard_id());
			ps.setString(17, data.getGender());
			// FileInputStream fin = new FileInputStream(data.getCard_photo());
			// ps.setBlob(19, fin);
			// ps.setString(19, data.getCard_photo());
			// FileInputStream fin1 = new FileInputStream(data.getPhoto());
			// ps.setBlob(20, fin1);
			// ps.setString(20, data.getPhoto());
			ps.setString(18, data.getBanf_ifsc());
			ps.setString(19, data.getBank_name());
			ps.setString(20, data.getBank_branch());
			ps.setString(21, data.getBank_state());
			ps.setString(22, data.getBank_branch_address());
			ps.setString(23, id.getIntermediaryType());
			ps.setString(24, id.getIntermediaryName());
			ps.setString(25, id.getIntSpocName());
			ps.setString(26, id.getIntermediaryMobile());
			ps.setString(27, id.getIntermediaryMail());
			ps.setString(28, id.getIntermediaryAddress());
			ps.setString(29, data.getMobile1());

			ps.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			return false;
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	public static int getEmployeeID(String mobile1) {
		int EmpID = 0;
		Connection con = null;
		try {
			con = DBUtil.getConn();
			PreparedStatement pst = con.prepareStatement("SELECT empID from user_details WHERE mobile1=?");
			pst.setString(1, mobile1);
			ResultSet rs = pst.executeQuery();
			////// System.out.println(rs);
			while (rs.next()) {
				EmpID = rs.getInt("empID");
				////// System.out.println(EmpID);
			}

		} catch (SQLException e) {
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
			} catch (Exception e) {
//				e.printStackTrace();
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return EmpID;
	}

	public static int update_path(int eid, String relative_loc_photocard) throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getConn();
			PreparedStatement pst = con
					.prepareStatement("update user_details set relative_loc_photocard=? where empID ='" + eid + "' ");
			pst.setString(1, relative_loc_photocard);
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
