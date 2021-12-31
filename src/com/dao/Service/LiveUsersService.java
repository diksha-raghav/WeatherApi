package com.dao.Service;

import java.util.ArrayList;

import com.mode.entities.LiveUsers;
import com.model.dao.LiveUsersDao;

public class LiveUsersService {
	public static int fetchcount() {
		return new LiveUsersDao().fetchcount();
	}

	public static ArrayList fetchcountbyState() {

		ArrayList<LiveUsers> userbystate = new LiveUsersDao().fetchcountbyState();
		return userbystate;
	}

	public static int fetchformcount() {
		return new LiveUsersDao().fetchformcount();
	}

	public static ArrayList fetchcountbyForm() {

		return new LiveUsersDao().fetchcountbyForm();
	}

}
