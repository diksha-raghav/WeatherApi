package com.dao.util;

import java.util.List;

import org.json.simple.JSONObject;

import com.controllers.servlet.MobileAjaxController;
import com.dao.Service.MobileAjaxService;

public class MobileAjaxUtil 
{
	public static List getMobileAll() //JSONObject
	{
		if (MobileAjaxController.mobileList != null) {
//			/////if (MobileAjaxController.mobile_hierarchy_all != null)
			// //////////System.out.println("Called for the first time");
			return MobileAjaxController.mobileList;
			//return MobileAjaxController.mobile_hierarchy_all;
		} else {
			// //////////System.out.println(FetchLocations.location_hierarchy_all);
			MobileAjaxController.mobileList = MobileAjaxService.getMobileList();
			//MobileAjaxController.mobile_hierarchy_all = MobileAjaxService.getNumber();
		}
		return MobileAjaxController.mobileList;

	}
		
	}


