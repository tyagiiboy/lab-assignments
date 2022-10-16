package app.acts.library.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateValidator {
	
	public static boolean inSequence(String dateOne, String dateTwo) {
		LocalDate before = LocalDate.parse(dateOne);
		LocalDate after = LocalDate.parse(dateTwo);
		return before.isBefore(after);
	}

	public static boolean inValidFormat(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch (DateTimeParseException exp) {
			return false;
		}
	}
	
	public static boolean isBefore(String date) {
		return LocalDate.parse(date).isBefore(LocalDate.now());
	}
	
	public static boolean isAfter(String date) {
		return LocalDate.parse(date).isAfter(LocalDate.now());
	}
}
