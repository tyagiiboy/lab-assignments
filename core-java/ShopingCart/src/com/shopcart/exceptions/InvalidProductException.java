package com.shopcart.exceptions;

public class InvalidProductException extends Exception {
	private static final long serialVersionUID = -2391437902964687249L;

	public InvalidProductException(String msg) {
		super(msg);
	}
}
