package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.dao.util.DBUtil;

public class UserStateMappingDao {

	public List<String> getStateFromUser(String username) {
		List<String> states = new LinkedList<String>();
		String sql = "SELECT * FROM weather.state_master where username=?";
		try (Connection con = DBUtil.getHikariConnection("wfms")) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//System.out.println("State is " + rs.getString(3));
				states.add(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;

	}
}
