package com.capgemini.wallet.service;



import com.capgemini.wallet.dao.WalletDAO;
import com.capgemini.wallet.dao.WalletDAOImpl;
import com.capgemini.wallet.exception.DuplicateMobileNumberException;
import com.capgemini.wallet.exception.InsufficientBalanceException;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;

import java.math.BigDecimal;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;



public class WalletService implements IWalletService {

	WalletDAO dao = new WalletDAOImpl();
	
	@Override
	public void createAccount(Customer customer) throws MobileNoIsNotFoundException, DuplicateMobileNumberException {
				dao.createAccount(customer);
				System.out.println("account created successfully");
		
	}

	@Override
	public void deposit(String mobileNo, double amount) throws MobileNoIsNotFoundException {
		Customer cus;
		cus = dao.findOne(mobileNo);
		if(cus != null) {
			double updatedAmount = cus.getWallet().getBalance().doubleValue();
			updatedAmount = updatedAmount + amount;
			System.out.println(updatedAmount);
			BigDecimal balance = new BigDecimal(updatedAmount);
			Wallet w = new Wallet();
			w.setBalance(balance);
			dao.update(mobileNo, w);
		}
		else
			throw new MobileNoIsNotFoundException("mobile number is not found");
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) throws MobileNoIsNotFoundException, InsufficientBalanceException {
		Customer cus;
		cus = dao.findOne(mobileNo);
		if(cus != null) {
			double initialAmount = cus.getWallet().getBalance().doubleValue();
			if(!(initialAmount - amount > 0)){
				throw new InsufficientBalanceException();
			}
			else{
				initialAmount = initialAmount - amount;
				
				BigDecimal balance = new BigDecimal(initialAmount);
				Wallet w = new Wallet();
				w.setBalance(balance);
				cus.setWallet(w);
				System.out.println("Amount Rs."+amount+" withdrawed successfully");
		
			}
		}
		else
			throw new MobileNoIsNotFoundException("mobile number is not found");
		
	}

	@Override
	public double checkBalance(String mobileNo) throws MobileNoIsNotFoundException {
		Customer cus;
		cus = dao.findOne(mobileNo);
		if(cus == null)
			throw new MobileNoIsNotFoundException("mobile number is not found");
		else {
			System.out.println("Amount Rs."+cus.getWallet().getBalance());
			return cus.getWallet().getBalance().doubleValue();
		}
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) throws MobileNoIsNotFoundException, InsufficientBalanceException {
		Customer sCus;
		Customer rCus;
		sCus = dao.findOne(sender);
		rCus = dao.findOne(reciever);
		if(sCus != null && rCus != null) {
			double senderAmount = sCus.getWallet().getBalance().doubleValue();
			double recieverAmount = rCus.getWallet().getBalance().doubleValue();
			
			if((senderAmount - amount) > 0){
				senderAmount =senderAmount - amount;
				recieverAmount =recieverAmount + amount;
				
				BigDecimal sBalance = new BigDecimal(senderAmount);
				Wallet sW = new Wallet();
				sW.setBalance(sBalance);
				dao.update(sCus.getMobileNo(), sW);
				
				BigDecimal rBalance = new BigDecimal(recieverAmount);
				Wallet rW = new Wallet();
				rW.setBalance(rBalance);
				dao.update(rCus.getMobileNo(), rW);
				System.out.println("Fund of Rs."+amount+" transferred successfully! from "+sCus.getName()+" to "+rCus.getName());
			}
			else
			{
				throw new InsufficientBalanceException();
				//System.err.println("Invalid amount! As transfer amount is greater than your account balance.");
			}
			
		}
		else
			throw new MobileNoIsNotFoundException("mobile number is not found");
	}
}