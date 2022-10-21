package com.shopcart.ui;

import java.util.List;
import java.util.stream.Collectors;

import com.shopcart.exceptions.InvalidProductException;
import com.shopcart.shop.Product;

public class CustomerPage {
	static String choice = "";
	static void run() {
		do {
			System.out.print("\n"
					+ "1. See available products\n"
					+ "2. Add to cart\n"
					+ "3. Remove from cart\n"
					+ "4. Generate bill\n"
					+ "0. logOut\n"
					+ ">> ");
			choice = UI.sc.next();
			
			switch (choice) {
			
			case "0": {
				System.out.println("logged out..");
			} break;
			
			case "1": {
				System.out.println();
				System.out.println(UI.stock.toString());
			} break;
			
			case "2": {
				System.out.print("Enter product id: ");
				String id = UI.sc.next();
				Product product = null;
				try {
					product = UI.stock.getProduct(id);
				} catch (InvalidProductException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.print("enter quantity: ");
				Integer input = UI.isValidInt(UI.sc.next());
				if (input == null) {
					System.err.println("invalid integer input");
					break;
				}
				
				if (UI.bucket.containsKey(id)) {
					UI.bucket.get(id).setStock(input);
				} else {
					Product userProduct = new Product(product.getProductId(), 
							product.getProductName(),
							product.getBrandName(),
							input);
					UI.bucket.put(id, userProduct);
					System.out.println("Product added.");
				}
			} break;
			
			case "3": {
				System.out.print("Enter product id: ");
				String id = UI.sc.next();
				if (!UI.bucket.containsKey(id)) {
					System.out.println("Wrong Id");
					break;
				}
				System.out.println("enter quantity");
				Integer input = UI.isValidInt(UI.sc.next());
				if (input == null) {
					System.err.println("invalid integer input");
					break;
				}
				if (input >= UI.bucket.get(id).getStock()) {
					UI.bucket.remove(id);
				} else {
					UI.bucket.get(id).setStock(UI.bucket.get(id).getStock() - input);
				}
				System.out.println("Item/s removed");
			} break;
			
			case "4": {
				Double bill = 0.0;
				System.out.println("Your bucket: ");
				List<Product> list = UI.bucket.values().stream().collect(Collectors.toList());
				for (Product p : list) {
					System.out.println(p.toString());
					bill += (p.getPrice() + p.getTax()) * p.getStock();
				}
				System.out.println("Bill ammount: " + bill.toString());
			} break;
			
			default: {
				System.err.println("typos!");
			}
			
			}
		} while (!choice.equals("0"));
	}
}
