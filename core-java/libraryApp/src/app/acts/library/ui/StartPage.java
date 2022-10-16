package app.acts.library.ui;

class StartPage {
	static void run() {
		System.out.print("********** Library App **********\n"
				+ "1 Add book. \n"
				+ "2 Display All books\n"
				+ "3 Allot book to student ( quantity -1)\n"
				+ "4 Take book return ( quantity +1)\n"
				+ "5 Remove book\n"
				+ "6 Register new Student\n"
				+ "0 Exit\n"
				+ ">> Choice(0 to 6): \n");
		UI.choice = UI.sc.next();
	}
}
