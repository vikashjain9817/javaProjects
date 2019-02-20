package com.capgemini.wallet.dao;

import com.capgemini.wallet.beans.Customer;

public interface WalletDAO {

	void createAccount(Customer customer);
	
	void deposit(String mobileNo, double amount);

	void withDraw(String mobileNo, double withdrawAmount);

	double checkBalance(String mobileNo);

	void fundTransfer(String sender, String reciever, double amount);
	
	public Customer findOne(String mobileNo) ;

}
