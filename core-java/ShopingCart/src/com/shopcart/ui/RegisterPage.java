package com.shopcart.ui;

import com.shopcart.user.User;

public class RegisterPage {

	static User run() {
		String userName = "";
		boolean isValid = false;
		do {
			System.out.print("Enter username: ");
			userName = UI.sc.next();
			if (!UI.users.isAdmin(userName) || !UI.users.isCustomer(userName)) isValid = true;
			else System.err.println("user already exits! try another username.");
		} while (!isValid);
		
		String pass = "", conf = ""; isValid = false;
		do {
			System.out.print("Create password: ");
			pass = UI.sc.next();
			System.out.print("Confirm password: ");
			conf = UI.sc.next();
			if (!pass.equals(conf)) System.err.println("password doesn't match try again.");
			else if (pass.length() < 8) System.err.println("Short password");
			else isValid = true;
		} while (!isValid);
		
		UI.sc.nextLine();
		System.out.print("Enter Full Name: ");
		String fullName = UI.sc.nextLine();
		
		System.out.println("User added.");
		
		return new User(userName, pass, fullName);
	}
	
}
