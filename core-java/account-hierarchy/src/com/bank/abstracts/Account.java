package com.bank.abstracts;

import com.bank.interfaces.Accountable;

public abstract class Account implements Accountable {

	private long accNum;
	private String accHolderName;
	
	public Account() {
		this.accHolderName = "";
		this.accNum = 0;
	}

	public Account(long accNum, String accHolderName) {
		this.accNum = accNum;
		this.accHolderName = accHolderName;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public long getAccNum() {
		return accNum;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accHolderName=" + accHolderName + "]";
	}
	
}
