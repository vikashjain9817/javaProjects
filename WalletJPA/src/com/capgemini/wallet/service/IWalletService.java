package com.capgemini.wallet.service;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;

public interface IWalletService {

	void createAccount(Customer customer) throws MobileNoIsNotFoundException;

	void deposit(String mobileNo, double amount);

	void withdraw(String mobileNo, double amount);

	double checkBalance(String mobileNo);

	void fundTransfer(String sender, String reciever, double amount);
	
	
}
