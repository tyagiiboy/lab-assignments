package com.bank.interfaces;

import com.bank.exceptions.FdNotInitiatedException;
import com.bank.exceptions.MinimumBalanceException;

public interface Accountable {
	
	String credit(double creditAmmount);
	String debit(double debAmmount) throws MinimumBalanceException, FdNotInitiatedException;
	
}