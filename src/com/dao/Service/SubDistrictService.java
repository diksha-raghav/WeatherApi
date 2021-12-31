package com.dao.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.LocationUtils;

public class SubDistrictService {
	public static JSONArray getSubDistrict(String state, String district) {
		// //////////System.out.println("THE STATE IS " + state);
		// //////////System.out.println("The district is " + district);
		// //////////System.out.println(LocationUtils.getLocationsHierarchyAll().get(state));

		JSONObject districts = (JSONObject) LocationUtils.getLocationsHierarchyAll().get(state.toUpperCase());
		JSONArray subdistricts = (JSONArray) districts.get(district.toUpperCase());

		return subdistricts;
		/*
		 * JSONArray districtsarray = new JSONArray(); for (Object districts :
		 * subdistrictSet) { districtsarray.add(districts); }
		 */

//		return districtsarray;
	}

	public static void main(String args[]) {
		JSONArray arr = new JSONArray();
//		arr = getDistrict("RAJASTHAN");
//		////////////System.out.println(arr);
//		////////////System.out.println(arr.size());
		getSubDistrict("RAJASTHAN", "JHALAWAR");
	}
}
