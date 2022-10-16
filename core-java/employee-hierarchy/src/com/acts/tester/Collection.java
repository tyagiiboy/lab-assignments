package com.acts.tester;

import static java.lang.System.out;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.acts.abstracts.Employee;
import com.acts.concrete.ContractEmployee;
import com.acts.concrete.PermanentEmployee;
import com.acts.enums.Designation;

public class Collection {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		List<Employee> employeeList = new ArrayList<>();
		do {
			out.print("Main menu: Enter 0 for exit\n"
					+ "1. Add Permanent Employee \n"
					+ "2. Add Contractual Employee\n"
					+ "3. Show Employee details\n"
					+ "4. Remove Employee by name\n"
					+ "Enter your Choice >> ");
			choice = scanner.nextInt();

			switch (choice) {

			case 1 : {
				String designations = "(";

				for (Designation d: Designation.values()) {
					designations += (d.toString() + ", ");
				}

				System.out.println("Enter name, designations"+ designations + "), jDate, "
						+ "incentive, bonus, pf in same order");
				Employee emp = new PermanentEmployee(scanner.next(), scanner.next(), scanner.next(), 
						scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());

				employeeList.add(emp);

				System.out.println("Data added successfully....");

			} break;

			case 2 : {
				String designations = "(";

				for (Designation d: Designation.values()) {
					designations += (d.toString() + ", ");
				}

				System.out.println("Enter name, designations"+ designations + "), jDate, "
						+ "no of Days, daily rate in same order");
				Employee emp = new ContractEmployee(scanner.next(), scanner.next(), scanner.next(), 
						scanner.nextInt(), scanner.nextInt());

				employeeList.add(emp);

				System.out.println("Data added successfully....");

			} break;

			case 3 : {

				System.out.println("Employee details:");
				System.out.println(employeeList);

			} break;

			case 4 : {
				System.out.println("Enter employee ID to be deleted =>");
				int id = scanner.nextInt(), i = 0;
				
				for (Employee e: employeeList) {
					if (e.getEmpNum() == id) break;
					i++;
				}
				
				Employee e = employeeList.remove(i);
				
//				for(int i = 100; i==employeeList.size() + 100; i++ ) {
//					if(((Employee) employeeList).getName().equals(name)) {
//                         employeeList.remove();    
//					}
//				}  					
				
				System.out.println("Removed => " + e.toString());

			} break;

			}

		} while(choice!=0);

		scanner.close();
	}
}



