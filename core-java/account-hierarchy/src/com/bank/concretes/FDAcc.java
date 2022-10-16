package com.bank.concretes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bank.abstracts.Account;
import com.bank.exceptions.FdNotInitiatedException;

public class FDAcc extends Account {
	
    private double fdAmmount;
	private float rate;
	private int duration;
	private Date date;
	
	public FDAcc() {
		this.fdAmmount = 0;
		this.rate = 0;
		this.duration = 0;
	}
	
	public FDAcc(long accNum, String name, long fdAmmount, float rate, int duration, String dateStr) throws ParseException {
		super(accNum, name);
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		this.fdAmmount = fdAmmount;
		this.rate = rate;
		this.duration = duration;
		this.date = date.parse(dateStr);
	}
	
	public double simpleInterest() {
		return (this.duration * this.rate * this.fdAmmount) / 100;
	}

	@Override
	public String debit(double debAmmount) throws FdNotInitiatedException {
		String mesg = "";
		
		if (fdAmmount == 0) {
			FdNotInitiatedException fnie = new FdNotInitiatedException("Pehle paisa laao to... tab to milega.");
			throw fnie;
		} else {
			fdAmmount = 0;
			mesg = "Lo paisa le jao sara => " + fdAmmount;
		} 
		
		return mesg;
	}

	@Override
	public String credit(double creditAmmount) {
		String msg = "";
		if (fdAmmount > 0) {
			msg = "Can't add amount to ongoing FD";
		}
		return msg;
	}

	public double getFdAmmount() {
		return fdAmmount;
	}

	public void setFdAmmount(long fdAmmount) {
		this.fdAmmount = fdAmmount;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDate() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		return date.format(this.date);
	}

	@Override
	public String toString() {
		return super.toString() + "FDAcc [fdAmmount=" + fdAmmount + ", rate=" + rate 
				+ ", duration=" + duration + "date = " + getDate() + "]";
	}

}
