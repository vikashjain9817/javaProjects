package com.capgemini.view;


import com.capgemini.bi.ICICIBank;
import com.capgemini.bi.InsufiicientBalanceException;
import com.capgemini.bi.InvalidAccountNumberException;
import com.capgemini.bi.OpeningBalanceExcaeption;

public class Client {

	public static void main(String[] args) {
		
		ICICIBank iciciBank = new ICICIBank();
		try {
			System.out.println(iciciBank.createAccount(100, 200));
		} catch (OpeningBalanceExcaeption e1) {
			System.out.println(e1.getMessage());
		}
		
		try {
			System.out.println(iciciBank.createAccount(101, 600));
		} catch (OpeningBalanceExcaeption e1) {
			System.out.println(e1.getMessage());
		}
		
		
	}
}