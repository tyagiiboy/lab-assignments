package com.acts.abstracts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.acts.enums.Designation;
import com.acts.interfaces.Payable;

public abstract class Employee implements Payable {


	private int empNum;
//	private long salary;
	private String name;
	private Designation designation;
	private Date jDate;
	public static int EMP_ID_START = 100;
	public static int count = 0;
	public static final String EMPTY = "";


	public Employee() {
		this.empNum = 0;
		this.name = EMPTY;
//		this.salary = 0;
		this.designation = null;
		this.jDate = null;
		Employee.count++;
	}

	public Employee(String name, String designation, 
			String jDate) throws ParseException {

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		this.name = name;
//		this.salary = salary;
		this.designation = Designation.valueOf(designation);
		this.jDate = date.parse(jDate);
		this.empNum = EMP_ID_START++;

		Employee.count++;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setDesignation(String designation) {
		this.designation = Designation.valueOf(designation);
	}

	public String getDesignation() {
		return designation.toString();
	}

	public String getJoiningDate() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		return date.format(this.jDate);
	}
	
	@Override
	public abstract double getSalary();

	@Override
	public String toString() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = "";

		if (this.jDate != null) strDate = date.format(jDate);

		return "Employee [Id: " + empNum + ", Name: " + name 
				+ ", Designation: " + designation.toString()
		+ ", Joining Date: " + strDate;
	}

}
