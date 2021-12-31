package com.dao.Service;

import java.util.List;

import org.json.simple.JSONObject;

import com.model.dao.MobileAjaxDao;

public class MobileAjaxService {

	public static List getMobileList() {
		return MobileAjaxDao.fetchMobileList();

	}
}
