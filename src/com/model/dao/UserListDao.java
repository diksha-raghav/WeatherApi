package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.DBUtil;

//import jsonArr.DatabaseConnector;

public class UserListDao {

	static Connection conn = null;
	static PreparedStatement ps = null;
	static JSONArray objarr = new JSONArray();
	final static Logger logger = Logger.getLogger(FetchLocationDao.class);

	@SuppressWarnings("unchecked")
	public JSONArray getUsers(String state,String district) {
		objarr.clear();
		
		Map<String,String> userList = new LinkedHashMap<String,String>();

		try {
			conn = DBUtil.getConn();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("Fatal Exception", e1);
		}
		String query = "SELECT empid, user from user_details where state=\""+state+"\" and district = \""+district+"\" order by user;";

		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {

				userList.put(rs.getString("empid"),rs.getString("user"));

			}
			

			for (Map.Entry<String, String> entry : userList.entrySet())
				
				
				{JSONObject obj = new JSONObject();
				obj.put("userid",entry.getKey());
				obj.put("username", entry.getValue());
				objarr.add(obj);
				}
			
		} catch (Exception e) {
			logger.error("Fatal Exception", e);
		}
//System.out.println(objarr);
		return objarr;
	}
}
