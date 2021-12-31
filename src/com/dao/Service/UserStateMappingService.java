package com.dao.Service;

import java.util.List;

import com.model.dao.UserStateMappingDao;

public class UserStateMappingService {

	public List<String> getStatesFromUsersService(String username)
	{
		return new UserStateMappingDao().getStateFromUser(username);
	}
}
