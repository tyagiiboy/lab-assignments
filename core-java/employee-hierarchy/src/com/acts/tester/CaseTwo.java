package com.acts.tester;

import java.text.ParseException;
import java.util.Scanner;

import com.acts.abstracts.Employee;
import com.acts.concrete.ContractEmployee;
import com.acts.enums.Designation;

public class CaseTwo {

	public static void run(Employee[] empArr, Scanner sc) {
		if (Main.count < Main.maxSize) {
			String designations = "(";
			
			for (Designation d: Designation.values()) {
				designations += (d.toString() + ", ");
			}
			
			designations += ")";
			
			System.out.println("Enter name, designations"+ designations + ", jDate, "
					+ "no of Days, daily rate \nin same order");
			Employee emp = new ContractEmployee();
			try {
				emp = new ContractEmployee(sc.next(), sc.next(), sc.next(), 
						sc.nextInt(), sc.nextInt());
				System.out.println("successfully added");
				
			} catch (ParseException pe){
				System.out.println("Format doesn't match!");
			}
			
			empArr[++Main.count] = emp;
			
		} else {
			
			System.out.println("Max Size reached!!");
		}
	}
}
