package com.dao.Service;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.LocationUtils;

public class DistrictService {
	public static JSONArray getDistrict(String state) {
		// //////////System.out.println("THE STATE IS " + state);
		Set districtSet = ((JSONObject) LocationUtils.getLocationsHierarchyAll().get(state.toUpperCase())).keySet();
		JSONArray districtsarray = new JSONArray();
		for (Object districts : districtSet) {
			districtsarray.add(districts);
		}

		return districtsarray;
	}

	public static void main(String args[]) {
		JSONArray arr = new JSONArray();
//		arr = getDistrict("RAJASTHAN");
//		////////////System.out.println(arr);
//		////////////System.out.println(arr.size());
		getDistrict("RAJASTHAN");
	}
}
