package com.capgemini.bi;

import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.bi.OpeningBalanceExcaeption;

public class ICICIBank {
	
	LinkedList<Account> accounts = new LinkedList<Account>();
	
	public String createAccount(int accountNumber, int amount) throws OpeningBalanceExcaeption {
		
		Account account = new Account(accountNumber, amount);
		if(amount < 500) {
			throw new OpeningBalanceExcaeption();
		}
		accounts.add(account);
		return "account created suceesfully";
	}
	
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber() == accountNumber)
			{
				return account;
			}
		}
		
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufiicientBalanceException {
		
		Account account = searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufiicientBalanceException();
		
	}
	
	public String fundTransfer(int fromAccountNumber, int toAccountNumber, int amount) throws InvalidAccountNumberException, InsufiicientBalanceException {
		
		Account fromAccount = searchAccount(fromAccountNumber);
		Account toAccount = searchAccount(toAccountNumber);
		if((fromAccount.getAmount()-amount>=0))
		{
			fromAccount.setAmount(fromAccount.getAmount()-amount);
			toAccount.setAmount(toAccount.getAmount()+amount);
			return "Sender balance is :"+fromAccount.getAmount() + " " +"Receiver balance is"+ toAccount.getAmount();
		}
		throw new InsufiicientBalanceException();
	}
	
	public String deposit(int accountNumber , int amount) throws InvalidAccountNumberException {
		
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return "the updated balance of :" + account.getAccountNumber() + " is:" + account.getAmount();
	}

}
