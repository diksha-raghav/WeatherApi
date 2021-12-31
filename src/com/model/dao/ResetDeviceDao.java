package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.DBUtil;

public class ResetDeviceDao {

//	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String driver = "";
	static String url = "";
	static String username = "";
	static String password = "";
	static JSONObject obj = new JSONObject();
	final static Logger logger = Logger.getLogger(FetchLocationDao.class);

	public static List<String> fetchmobile(String mb) {

		List<String> MobileList = new ArrayList<String>();

//		String mb = "54";
		org.json.simple.JSONArray mbarray = new JSONArray();
		String query = "SELECT MOBILE1 FROM user_details WHERE MOBILE1 LIKE '" + mb + "%'  ";

		try (Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(query);) {

			rs = ps.executeQuery();
			while (rs.next()) {
				MobileList.add(rs.getString("MOBILE1"));
			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return MobileList;
	}

	public static void updateDeviceId(String mobilenumber) {
		String query = "update user_login set Device_ID = ? where username = ?";
		try (Connection conn = DBUtil.getConn(); PreparedStatement preparedStmt = conn.prepareStatement(query);) {

			preparedStmt.setString(1, null);
			preparedStmt.setString(2, mobilenumber);

			preparedStmt.executeUpdate();

		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
	}

	public static void updatePassword(String pass, String mobilenumber) {
//		String pass = "abc";
//		String mobilenumber = "8449869816";
		String query = "update user_login set password = MD5(?) where username = ?";
		try (Connection conn = DBUtil.getConn(); PreparedStatement preparedStmt = conn.prepareStatement(query);) {

			preparedStmt.setString(1, pass);
			preparedStmt.setString(2, mobilenumber);
//	      System.out.println("after prepared");

			preparedStmt.executeUpdate();
//	      System.out.println("execute");

		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
	}

	public static void main(String args[]) {
//		ResetDeviceDao rd = new ResetDeviceDao();
//		fetchmobile();
//		rd.updatePassword();
	}

	public static List<String> fetchmobileBasedOnState(String mb, List<String> state_list) {
		List<String> MobileList = new ArrayList<String>();

//		String mb = "54";
		org.json.simple.JSONArray mbarray = new JSONArray();
		String states = getStateStringFromList(state_list);
		String query = "SELECT MOBILE1 FROM user_details WHERE MOBILE1 LIKE '" + mb + "%' and state in ('" + 
		states
				+ "')";
		
		
//		System.out.println(query);
		try (Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(query);) {

			rs = ps.executeQuery();
			while (rs.next()) {
				MobileList.add(rs.getString("MOBILE1"));
			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return MobileList;
	}

	public static String getStateStringFromList(List<String> state) {
		String delim = "','";
		return String.join(delim, state);
	}
}
