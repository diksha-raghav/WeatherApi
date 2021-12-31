package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.controllers.servlet.IFSCController;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.DBUtil;

//import com.dao.util.DBUtil;
public class IFSCDao {
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String driver = "";
	static String url = "";
	static String username = "";
	static String password = "";

	final static Logger logger = Logger.getLogger(IFSCDao.class);

	@SuppressWarnings("unused")
	public static String[] getBankName(String ifsc) {
		JSONObject bankdetails = IFSCController.bankdetail;
		// ArrayList a=bankdetails.toJSONString(ifsc);
		String query = "SELECT * FROM AC_BANK_IFSC_MST WHERE ifsc='" + ifsc + "' ";

		String[] bank = new String[4];
		try (Connection conn = DBUtil.getConn();) {

			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			String bank_name = null, bank_branch = null, bank_state = null, bank_addr = null;
			while (rs.next()) {
				bank_name = rs.getString("BANK_NAME");
				System.out.println(bank_name);
				bank_branch = rs.getString("BRANCH");
				System.out.println(bank_branch);
				bank_state = rs.getString("STATE_NAME");
				System.out.println(bank_state);
				bank_addr = rs.getString("ADDRESS");
				System.out.println(bank_addr);
			}
			bank[0] = bank_name;
			bank[1] = bank_branch;
			bank[2] = bank_state;
			bank[3] = bank_addr;
			// return bank;

		} catch (Exception e) {
			logger.error(e);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return bank;

	}

	public static void main(String args[]) {
		// String[]arg= getBankName("SBIN0008942");
		// System.out.println(arg);
		// List<String> list=getBankList();
		// System.out.println(list);
		JSONObject a = getAllBankDetails();

		System.out.println(a);
	}

	public static List<String> getBankList() {
		String query = "SELECT DISTINCT bank_name FROM AC_BANK_IFSC_MST ORDER BY bank_name ASC";
		List<String> banklist = new ArrayList<String>();

		try (Connection conn = DBUtil.getConn();) {

			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				banklist.add(rs.getString("bank_name"));
			}

		} catch (Exception e) {
			logger.error(e);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}

		return banklist;

	}

	@SuppressWarnings({ "null", "unchecked" })
	public static JSONObject getAllBankDetails() {
		String query = "SELECT IFSC,BANK_NAME,BRANCH,STATE_NAME,ADDRESS FROM AC_BANK_IFSC_MST";

		// ArrayList<String> banks = null;

		JSONObject json = new JSONObject();
		String[] bank = new String[4];
		try (Connection conn = DBUtil.getConn();) {

			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			String bank_name = null, bank_branch = null, bank_state = null, bank_addr = null, ifsc = null;
			while (rs.next()) {
				bank_name = rs.getString("BANK_NAME");
				// System.out.print(bank_name);
				bank_branch = rs.getString("BRANCH");
				// System.out.print(bank_branch);
				bank_state = rs.getString("STATE_NAME");
				// System.out.print(bank_state);
				bank_addr = rs.getString("ADDRESS");
				ifsc = rs.getString("IFSC");
				// System.out.print(bank_addr);
				// System.out.println(ifsc);
				JSONArray list = new JSONArray();
				list.add(bank_name);
				list.add(bank_branch);
				list.add(bank_state);
				list.add(bank_addr);
				json.put(ifsc, list);

			}

		} catch (SQLException e) {
			logger.error(e);
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return json;

	}

}
