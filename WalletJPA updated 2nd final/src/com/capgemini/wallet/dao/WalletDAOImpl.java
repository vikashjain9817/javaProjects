package com.capgemini.wallet.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.exception.DuplicateMobileNumberException;

public class WalletDAOImpl implements WalletDAO {

	
	EntityManager manager;
	
	
	
	
	public WalletDAOImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
		manager = emf.createEntityManager();
	}

	@Override
	public void createAccount(Customer customer) throws DuplicateMobileNumberException {
		if(findOne(customer.getMobileNo()) == null) {
			manager.getTransaction().begin();
			manager.persist(customer);
			manager.getTransaction().commit();
		}
		else
			throw new DuplicateMobileNumberException("Dupicate mobile number exception");
	}
	
	public Customer findOne(String mobileNo)
	{
		Customer cus;
		manager.getTransaction().begin();
		cus = manager.find(Customer.class, mobileNo);
		manager.getTransaction().commit();
		return cus;
	}

	@Override
	public void update(String mobileNo, Wallet wallet) {

		Customer cus;
		cus = findOne(mobileNo);
		cus.setWallet(wallet);
	}
}