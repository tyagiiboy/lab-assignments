package app.acts.library.ui;

import java.util.Set;

import app.acts.library.pojo.Book;
import app.acts.library.pojo.Stock;

class RentalPage {
	static boolean run(boolean check, int change) {
		System.out.print("Enter userId: ");
		String userId = UI.sc.next();
		
		if (!UI.intInputValidator.test(userId)) {
			Integer.parseInt(userId);
			System.err.println("Invalid");
			return false;
		}
		
		if (!UI.usersList.containsKey(userId)) {
			System.err.println("Invalid!");
			return false;
		}
		
		System.out.println("Enter book details.");
		System.out.print("Genre: ");
		String genre = UI.sc.next();
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
		
		if (UI.usersList.get(userId).allotedBooks.contains(book) && check) {
			System.err.println("Already alloted.");
			return false;
		}
		
		Stock bookStock = new Stock(book);
		Set<Stock> stock = UI.library.get(genre);
		
		if (!stock.contains(bookStock)) {
			System.err.println("Invalid Book details");
			return false;
		}
		
		stock.stream().filter(st -> st.equals(bookStock))
		.forEach(retrievedStock -> {
			int availablity = retrievedStock.getTotal() - retrievedStock.getRented();
			if (availablity > 0 && check) {
				book.setPublishDate(retrievedStock.book.getPublishDate());
				UI.usersList.get(userId).allotedBooks.add(book);
				retrievedStock.setRented(retrievedStock.getRented() + change);
				System.out.println("Book added.");
			} else if (!check) {
				UI.usersList.get(userId).allotedBooks.remove(book);
				retrievedStock.setRented(retrievedStock.getRented() + change);
				System.out.println("Book retrieved.");
			} else {
				System.out.println("Out of stock!");
			}
		});
		
		return true;
	}
}
