package com.jobPortal.lib;

import java.time.LocalDate;

import com.jobPortal.exceptions.InvalidDateException;
import com.jobPortal.exceptions.NumberMismatchException;

public class ValidationUtil {
	
	public static void courseCheck(String degree) throws IllegalArgumentException {
		if (!isValidCourse(degree)) 
			throw new IllegalArgumentException("Degree type mismatch.");
	}
	
	public static void dateCheck(String date) throws InvalidDateException {
		if (!isValidDate(date)) 
			throw new InvalidDateException("Future date entered.");
	}
	
	public static void numberCheck(String num, int len) throws NumberMismatchException {
		if (!isValidNumber(num, len))
			throw new NumberMismatchException("Short Length or Contains Chars.");
	}

	private static boolean isValidCourse(String degree) {
		try {
			Degree.valueOf(degree);
			return true;
		} catch (IllegalArgumentException exp) {
			return false;
		}
	}
	
	private static boolean isValidDate(String date) {
		if (null == date) return false;
		if (LocalDate.parse(date).isAfter(LocalDate.now())) return false;
		return true;
	}
	
	private static boolean isValidNumber(String num, int len) {
		if (num.length() > len || num.length() < len) return false;
		try {
			Long.parseLong(num);
			return true;
		} catch (NumberFormatException exp) {
			return false;
		}
	}
	
}
