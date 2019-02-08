package com.capgemini.testCases;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;
import com.capgemini.repo.WalletRepoInterface;
import com.capgemini.repo.WalletRepositoryImp;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImp;

public class MobileWalletTesting {

	
	WalletRepoInterface walletRepo = new WalletRepositoryImp();
	WalletService walletService = new WalletServiceImp(walletRepo);
	
	
	@Test(expected = com.capgemini.exception.InsufficientBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToWithDrawThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal withdrawAmount = new BigDecimal(2000);
		walletService.withDrawAmount("8171575996", withdrawAmount );
	}
	
	@Test(expected = com.capgemini.exception.InsufficientBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToTransferThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8755560521", wallet2);
		
		BigDecimal fundTransfer = new BigDecimal(2000);
		walletService.fundTransfer("8171575996", "8755560521", fundTransfer);
		
	}
	
	@Test(expected = com.capgemini.exception.DupicateMobileNumberException.class)
	public void WhenTheMobileNumberIsDuplicateThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8171575996", wallet2);
		
	}
	
	@Test(expected = com.capgemini.exception.MobilenumberIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToShowBalanceThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		walletService.showBalance("8755560521");
	}
	
	@Test
	public void WhenTheMobileNumberIsValidThenShowBalanceSuccessfully() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		walletService.showBalance("8171575996");
	}
	
	
	@Test(expected = com.capgemini.exception.MobilenumberIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToFundTransferThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8755560521", wallet2);
		
		BigDecimal amount3 = new BigDecimal(500);
		walletService.fundTransfer("8171575996", "9761490311", amount3);
		
	}
	
	
	@Test(expected = com.capgemini.exception.MobilenumberIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToDepositAmountThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.depositAmount("8755560521", amount);
	}
	
	
	@Test(expected = com.capgemini.exception.MobilenumberIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToWithDrawAmountThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.depositAmount("8755560521", amount);
	}
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenAccountCreatedSuccessfully() throws DupicateMobileNumberException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
	}
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenDepositedSuccessfully() throws DupicateMobileNumberException, MobilenumberIsNotFoundException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.depositAmount("8171575996", amount);
		
	}
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenTheAmountWithDrawSuccessfully() throws DupicateMobileNumberException, MobilenumberIsNotFoundException, InsufficientBalanceException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.withDrawAmount("8171575996", amount);
		
	}
	
	
	@Test
	public void WhenAllTheDetailsGivenValidThenTheFundTransferredSuccessfully() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8755560521", wallet2);
		
		BigDecimal amount3 = new BigDecimal(500);
		walletService.fundTransfer("8171575996", "8755560521", amount3);
		
	}

}
