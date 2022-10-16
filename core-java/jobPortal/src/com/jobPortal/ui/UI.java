package com.jobPortal.ui;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.jobPortal.lib.JobSeeker;

public class UI {
	
	public static String choice = "";
	public static Scanner sc;
	public static Set<JobSeeker> list;

	public UI() {
		list = new HashSet<>();
		sc = new Scanner(System.in);
		
		do {
			new HomePage();
			
			switch (choice) {
			case "0": break;
			
			case "1": {
				new RegisterPage();
			} break;
			
			case "2": {
				new UpdateDetailsPage();
			} break;
			
			case "3": {
				
				for(JobSeeker seeker : list) {
					System.out.println(seeker.toString());
				}
			} break;
			
			case "4": {
				Set<JobSeeker> sorted = new TreeSet<JobSeeker>(
						new Comparator<JobSeeker>() {
							@Override
							public int compare(JobSeeker o1, JobSeeker o2) {
								return o1.getEmail().compareTo(o2.getEmail());
							}
						});
				sorted.addAll(list);
				System.out.println(sorted);
			} break;
			
			case "5": {
				Set<JobSeeker> sorted = new TreeSet<JobSeeker>(
						new Comparator<JobSeeker>() {
							@Override
							public int compare(JobSeeker o1, JobSeeker o2) {
								return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
							}
						});
				sorted.addAll(list);
				System.out.println(sorted);
			} break;
			
			case "6": {
				Set<JobSeeker> sorted = new TreeSet<JobSeeker>(
						new Comparator<JobSeeker>() {
							@Override
							public int compare(JobSeeker o1, JobSeeker o2) {
								return o1.getGraduationDate().compareTo(o2.getGraduationDate());
							}
						});
				sorted.addAll(list);
				System.out.println(sorted);
			} break;
			
			default: {
				System.out.println("Choice doesn't match!! Try again.");
			}
			}
			
		} while (!choice.equals("0"));
		
		sc.close();
	}
	
}
