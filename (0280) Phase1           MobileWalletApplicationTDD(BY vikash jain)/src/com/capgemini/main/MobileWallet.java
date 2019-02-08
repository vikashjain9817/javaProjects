package com.capgemini.main;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;
import com.capgemini.repo.WalletRepoInterface;
import com.capgemini.repo.WalletRepositoryImp;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImp;

public class MobileWallet {

	public static void main(String[] args) throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		WalletRepoInterface walletRepo = new WalletRepositoryImp();
		WalletService walletService = new WalletServiceImp(walletRepo);
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		System.out.println(walletService.createAccount("vikash", "8171575996", wallet1));
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		System.out.println(walletService.createAccount("shivam,", "9761490311", wallet2));
		
		BigDecimal transferAmount = new BigDecimal(500);
		System.out.println(walletService.fundTransfer("8171575996", "9761490311", transferAmount));


	}

}
