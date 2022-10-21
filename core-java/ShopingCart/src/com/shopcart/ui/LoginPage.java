package com.shopcart.ui;

import com.shopcart.user.User;

public class LoginPage {
	static boolean run() {
		String userName, password;

		System.out.println();

		System.out.print("Enter username: ");
		userName = UI.sc.next();
		if (!UI.users.contains(userName)) {
			System.err.println("No user found!");
			return false;
		}

		System.out.print("Enter password: ");
		password = UI.sc.next();

		User user = UI.users.getUser(userName);
		if (!user.getPassword().equals(password)) {
			System.err.println("wrong password");
			return false;
		}
		
		boolean isAdmin = UI.users.isAdmin(userName);
		
		if (isAdmin) {
			AdminPage.run();
		} else {
			CustomerPage.run();
		}
		
		return true;
	}
}
