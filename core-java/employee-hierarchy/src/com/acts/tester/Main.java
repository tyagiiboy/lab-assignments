package com.acts.tester;

import java.util.Scanner;
import static java.lang.System.out;

import com.acts.abstracts.Employee;

public class Main {
	public static int choice, count = 0;
	public static final int maxSize = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee[] empArr = new Employee[maxSize];
		
		do {
			out.print("Main menu: Enter 0 for exit\n"
					+ "1. Add Permanent Employee\n"
					+ "2. Add Contractual Employee\n"
					+ "3. Show all Permanent Employees\n"
					+ "4. Show all Contractual Employees\n"
					+ "\n"
					+ "Choice >> ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: {
					CaseOne.run(empArr, sc);
				}
				break;
				
				case 2: {
					CaseTwo.run(empArr, sc);
				}
				break;

				case 3: {
					CaseThree.run(empArr, sc);
				}
				break;
				
				case 4: {
					CaseFour.run(empArr, sc);
				}
				
				case 0:
					break;
					
				default: {
					System.out.println("Wrong choice!");
				}
			} 
					
		} while (choice != 0);
		
		sc.close();
	}
}
