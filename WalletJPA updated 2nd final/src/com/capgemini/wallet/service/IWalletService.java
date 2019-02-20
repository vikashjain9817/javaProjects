package com.capgemini.wallet.service;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.exception.DuplicateMobileNumberException;
import com.capgemini.wallet.exception.InsufficientBalanceException;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;

public interface IWalletService {

	void createAccount(Customer customer) throws MobileNoIsNotFoundException, DuplicateMobileNumberException;

	void deposit(String mobileNo, double amount) throws MobileNoIsNotFoundException;

	void withdraw(String mobileNo, double amount) throws MobileNoIsNotFoundException, InsufficientBalanceException;

	double checkBalance(String mobileNo) throws MobileNoIsNotFoundException;

	void fundTransfer(String sender, String reciever, double amount) throws MobileNoIsNotFoundException, InsufficientBalanceException;
	
	
}
