package com.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.dao.util.DBUtil;

public class MobileAjaxDao {
//	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String driver = "";
	static String url = "";
	static String username = "";
	static String password = "";
	static JSONObject obj = new JSONObject(), obj1 = new JSONObject();
	static List<String> mobileList = new ArrayList<String>();
	final static Logger logger = Logger.getLogger(MobileAjaxDao.class);

	public static List<String> fetchMobileList() {
		// TODO Auto-generated method stub

		String query = "SELECT DISTINCT user_details.mobile1 FROM user_details";

		try (Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(query);) {

			rs = ps.executeQuery();
			while (rs.next()) {

				mobileList.add(rs.getString("mobile1"));

			}

		} catch (Exception e) {
			logger.error(e);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		// return obj1;
		return mobileList;
	}

}
