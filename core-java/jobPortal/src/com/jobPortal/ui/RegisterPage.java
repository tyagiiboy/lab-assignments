package com.jobPortal.ui;

import static com.jobPortal.ui.UI.sc;

import java.time.LocalDate;

import com.jobPortal.exceptions.InvalidDateException;
import com.jobPortal.exceptions.NumberMismatchException;
import com.jobPortal.lib.Degree;
import com.jobPortal.lib.JobSeeker;
import com.jobPortal.lib.ValidationUtil;

public class RegisterPage {

	public RegisterPage() {
		System.out.println("\n*****Enter Details*****");
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.print("Enter email: ");
		String email = sc.next();
		System.out.print("Enter password: ");
		String password = sc.next();
		System.out.print("Enter degree: ");
		String degree = sc.next();
		System.out.print("Enter dateOfBirth: ");
		String dateOfBirth = sc.next();
		System.out.print("Enter aadharId: ");
		String aadharId = sc.next();
		System.out.print("Enter phoneNumber: ");
		String phoneNumber = sc.next();
		System.out.print("Enter graduationDate: ");
		String graduationDate = sc.next();
		
		try {
			ValidationUtil.courseCheck(degree);
			ValidationUtil.dateCheck(graduationDate);
			ValidationUtil.dateCheck(dateOfBirth);
			ValidationUtil.numberCheck(phoneNumber, 10);
			ValidationUtil.numberCheck(aadharId, 12);
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		} catch (InvalidDateException ide) {
			System.err.println(ide.getMessage());
		} catch (NumberMismatchException nme) {
			System.err.println(nme.getMessage());
		}
		
		JobSeeker seeker = new JobSeeker(name, email, password, LocalDate.parse(dateOfBirth), 
				Long.parseLong(aadharId), Long.parseLong(phoneNumber), LocalDate.parse(graduationDate), 
				Degree.valueOf(degree));
		UI.list.add(seeker);
		System.out.println("\nUser registered: " + seeker.toString());
	}
	
}
