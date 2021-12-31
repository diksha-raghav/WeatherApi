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

//import jsonArr.DatabaseConnector;

public class FetchLocationDao {

	static Connection conn = null;
	static PreparedStatement ps = null;
//	static ResultSet rs = null;
	static String driver = "";
	static String url = "";
	static String username = "";
	static String password = "";
	static JSONObject obj = new JSONObject();
	final static Logger logger = Logger.getLogger(FetchLocationDao.class);

	@SuppressWarnings("unchecked")
	public static JSONObject fetchStates() {
		// TODO Auto-generated method stub

		List<String> stateList = new ArrayList<String>();

		try {
			conn = DBUtil.getConn();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("Fatal Exception", e1);
		}
		String query = "SELECT DISTINCT location.STATE_NAME FROM location ";

		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {

				stateList.add(rs.getString("STATE_NAME"));

			}
			/*
			 * for (String s : stateList) ////////////System.out.println("state is " + s);
			 */

			for (String statename : stateList)
				obj.put(statename, district(statename));

			/*
			 * for (int i = 0; i < stateList.size(); i++) { obj.put(stateList.get(i),
			 * district(stateList.get(i))); // obj.put(stateList.get(i), "abc"); }
			 */
//			////////////System.out.println(obj);
		} catch (Exception e) {
			logger.error("Fatal Exception", e);
		}

		return obj;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject district(String stateName) {
		// TODO Auto-generated method stub
		JSONObject obj1 = new JSONObject();
		List<String> districtList = new ArrayList<String>();
//		conn = DBUtil.getConn();
		String query = "SELECT DISTINCT location.DISTRICT_NAME FROM location WHERE (STATE_NAME='" + stateName + "') ";

		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				districtList.add(rs.getString("DISTRICT_NAME"));

			}
			for (String districtname : districtList)
				obj1.put(districtname, loc4(stateName, districtname));
			/*
			 * for (int i = 0; i < districtList.size(); i++) { //
			 * obj1.put(districtList.get(i), loc4(stateName,districtList.get(i))); //
			 * obj1.put(districtList.get(i), "abc"); }
			 */
		} catch (Exception e) {
			logger.error("Fatal Exception: ", e);
		}

		return obj1;
	}

	@SuppressWarnings("unchecked")
	private static JSONArray loc4(String stateName, String districtName) {
		// TODO Auto-generated method stub
		org.json.simple.JSONArray arr = new JSONArray();
		// List<String> loc4List =new ArrayList<String>();
//		conn = DBUtil.getConn();
		String query = "SELECT DISTINCT location.LOCTN_4_NAME FROM location WHERE (STATE_NAME='" + stateName
				+ "' and DISTRICT_NAME='" + districtName + "')";

		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				arr.add(rs.getString("LOCTN_4_NAME"));
			}
		} catch (Exception e) {
			logger.error("Fatal Exception : ", e);
		}
		// ////////////System.out.println(arr);
		return arr;
	}
}
