package com.capgemini.bi;

public class InsufiicientBalanceException extends Exception {
	private static String message = "insufficient balance";

	public InsufiicientBalanceException() {
		super(message);
	}
	

}
