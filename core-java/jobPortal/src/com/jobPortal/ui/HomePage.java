package com.jobPortal.ui;

public class HomePage {
	public HomePage() {
		System.out.print("********** Job Seeker Protal **********\n"
				+ "1. Register\n"
				+ "2. Update details\n"
				+ "3. Show All\n"
				+ "4. Sort by email\n"
				+ "5. Sort by Date of Birth\n"
				+ "6. Sort by Graduation Date\n"
				+ "0. Exit\n"
				+ ">> Choose(0 to 6): ");
		UI.choice = UI.sc.next();
	}
}
