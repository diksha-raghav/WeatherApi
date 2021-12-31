package com.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.mode.entities.LiveUsers;

public class LiveUsersDao {

	final static Logger logger = Logger.getLogger(LiveUsersDao.class);

	public int fetchcount() {
		int count = 0;
		try (Connection con = DBUtil.getConn();) {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT COUNT(empId) FROM user_details where active_inactive=1 and designation!='DEVELOPER'");
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return count;

	}

	public ArrayList fetchcountbyState() {
		ArrayList<LiveUsers> userbystate = new ArrayList<LiveUsers>();
		try (Connection con = DBUtil.getConn();) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT State,COUNT(empId) FROM user_details where active_inactive=1 AND DESIGNATION!='DEVELOPER' GROUP BY State order by count(EmpId) desc");
			while (rs.next()) {
				LiveUsers ob = new LiveUsers(rs.getString(1), rs.getInt(2));
				userbystate.add(ob);
			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);

		}
		return userbystate;

	}

	public int fetchformcount() {
		int formcount = 0;
		try (Connection con = DBUtil.getConn();) {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(*) FROM VBAK where USERID >10");
			rs.next();
			formcount = rs.getInt(1);
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return formcount;

	}

	public ArrayList fetchcountbyForm() {
		ArrayList<LiveUsers> userbyform = new ArrayList<LiveUsers>();
		try (Connection con = DBUtil.getConn();) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT FORMNAME, count(*) FROM VBAK where USERID > 10  group by FORMNAME order by  count(*) desc");
			while (rs.next()) {
				LiveUsers ob = new LiveUsers(rs.getString(1), rs.getInt(2));
				userbyform.add(ob);
			}
		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return userbyform;

	}

}
