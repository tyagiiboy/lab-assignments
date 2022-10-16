package app.acts.library.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

import app.acts.library.enums.BookGenre;
import app.acts.library.pojo.Stock;
import app.acts.library.pojo.User;

public class UI {
	
	static Scanner sc;
	static String choice;
	static Map<String, Set<Stock>> library = new HashMap<>();
	static Map<String, User> usersList = new HashMap<>();
	
	static Predicate<String> 
	intInputValidator = (num) -> {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	};
	
	public UI() {
		initLibrary();
		sc = new Scanner(System.in);
		
		do {
			StartPage.run();
			
			switch (choice) {
			
			case "0": 
			{
				System.out.println("Bye");
				break;
			}
			
			case "1": 
			{
				AddBookPage.run();
			} break;
			case "2":
			{
				System.out.println(library);
			} break;
			
			case "3":
			{
				RentalPage.run(true, -1);
			} break;
			
			case "4":
			{
				RentalPage.run(false, 1);
			} break;
			
			case "5":
			{
				RemoveBook.run();
			} break;
			
			case "6":
			{
				System.out.println("Enter User details.");
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Email: ");
				String email = sc.next();
				
				if (usersList.containsKey(email)) {
					System.err.println("email exists!");
					break;
				}
				
				User newUser = new User(name, email);
				usersList.put(newUser.getUserId(), newUser);
				System.out.println("User added.");
			} break;
			
			default:
			{
				System.err.println("Worng Input choice.");
			}
			}
			
		} while (!choice.equals("0"));
		
	}
	
	static void initLibrary() {
		BookGenre[] bookTypes = BookGenre.values();
		for (BookGenre type : bookTypes) {
			library.put(type.name(), new HashSet<Stock>());
		}
	}
	
}
