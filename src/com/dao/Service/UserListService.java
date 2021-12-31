package com.dao.Service;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.LocationUtils;
import com.model.dao.UserListDao;

public class UserListService {
	public static JSONArray getDistrict(String state,String district) {
		// //////////System.out.println("THE STATE IS " + state);
		UserListDao ul=new UserListDao();
		return ul.getUsers(state,district);// LocationUtils.getLocationsHierarchyAll().get(state.toUpperCase())).keySet();
		
	}


}

