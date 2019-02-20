package com.capgemini.wallet.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;

public class WalletDAOImpl implements WalletDAO {

	
	EntityManager manager;
	
	
	
	
	public WalletDAOImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
		manager = emf.createEntityManager();
	}

	@Override
	public void createAccount(Customer customer) {
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
    manager.getTransaction().begin();
		
		Customer cust =  manager.find(Customer.class, mobileNo);
		double updatedAmount = cust.getWallet().getBalance().doubleValue();
		updatedAmount = updatedAmount + amount;
		System.out.println(updatedAmount);
		BigDecimal balance = new BigDecimal(updatedAmount);
		Wallet w = new Wallet();
		w.setBalance(balance);
		cust.setWallet(w);
		
		manager.getTransaction().commit();
		
	}

	@Override
	public void withDraw(String mobileNo, double withdrawAmount) {
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amount = cust.getWallet().getBalance().doubleValue();
		if(!(amount-withdrawAmount > 0)){
			System.err.println("Insufficient Balance in you account.\nNo amount deducted from your account.\nPlease try again");
		}
		else{
			amount =amount - withdrawAmount;
			
			BigDecimal balance = new BigDecimal(amount);
			Wallet w = new Wallet();
			w.setBalance(balance);
			cust.setWallet(w);
			System.out.println("Amount Rs."+withdrawAmount+" withdrawed successfully");
	
		}
		manager.getTransaction().commit();	
	}

	@Override
	public double checkBalance(String mobileNo) {
		
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amount = cust.getWallet().getBalance().doubleValue();
		manager.getTransaction().commit();
		return amount;
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		
		manager.getTransaction().begin();
		Customer custSender = manager.find(Customer.class, sender);
		Customer custreciever = manager.find(Customer.class, reciever);
		
		double senderAmount = custSender.getWallet().getBalance().doubleValue();
		double recieverAmount = custreciever.getWallet().getBalance().doubleValue();
		
		if((senderAmount - amount) > 0){
			senderAmount =senderAmount - amount;
			recieverAmount =recieverAmount + amount;
			
			BigDecimal rBalance = new BigDecimal(recieverAmount);
			Wallet rW = new Wallet();
			rW.setBalance(rBalance);
			custreciever.setWallet(rW);
			
			BigDecimal sBalance = new BigDecimal(senderAmount);
			Wallet sW = new Wallet();
			sW.setBalance(sBalance);
			custreciever.setWallet(sW);
			System.out.println("Fund of Rs."+amount+" transferred successfully! from "+custSender.getName()+" to "+custreciever.getName());
		}else{
			
			System.err.println("Invalid amount! As transfer amount is greater than your account balance.");
		}
		
		manager.getTransaction().commit();
		}
	
	public Customer findOne(String mobileNo)
	{
		Customer cus;
		manager.getTransaction().begin();
		cus = manager.find(Customer.class, mobileNo);
		manager.getTransaction().commit();
		return cus;
	}
	}