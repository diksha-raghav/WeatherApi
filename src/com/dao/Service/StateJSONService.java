package com.dao.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.util.LocationUtils;

public class StateJSONService {

	@SuppressWarnings("unchecked")
	public static String[] getstatelist() {

		JSONObject state = LocationUtils.getLocationsHierarchyAll();
		JSONArray state_jsonarray = new JSONArray();
		@SuppressWarnings("unchecked")
		Set<String> key = state.keySet();
		Iterator<String> itr = key.iterator();
		List<String> stateList = new ArrayList<String>();
		while (itr.hasNext()) {
			state_jsonarray.add(itr.next());
		}
		if (state_jsonarray != null) {
			int t = state_jsonarray.size();
			for (int i = 0; i < t; i++) {
				stateList.add((String) state_jsonarray.get(i));
			}
		}
		int size = stateList.size();
		String[] stringArray = stateList.toArray(new String[size]);
		for (String s : stringArray) {
			// //////////System.out.println(s);
		}
		return stringArray;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public static JSONArray getstatelistwithjsonarray() {

		JSONObject state = LocationUtils.getLocationsHierarchyAll();
		JSONArray state_list = new JSONArray();
		Set<String> key = state.keySet();
		Iterator<String> itr = key.iterator();
		while (itr.hasNext()) {

			state_list.add(itr.next());
		}
		// //////////System.out.println(state_list.size());
		return state_list;
	}

	public static void main(String args[]) {
		String[] strq = getstatelist();
	}
}
