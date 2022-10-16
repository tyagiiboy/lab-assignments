package com.bank.concretes;

import com.bank.abstracts.Account;
import com.bank.exceptions.*;

public class SavingACC extends Account {

	private static final double MIN_BAL = 3000;
	private static float rate;
	private double currBal;

	public SavingACC() {
		super();
		this.currBal = MIN_BAL;
	}

	public SavingACC(long accNum, String name, double currBal) {
		super(accNum, name);
		this.currBal = currBal;
	}

	public double simpleInterest(int time) {
		return (this.currBal * rate * time) / 100;
	}

	public double getCurrBal() {
		return currBal;
	}

	public static void setRate(float rate) {
		SavingACC.rate = rate;
	}

	public static float getRate() {
		return rate;
	}

	@Override
	public String credit(double creditAmmount) {

		currBal = currBal + creditAmmount;
		return "Your current balance is ->" + currBal;	
	}

	@Override
	public String debit(double debAmmount) throws MinimumBalanceException {

		if((currBal - debAmmount) >= MIN_BAL) {
			currBal = currBal - debAmmount;
		} 
		
		else {
			MinimumBalanceException mbe = new MinimumBalanceException("Maan lijiye aap gareeb hai..");
			throw mbe;
		}
		
		return "You have debited -> " + debAmmount + "/n Your current balance is ->" + currBal ;

	}

	@Override
	public String toString() {
		return super.toString() + "\nSavingACC [currBal=" + currBal + "]";
	}


}
