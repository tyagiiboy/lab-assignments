package com.shopcart.ui;

import com.shopcart.exceptions.InvalidProductException;
import com.shopcart.shop.Product;
import com.shopcart.user.User;

public class AdminPage {
	static String choice;
	
	static void run() {
		do {
			System.out.print("\n"
					+ "***** Admin Page *****\n"
					+ "1. Add new product\n"
					+ "2. Update Stock for product\n"
					+ "3. Add new admin\n"
					+ "4. Update pricing and taxes for product\n"
					+ "0. LogOut\n"
					+ ">> ");
			choice = UI.sc.next();
			switch(choice) {
				case "0": {
					System.out.println("Logged Out");
				} break;
				
				case "1": {
					System.out.print("Enter product id: ");
					String id = UI.sc.next();
					
					if (!UI.stock.contains(id)) {
						UI.sc.nextLine();
						System.out.print("Enter product name: ");
						String name = UI.sc.nextLine();
						System.out.print("Enter brand name: ");
						String brandName = UI.sc.nextLine();
						System.out.print("Enter stock: ");
						String stock = UI.sc.next();
						Product product = null;
						try {
							product = new Product(id, name, brandName, Integer.parseInt(stock));
						} catch (NumberFormatException exp) {
							System.err.println("value contains characters. Default value added.");
							product = new Product(id, name, brandName, 1);
						}
						System.out.println("Product added to list.");
						try {
							UI.stock.addNewToStock(product);
						} catch (InvalidProductException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Product id already exists");
					}
				} break;
				
				case "2": {
					System.out.print("Enter Product Id and new stock: ");
					String id = UI.sc.next();
					Integer number = UI.isValidInt(UI.sc.next());
					if (number == null) {
						System.err.println("Invalid integer input.");
						break;
					}
					try {
						UI.stock.updateStock(id, number);
						System.out.println("Updated.");
					} catch (InvalidProductException e) {
						System.err.println(e.getMessage());
					}
				} break;
				
				case "3": {
					User user = RegisterPage.run();
					UI.users.addAdmin(user);
				} break;
				
				case "4": {
					System.out.print("Enter Product Id: ");
					String id = UI.sc.next();
					System.out.print("Enter price and tax");
					Integer price = UI.isValidInt(UI.sc.next());
					Integer tax = UI.isValidInt(UI.sc.next());
					if (price == null || tax == null) {
						System.err.println("Invalid integer input.");
						break;
					}
					
					try {
						UI.stock.updatePriceAndTax(id, price, tax);
					} catch (InvalidProductException e) {
						System.out.println(e.getMessage());
					}
				} break;
				
				default: {
					System.err.println("typos!!");
				}
			}
		} while (!choice.equals("0"));
	}
}
