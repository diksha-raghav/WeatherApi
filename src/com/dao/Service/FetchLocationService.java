package com.dao.Service;

import org.json.simple.JSONObject;

import com.model.dao.FetchLocationDao;

public class FetchLocationService {
	public static JSONObject getLocations() {
		return FetchLocationDao.fetchStates();
	}
}
