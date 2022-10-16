package com.bank.tester;

import java.text.ParseException;
import java.util.Scanner;

import com.bank.abstracts.Account;
import com.bank.concretes.FDAcc;
import com.bank.concretes.SavingACC;

public class AccountTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// savings acount tester
		System.out.println("Enter details: Acc no, Name, Curr Bal");
		SavingACC acc = new SavingACC(scanner.nextLong(), scanner.next(), scanner.nextDouble());
		System.out.println("Enter rate of interest and time");
		SavingACC.setRate(scanner.nextInt());
		int time = scanner.nextInt();
		
		System.out.println("Simple Interest = " + acc.simpleInterest(time));
		
		System.out.println(acc.toString());
		
		// FD account tester
		System.out.println("Enter details: Acc no, Name, FD amount, rate of interest, duration, date");
		Account accFd = new FDAcc();
		
		try {
			accFd = new FDAcc(scanner.nextLong(), scanner.next(), scanner.nextLong()
					, scanner.nextFloat(), scanner.nextInt(), scanner.next());
		} catch (ParseException pe) {
			System.out.println(pe.getMessage());
		}
		
		System.out.println("Simple Interest = " + ((FDAcc)accFd).simpleInterest());
		
		System.out.println(accFd.toString());
		
		scanner.close();
	}

}
