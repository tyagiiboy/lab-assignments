package com.acts.tester;

import java.text.ParseException;
import java.util.Scanner;

import com.acts.abstracts.Employee;
import com.acts.concrete.PermanentEmployee;
import com.acts.enums.Designation;


public class CaseOne {

	public static void run(Employee[] empArr, Scanner sc) {
		if (Main.count < Main.maxSize) {
			String designations = "(";
			
			for (Designation d: Designation.values()) {
				designations += (d.toString() + ", ");
			}
			
			System.out.println("Enter name, designations"+ designations + "), jDate, "
					+ "incentive, bonus, pf in same order");
			Employee emp = new PermanentEmployee();
			try {
				emp = new PermanentEmployee(sc.next(), sc.next(), sc.next(), 
						sc.nextDouble(), sc.nextDouble(), sc.nextInt());
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
