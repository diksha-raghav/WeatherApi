package com.model.dao;

import com.dao.util.PasswordUtils;

public class ProtectUserPassword {
	public static void main(String args[]) {
//		new ProtectUserPassword().createPassword("ro.thiruvananthapuram@aicofindia.com", "Aicnet@12102021");
		new ProtectUserPassword().updatePassword("ro.thiruvananthapuram@aicofindia.com", "Aicnet@12102021");

	}

	public boolean createPassword(String username, String password) {

		String myPassword = password;

		// Generate Salt. The generated value can be stored in DB.
		String salt = PasswordUtils.getSalt(30);

		// Protect user's password. The generated value can be stored in DB.
		String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
		// Print out protected password
		//// //////////System.out.println("My secure password = " + mySecurePassword);
		// ////////////System.out.println("Salt value = " + salt);

		// ////////////System.out.println(PasswordUtils.verifyUserPassword("abc",
		// mySecurePassword,
		// salt));
//		    //////////////System.out.println(PasswordUtils.generateSecurePassword("abc", "rjfuvSg1ah4bdG9U7CqQ3D74gMCOyD"));
		return UserDao.createUser(username, salt, mySecurePassword);

	}

	public boolean updatePassword(String username, String password) {

		String myPassword = password;

		// Generate Salt. The generated value can be stored in DB.
		String salt = PasswordUtils.getSalt(30);

		// Protect user's password. The generated value can be stored in DB.
		String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
		// Print out protected password
		//// //////////System.out.println("My secure password = " + mySecurePassword);
		// ////////////System.out.println("Salt value = " + salt);

		// ////////////System.out.println(PasswordUtils.verifyUserPassword("abc",
		// mySecurePassword,
		// salt));
//		    //////////////System.out.println(PasswordUtils.generateSecurePassword("abc", "rjfuvSg1ah4bdG9U7CqQ3D74gMCOyD"));
		return UserDao.updateUser(username, salt, mySecurePassword);

	}
}
