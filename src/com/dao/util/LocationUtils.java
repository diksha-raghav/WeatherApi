package com.dao.util;

import org.json.simple.JSONObject;

import com.controllers.servlet.FetchLocations;
import com.dao.Service.FetchLocationService;

public class LocationUtils {
	public static JSONObject getLocationsHierarchyAll() {

		if (FetchLocations.location_hierarchy_all != null) {
//			////////////System.out.println(FetchLocations.location_hierarchy_all);
			// //////////System.out.println("Called for the first time");
			return FetchLocations.location_hierarchy_all;
		} else {
			// //////////System.out.println(FetchLocations.location_hierarchy_all);
			FetchLocations.location_hierarchy_all = FetchLocationService.getLocations();
		}
		return FetchLocations.location_hierarchy_all;

	}

}
