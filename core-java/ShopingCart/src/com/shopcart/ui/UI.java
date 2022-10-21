package com.shopcart.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.shopcart.shop.Product;
import com.shopcart.shop.Stock;
import com.shopcart.user.User;
import com.shopcart.user.Users;

public class UI 
{
	static Stock stock;
	static Scanner sc;
	static String choice;
	static Users users;
	static Map<String, Product> bucket;
	
	public UI() {
		sc = new Scanner(System.in);
		stock = new Stock(true);
		bucket = new HashMap<>();

		try {
			users = new Users();
		} catch (IOException e) {
			System.out.println("Server Down, come back later.");
			System.exit(0);
		}
		
		do {
			
			System.out.print("\n\n*****Welcome to shopping express*****\n"
					+ "1. Login\n"
					+ "2. Register\n"
					+ "0. Exit\n"
					+ ">> ");
			choice = sc.next();
			
			switch (choice) {
				case "0": {
					System.out.println("Bye...");
					users.saveAll();
					stock.saveStock();
				} break;
				
				case "1": {
					LoginPage.run();
				} break;
				
				case "2": {
					User user = RegisterPage.run();
					users.addCustomer(user);
					System.out.println("You may Login.");
				} break;
				
				default: {
					System.err.println("Ops typo, try again.");
				}
			}
			
		} while (!choice.equals("0"));
	}
	
	static Integer isValidInt(String integer) {
		try {
			return Integer.parseInt(integer);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
