package com.capgemini.service;




import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.repo.WalletRepo;

@Service
public class WalletServiceImp implements WalletService {
	
	@Autowired
	WalletRepo walletRepo;
	
	
	@Override
	public Customer createAccount(Customer customer) {
		if(!walletRepo.findById(customer.getMobileNo()).isPresent())
			return walletRepo.save(customer);
		else
			return null;
	}
	
	@Override
	public Customer showById(String mobileNo) {
		if(walletRepo.findById(mobileNo).isPresent())
			return walletRepo.findById(mobileNo).get();
		else
			return null;
	}

	@Override
	public Customer deposit(String mobileNo, double amount) {
		Customer customer=null;
		
		if(walletRepo.findById(mobileNo).isPresent()) {
			customer = walletRepo.findById(mobileNo).get();
			double updatedAmount = customer.getWallet().getBalance().doubleValue();
			updatedAmount = updatedAmount + amount;
			BigDecimal balance = new BigDecimal(updatedAmount);
			Wallet w = new Wallet();
			w.setBalance(balance);
			customer.setWallet(w);
			return walletRepo.save(customer);
		}
		else
			return customer;
	}

	@Override
	public Customer withDraw(String mobileNo, double amount) {
		Customer customer=null;
		
		if(walletRepo.findById(mobileNo).isPresent()) {
			customer = walletRepo.findById(mobileNo).get();
			double initialAmount = customer.getWallet().getBalance().doubleValue();
			if(!(initialAmount - amount > 0)){
				return null;
			}
			else{
				initialAmount = initialAmount - amount;
				BigDecimal balance = new BigDecimal(initialAmount);
				Wallet w = new Wallet();
				w.setBalance(balance);
				customer.setWallet(w);
				return walletRepo.save(customer);
			}
		}
		else
			return customer;
	}

	@Override
	public Customer fundtransfer(String sourceMobileNo, String targetMobileNo, double amount) {
		Customer sourceCustomer = null;
		Customer targetCustomer = null;
		
		if(walletRepo.findById(sourceMobileNo).isPresent() && walletRepo.findById(targetMobileNo).isPresent()) {
			sourceCustomer = walletRepo.findById(sourceMobileNo).get();
			targetCustomer = walletRepo.findById(targetMobileNo).get();
			double senderAmount = sourceCustomer.getWallet().getBalance().doubleValue();
			double recieverAmount = targetCustomer.getWallet().getBalance().doubleValue();
			
			if((senderAmount - amount) > 0){
				senderAmount =senderAmount - amount;
				recieverAmount =recieverAmount + amount;
				
				BigDecimal sBalance = new BigDecimal(senderAmount);
				Wallet sourceWallet = new Wallet();
				sourceWallet.setBalance(sBalance);
				sourceCustomer.setWallet(sourceWallet);
				walletRepo.save(sourceCustomer);
				
				BigDecimal rBalance = new BigDecimal(recieverAmount);
				Wallet targetWallet = new Wallet();
				targetWallet.setBalance(rBalance);
				targetCustomer.setWallet(targetWallet);
				walletRepo.save(targetCustomer);
				return targetCustomer;
			}
			else
			{
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Customer> showAll() {
		return walletRepo.findAll();
	}
}
