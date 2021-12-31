package com.dao.Service;

import java.util.List;

import com.model.dao.UserDao;

public class UserDaoService {
	public static String isuservalid(String username, String password) {
		UserDao userdao = new UserDao();
		return userdao.ValidateUser(username, password, userdao.obtainSalt(username));

	}

	public static List<String> getStateList(String username) {

		return UserDao.getState(username);
	}
}
