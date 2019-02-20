package com.capgemini.wallet.service;



import com.capgemini.wallet.dao.WalletDAO;
import com.capgemini.wallet.dao.WalletDAOImpl;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;
import com.capgemini.wallet.beans.Customer;



public class WalletService implements IWalletService {

	WalletDAO dao = new WalletDAOImpl();
	
	@Override
	public void createAccount(Customer customer) throws MobileNoIsNotFoundException {
		if(dao.findOne(customer.getMobileNo()) != null)
			dao.createAccount(customer);
		else
			throw new MobileNoIsNotFoundException();
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		dao.deposit(mobileNo, amount);
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		dao.withDraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		dao.fundTransfer(sender, reciever, amount);
		
	}
}