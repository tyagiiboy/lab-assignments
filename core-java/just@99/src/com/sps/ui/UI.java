package com.sps.ui;

import java.util.Scanner;

import com.just.at.nn.Cart;
import com.just.at.nn.Stock;

public class UI {

	private int choice = -1;
	private Stock stock;
	private Cart cart;
	private Scanner sc;

	public UI() {
		stock = new Stock(10000);
		cart = new Cart();
		sc = new Scanner(System.in);
		menu();
		sc.close();
	}

	public void menu() {

		do {
			printStartMenu();
			choice = getUserInput();
		//	getKeyPress();

			switch (choice) {
			case -1: break;
			case 0: System.exit(0);

			case 1: {
				consumerMenu();
			} break;

			case 2: {
				producerMenu();

			} break;
			}
			choice = -1;
		} while (choice != 0);
	}

	public void consumerMenu() {
		boolean purchased = false;

		do {
			printConsumerMenu();
			//getKeyPress();
			choice = getUserInput();
			//getKeyPress();

			switch (choice) {
			case -1: break;
			case 0: {
				if (purchased) {
					System.out.println("Pay bill: " +cart.getPayableAmmount());
					System.out.print("Enter to pay.");
					getKeyPress();
				}
				System.out.println("\n Visit again....");
				
			} choice = -1;
			System.exit(0);

			case 1: {
				System.out.println("Id Name Price Discount");
				System.out.println(stock.toStringEachIfAvailable());
			//	System.out.print("Enter to continue");
			//	getKeyPress();
			} break;

			case 2: {
				System.out.print("Enter product Id to add to cart: ");
				Integer id = getUserInput() - 1;
				getKeyPress();
				System.out.print("How many? ");
				Integer count = getUserInput();
			//	getKeyPress();
				count = stock.remove(id, count);
				System.out.print(cart.add(id, count));
				System.out.println("Added " + count + " Item (ID : " + (id + 1) + ")"
						+ " to your cart");
				purchased = true;
			} break;

			case 3: {
				System.out.println(cart.toString());
			} break;
			
			case 4 : {
				menu();
				
			} break;
			
			}
			choice = -1;
			
		} while (choice != 0);		
	}

	public void producerMenu() {

		do {
			printProducerMenu();
		//	getKeyPress();
			choice = getUserInput();
			// getKeyPress();

			switch (choice) {
			case -1: break;
			case 0: System.exit(0);

			case 1: {
				System.out.println("Id Name Price Discount");
				System.out.println(stock.toStringEachIfAvailable());
		//		System.out.print("Enter to continue");
		//		getKeyPress();
			} break;

			case 2: {
				System.out.print("Enter product Id to add into Stock: ");
				Integer id = getUserInput();
				System.out.println("Enter number of piece you want to add : ");
				Integer count = getUserInput();
				System.out.println("Total stock :" +stock.add(id, count));

			} break;

			case 3: {
				System.out.print("Enter product Id to remove product from stock: ");
				Integer id = getUserInput();
				System.out.println("Enter number of items you want remove : ");
				Integer count = getUserInput();
				stock.remove(id, count);
				System.out.println("Product removed ");
			} break; 

			case 4 : {
				menu();

			} break;
			
			}
			choice = -1;
			
		} while (choice != 0);		
	}

	public void printStartMenu() {
		System.out.print("\n*************Menu*************\n"
				+ "1. Consumer\n"
				+ "2. Producer\n"
				+ "0. Exit\n"
				+ "Choice >> ");
	}

	public void printConsumerMenu() {
		System.out.print("\n"
				+ "1. See available items\n"
				+ "2. Buy Item\n"
				+ "3. Your Cart\n"
				+ "4. Goto Start Menu\n"
				+ "0. Pay  and exit\n"
				+ "Enter choice >> ");
	}

	public void printProducerMenu() {
		System.out.print("\n"
				+ "1. See available stock\n"
				+ "2. Add stock\n"
				+ "3. Remove Stock\n"
				+ "4. Goto Start Menu\n"
				+ "0. Exit\n"
				+ "Enter choice >> ");
	}

	public int getUserInput() {
		String ch = sc.next();
		Integer intCh = -1;
		try {
			intCh = Integer.parseInt(ch, 10);
		} catch (NumberFormatException e) {
			System.out.println("Wrong Input");
		}
		return intCh;
	}

	public void getKeyPress() {
		sc.nextLine();
	}

}
