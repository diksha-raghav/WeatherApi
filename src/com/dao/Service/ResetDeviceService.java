package com.dao.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.dao.ResetDeviceDao;

public class ResetDeviceService {

	public static JSONArray getMobileNumbers(String mobile) {
		// ////System.out.println("THE STATE IS " + state);
		List<String> MobileList = ResetDeviceDao.fetchmobile(mobile);
		JSONArray mbarray = new JSONArray();
		for (String Mbnum : MobileList) {
			mbarray.add(Mbnum);
		}

		return mbarray;
	}

	public static void getParameters(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String mobilenumber = request.getParameter("mobile");
		ResetDeviceDao.updateDeviceId(mobilenumber);
	}

	public static void getParamforPassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String password = request.getParameter("pass");
		String mobilenumber = request.getParameter("mobile");
		ResetDeviceDao.updatePassword(password, mobilenumber);

	}

	public static JSONArray getMobileNumbers(String mobile, List<String> state_list) {
		List<String> MobileList = ResetDeviceDao.fetchmobileBasedOnState(mobile,state_list);
		JSONArray mbarray = new JSONArray();
		for (String Mbnum : MobileList) {
			mbarray.add(Mbnum);
		}

		return mbarray;
	}

}
