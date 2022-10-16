package com.acts.concrete;

import java.text.ParseException;

import com.acts.abstracts.Employee;

public class PermanentEmployee extends Employee {

	private double incentive;
	private double bonus;
	private int pf;
	
	public PermanentEmployee() {
		super();
		this.incentive = 0;
		this.bonus = 0;
		this.pf = 0;
	}

	public PermanentEmployee(String name, String designation, String jDate, 
			double incentive, double bonus, int pf) throws ParseException {
		super(name, designation, jDate);
		
		this.incentive = incentive;
		this.bonus = bonus;
		this.pf = pf;
	}
	
	private double calculateSalary() {
		return this.incentive * this.bonus;
	}
	
	@Override
	public double getSalary() {
		return this.calculateSalary();
	}

	public double getIncentive() {
		return incentive;
	}

	public double getBonus() {
		return bonus;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPf() {
		return pf;
	}
	
	@Override
	public String toString() {
		return "\nPermanentEmployee [ " + super.toString() + " incentive=" + incentive + ", bonus=" + bonus + ", pf=" + pf + "]";
	}

}
