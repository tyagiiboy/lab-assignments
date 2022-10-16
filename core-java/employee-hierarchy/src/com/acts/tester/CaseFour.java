package com.acts.tester;

import java.util.Scanner;

import com.acts.abstracts.Employee;
import com.acts.concrete.ContractEmployee;

public class CaseFour {

	public static void run(Employee[] empArr, Scanner sc) {
		for (int i = 0; i < empArr.length; i ++) {
			if (empArr[i] instanceof ContractEmployee) {
				System.out.println(empArr[i].toString());
				System.out.println();
			}
		}
	}
}
