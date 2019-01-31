package com.capgemini.bi;

public class InvalidAccountNumberException extends Exception {
	

	private static String message = "invalid account number";
	public InvalidAccountNumberException() {
		super(message);
	}
}
