package com.capgemini.wallet.dao;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.exception.DuplicateMobileNumberException;

public interface WalletDAO {

	void createAccount(Customer customer) throws DuplicateMobileNumberException;
	
	public Customer findOne(String mobileNo) ;
	
	public void update(String mobileNo , Wallet wallet);

}
