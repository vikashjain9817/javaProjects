package com.capgemini.bi;

public class OpeningBalanceExcaeption extends Exception {
	private static String  message = "must be 500 rupees in opening account";
	public OpeningBalanceExcaeption()
	{
		super(message);
	}
	
}
