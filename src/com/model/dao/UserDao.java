package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.dao.util.PasswordUtils;

public class UserDao {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}
	final static Logger logger = Logger.getLogger(UserDao.class);

	/*
	 * public static void main(String args[]) { new
	 * ProtectUserPassword().createPassword("roBANGALOREgroup@aicofindia.com",
	 * "Aicnet@123"); }
	 */
	// Validates login with user input
	public boolean validateLogin(String em, String pw, String salt) {

		boolean isLogin = false;
		String query = "select * from Login where username=?";
		// Search database for email and password and return true if found
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, em);

			ResultSet rs;

			rs = ps.executeQuery();
			// ////////////System.out.println();

			isLogin = rs.next() ? PasswordUtils.verifyUserPassword(pw, rs.getString(2), salt) : false; // true if found
																										// else false

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return isLogin;
	}

	public String obtainSalt(String username) {

		String salt = null;
		String query = "select salt from Login where username=?";
		// Search database for email and password and return true if found
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, username);

			ResultSet rs;

			rs = ps.executeQuery();
			salt = rs.next() ? rs.getString(1) : null; // true if found else false

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return salt;
	}

	/*
	 * public LoginModel userSession(String username) { LoginModel user = new
	 * LoginModel(); // create new user object try { PreparedStatement ps =
	 * conn.prepareStatement("select * from Login where username=?");// search
	 * database for // email ps.setString(1, em);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * if (rs.next()) { user.setUserID(rs.getInt("userID"));
	 * user.setUsername(rs.getString("username"));
	 * user.setPsword(rs.getString("psword")); user.setEmail(rs.getString("email"));
	 * } } catch (SQLException e) { String message = "";for(StackTraceElement
	 * stackTraceElement : Thread.currentThread().getStackTrace()) { message =
	 * message + System.lineSeparator() + stackTraceElement.toString(); }
	 * logger.error(e+System.lineSeparator()+message); } return user; }
	 */

	// Creates a new user with input data
	public static boolean createUser(String user, String salt, String password) {

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("insert into Login(username,password,salt) values (?,?,?)");) {

			// user
			// to
			// database
			ps.setString(1, user);
			ps.setString(2, password);
			// //////////System.out.println("the password "+password);
//			ps.setString(3, user.getEmail());
			ps.setString(3, salt);
			// //////////System.out.println("the salt "+salt);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (

		Exception e) {
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);

		}
		return false;
	}

	// Creates a new user with input data
	public static boolean updateUser(String user, String salt, String password) {

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("update Login set password=? and salt=?  where username=?");) {

			// user
			// to
			// database
			ps.setString(3, user);
			ps.setString(1, password);
			System.out.println("the password " + password + user + salt);
//				ps.setString(3, user);
			ps.setString(2, salt);
			// //////////System.out.println("the salt "+salt);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (

		Exception e) {
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);

		}
		return false;
	}

	// Validates login with user input and returns role of valid user
	public String ValidateUser(String em, String pw, String salt) {
		String role = null;
//		Connection conn = null;

		boolean isLogin = false;
		String query = "select * from Login where username=?";
		// Search database for email and password and return true if found
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, em);

			ResultSet rs;

			rs = ps.executeQuery();
			// ////////////System.out.println();

			isLogin = rs.next() ? PasswordUtils.verifyUserPassword(pw, rs.getString(2), salt) : false; // true if found
																										// else false
			if (isLogin) {
				role = rs.getString(4);
				logger.info("User Validation successfull- " + em);
			} else {
				role = "invalid";
				logger.error("User validation failed- " + em);
			}

		} catch (Exception e) {
			logger.error(e);
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return role;
	}

	public static List<String> getState(String username) {
		List<String> stateList = new ArrayList<String>();

		Connection conn = null;
		try {

			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select state from state_master where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				stateList.add(rs.getString(1).toUpperCase());
			}
		} catch (Exception e) {

			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			// String message = "";for(StackTraceElement stackTraceElement :
			// Thread.currentThread().getStackTrace()) { message = message +
			// System.lineSeparator() + stackTraceElement.toString(); }
			// logger.error(e+System.lineSeparator()+message);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				String message = "";
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
			}
		}

		return stateList;
	}

}
