package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.mode.entities.User_Registration;

public class ViewDao {
	final static Logger logger = Logger.getLogger(ViewDao.class);

	public ViewDao() {
	}

	public List<User_Registration> getAllUsers() {
		// //////////System.out.println("Get All users called");
		List<User_Registration> users = new ArrayList<User_Registration>();
		Connection con = null;
		try {
			con = DBUtil.getConn();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from user_details where active_inactive=1 and designation!='DEVELOPER'");
//			ResultSet rs = statement.executeQuery("select * from user_details ");
//			.executeQuery("select * from user_details where mobile1 is not null order by EmpID desc");

			while (rs.next()) {
				String mobile1 = rs.getString("mobile1");
				// //////System.out.println("The values of mobile are "+mobile1);
				String username = rs.getString("User");
				String designation = rs.getString("designation");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String state = rs.getString("State");
				String district = rs.getString("District");
				int status = rs.getInt("active_inactive");
				if (status == 1)
					users.add(new User_Registration(mobile1, username, designation, email, gender, state, district,
							"Active"));
				else
					users.add(new User_Registration(mobile1, username, designation, email, gender, state, district,
							"Inactive"));

			}
		} catch (SQLException e) {
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
			} catch (Exception e) {
//				logger.error(e);
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return users;
	}

	public User_Registration getUserByMobile(String mobile1) {
		User_Registration user = new User_Registration();
		Connection con = null;
		try {
			con = DBUtil.getConn();
			PreparedStatement preparedStatement = con.prepareStatement("select * from user_details where mobile1=?");
			preparedStatement.setString(1, mobile1);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// //////System.out.println("The values of mobile are "+mobile1);
				user.setMobile1(rs.getString("mobile1"));
				user.setUser(rs.getString("username"));
				user.setDesignation(rs.getString("designation"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
//			logger.error(e);
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
			} catch (Exception e) {
//				logger.error(e);
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return user;
	}

	public ArrayList<String> searchUserByMobile(String l) {
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		String data;
		try {
			con = DBUtil.getConn();
			String ch = l + "%";
			PreparedStatement ps = con
					.prepareStatement("SELECT mobile1 FROM user_details  WHERE mobile1  LIKE '" + ch + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("mobile1");
				//// //System.out.println(data);
				list.add(data);
			}
		} catch (Exception e) {
//			logger.error(e);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return list;
	}

	public static void changeStatus(String[] mobile, String status) {
//		int stat = 0;
		int stat = Integer.parseInt(status);
		System.out.println("Status "+stat);
//		ArrayList<String> mobilenumbers = new ArrayList<String>();
//		mobilenumbers.add(mobile1);
		/*
		 * mobilenumbers.add("6789798786"); mobilenumbers.add("6365489755");
		 * mobilenumbers.add("6523145698");
		 */
		Connection con = null;
		try {
			con = DBUtil.getConn();

			if (stat == 1) {
				for (String m : mobile) {
					String query = "update user_details set active_inactive = ? where mobile1 = ?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, m);
					System.out.println("PS1 " + preparedStmt);
					System.out.println("PS2 " + m);
					preparedStmt.executeUpdate();

					String query2 = "update user_login set active_deactive = ? where username = ?";
					PreparedStatement preparedStmt2 = con.prepareStatement(query2);
					preparedStmt2.setInt(1, 0);
					preparedStmt2.setString(2, m);

					preparedStmt2.executeUpdate();
				}

			} else {

				for (String m : mobile) {
					String query = "update user_details set active_inactive = ? where mobile1 = ?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, 1);
					preparedStmt.setString(2, m);

					preparedStmt.executeUpdate();

					String query2 = "update user_login set active_deactive = ? where username = ?";
					PreparedStatement preparedStmt2 = con.prepareStatement(query2);
					preparedStmt2.setInt(1, 1);
					preparedStmt2.setString(2, m);

					preparedStmt2.executeUpdate();
				}

			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

	}

	public String filePath(String mobile1) {
		String relative_loc_photocard = null;
		Connection con = null;
		try {
			con = DBUtil.getConn();
			PreparedStatement pst = con
					.prepareStatement("SELECT relative_loc_photocard from user_details WHERE mobile1=?");
			pst.setString(1, mobile1);
			ResultSet rs = pst.executeQuery();
			// System.out.println(rs);
			while (rs.next()) {
				relative_loc_photocard = rs.getString("relative_loc_photocard");
				// System.out.println(relative_loc_photocard);
			}

		} catch (SQLException e) {
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
			} catch (Exception e) {
//				e.printStackTrace();
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}
		return relative_loc_photocard;
	}

	public List<User_Registration> getAllUsers(List<String> stateactive) {
		// ////////System.out.println("Get All users called");
		List<User_Registration> users = new ArrayList<User_Registration>();
		String stateList = getStateStringFromList(stateactive);
		// System.out.println("StateList is " + stateList);
//		String sql = "select * from user_details where active_inactive=1 and state in (?)";
		// String sql = "select * from user_details where active_inactive=1 and state in
		// ('" + stateList + "')";
		String sql = "select * from user_details where state in ('" + stateList + "')";
		// System.out.println("query is" + sql);
		try (Connection con = DBUtil.getConn(); PreparedStatement statement = con.prepareStatement(sql);) {

//			statement.setString(1, stateList);
			ResultSet rs = statement.executeQuery();
//			//System.out.println(rs.first());
			while (rs.next()) {
				String mobile1 = rs.getString("mobile1");

				String username = rs.getString("User");
				String designation = rs.getString("designation");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String state = rs.getString("State");
				String district = rs.getString("District");
				int status = rs.getInt("active_inactive");
				if (status == 1)
					users.add(new User_Registration(mobile1, username, designation, email, gender, state, district,
							"Active"));
				else
					users.add(new User_Registration(mobile1, username, designation, email, gender, state, district,
							"Inactive"));

				/*
				 * for (User_Registration user : users) //System.out.println(user);
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return users;
	}

	public String getStateStringFromList(List<String> state) {
		String delim = "','";
		return String.join(delim, state);
	}
}
