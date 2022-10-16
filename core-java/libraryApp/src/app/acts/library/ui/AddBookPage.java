package app.acts.library.ui;

import app.acts.library.pojo.Book;
import app.acts.library.pojo.Stock;
import app.acts.library.utils.DateValidator;

class AddBookPage {
	static int q = 1;
	
	static boolean run() {
		System.out.println("Enter book details.");
		
		System.out.print("Genre: ");
		String genre = UI.sc.next();
		
		if (!UI.library.containsKey(genre)) {
			System.err.println("Invalid!");
			return false;
		}
		
		System.out.print("Title: ");
		String title = UI.sc.next();
		System.out.print("Author's name: ");
		String author = UI.sc.next();
		System.out.print("Publisher's name: ");
		String publisher = UI.sc.next();
		
		System.out.print("Publish date(YYYY-MM-DD): ");
		String date = UI.sc.next();
		
		if (!DateValidator.inValidFormat(date) || !DateValidator.isBefore(date)) {
			System.err.println("Invalid");
			return false;
		}
		
		System.out.print("Quantity: ");
		String quantity = UI.sc.next();
		
		if (!UI.intInputValidator.test(quantity)) System.out.println("Invalid Quantity adding 1(default)");
		else q = Integer.parseInt(quantity);
		
		Stock newBook =  new Stock(new Book(title, author, publisher, date));
		newBook.setTotal(q);
		
		if (!UI.library.get(genre).contains(newBook)) UI.library.get(genre).add(newBook);
		else {
			UI.library.get(genre).stream()
			.filter(stock -> stock.equals(newBook))
			.forEach(stock -> stock.setTotal(stock.getTotal() + q));
		}
		return true;
	}
}
