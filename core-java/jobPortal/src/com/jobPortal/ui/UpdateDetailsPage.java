package com.jobPortal.ui;

import static com.jobPortal.ui.UI.sc;

import com.jobPortal.lib.Degree;
import com.jobPortal.lib.JobSeeker;
import com.jobPortal.lib.ValidationUtil;

public class UpdateDetailsPage {
	private String choice = "";
	public UpdateDetailsPage() {
		do {
			JobSeeker record= searchRecord();
			
			if (null == record) {
				System.out.println("No such id!");
				break;
			}
			
			System.out.print("***** Update details*****\n"
					+ "1. Email update\n"
					+ "2. Name update\n"
					+ "3. Change Password\n"
					+ "4. Change Degree\n"
					+ "0. Exit\n"
					+ "Choice >>");
			choice = sc.next();

			switch(choice) {

			case "0": new UI();

			case "1": {


				System.out.println("Enter new Email :");

				record.setEmail(sc.next());

				System.out.println(record.toString());

			} break;

			case "2": {

				System.out.println("Enter name :");

				record.setName(sc.next());

				System.out.println(record.toString());

			} break;

			case "3": {

				System.out.println("Enter new Password :");

				record.setPassword(sc.next());

				System.out.println(record.toString());

			} break;

			case "4": {

				System.out.println("Enter new Degree :");
				String degree = sc.next();

				try {
					ValidationUtil.courseCheck(degree);
					record.setDegree(Degree.valueOf(degree));
					System.out.println(record.toString());
				} catch (IllegalArgumentException iae) {
					System.err.println(iae.getMessage());
				}

				} break;
			}
			choice = "0";
			}while(!(choice.equals("0")));
		}

		public static JobSeeker searchRecord() {
			System.out.println("Enter registration ID : ");
			Integer id = sc.nextInt();
			for(JobSeeker jSeeker : UI.list) {
				if(id.equals(jSeeker.getRegistrationId())) return jSeeker;
			} 
			return null;
		} 

	}