package com.acts.concrete;

import java.text.ParseException;

import com.acts.abstracts.Employee;

public class ContractEmployee extends Employee {
	
	private int noOfDays;
	private int dailyRate;

	public ContractEmployee() {
		
		this.noOfDays = 0;
		this.dailyRate = 0;
		
	}
	
	public ContractEmployee(String name, String designation, 
			String jDate, int noofDays, int dailyRate) throws ParseException {
		
		super(name, designation, jDate);
		this.noOfDays = noofDays;
		this.dailyRate = dailyRate;
		
	}
	
	private double calculateSalary() {
		return dailyRate * noOfDays;
	}

	@Override
	public double getSalary() {
		return this.calculateSalary();
	}

	public double getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noofDays) {
		this.noOfDays = noofDays;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(int dailyRate) {
		this.dailyRate = dailyRate;
	}
	
	@Override
	public String toString() {
		return "ContractEmployee [" + super.toString() + " noofDays=" + noOfDays
				+ ", dailyRate=" + dailyRate + "]";
	}

}
