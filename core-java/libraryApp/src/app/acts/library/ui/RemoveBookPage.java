package app.acts.library.ui;

import java.util.Set;

import app.acts.library.pojo.Book;
import app.acts.library.pojo.Stock;

class RemoveBookPage {
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
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		Stock newBook =  new Stock(book);
		
		if (UI.library.get(genre).contains(newBook)) {
			Set<Stock> bookSet = UI.library.get(genre);
			bookSet.remove(newBook);
		} else {
			System.out.println("No such Book.");
		}
		
		return true;
	}
}
