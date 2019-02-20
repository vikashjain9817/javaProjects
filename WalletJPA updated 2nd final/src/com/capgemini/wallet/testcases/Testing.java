package com.capgemini.wallet.testcases;





import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.capgemini.wallet.exception.DuplicateMobileNumberException;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;
import com.capgemini.wallet.exception.InsufficientBalanceException;
import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.dao.WalletDAO;
import com.capgemini.wallet.dao.WalletDAOImpl;
import com.capgemini.wallet.service.IWalletService;
import com.capgemini.wallet.service.WalletService;

public class Testing {

	
	WalletDAO walletRepo = new WalletDAOImpl();
	IWalletService walletService = new WalletService();
	
	
	@Test(expected = com.capgemini.wallet.exception.InsufficientBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToWithDrawThenThrowAnError() throws InsufficientBalanceException, MobileNoIsNotFoundException {
		
		walletService.withdraw("8171575996", 5000 );
	}
	
	@Test(expected = com.capgemini.wallet.exception.InsufficientBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToTransferThenThrowAnError() throws InsufficientBalanceException, MobileNoIsNotFoundException {
		
		
		walletService.fundTransfer("8171575996", "9897421625", 8000);
		
	}
	
	@Test(expected = com.capgemini.wallet.exception.DuplicateMobileNumberException.class)
	public void WhenTheMobileNumberIsDuplicateThenThrowAnError() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet();
		wallet1.setBalance(amount1);
		Customer customer1 = new Customer("vikash", "9897421625", wallet1);
		walletService.createAccount(customer1 );
		
	}
	
	@Test(expected = com.capgemini.wallet.exception.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToShowBalanceThenThrowAnError() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		walletService.checkBalance("9997244087");
	}
	
	
	@Test
	public void WhenTheMobileNumberIsValidThenShowBalanceSuccessfully() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		//System.out.println(walletService.showBalance("8171575996").getWallet().getBalance().intValue());
		double intialAmount = walletService.checkBalance("8171575996");
		assertEquals(intialAmount, walletService.checkBalance("8171575996"), 0.0001);
	}
	
	@Test(expected = com.capgemini.wallet.exception.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToFundTransferThenThrowAnError() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		
		walletService.fundTransfer("9761490311", "9761490311", 100);
		
	}
	
	
	@Test(expected = com.capgemini.wallet.exception.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToDepositAmountThenThrowAnError() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		
		walletService.deposit("9761490311", 50);
	}
	
	
	@Test(expected = com.capgemini.wallet.exception.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToWithDrawAmountThenThrowAnError() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		
		walletService.withdraw("9897421562", 100);
	}
	
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenDepositedSuccessfully() throws InsufficientBalanceException, MobileNoIsNotFoundException {
	
		double intialAmount = walletService.checkBalance("8171575996");
		double amount = 100;
		walletService.deposit("8171575996", amount);
		double finalAmount = walletService.checkBalance("8171575996");
		assertEquals(intialAmount+amount, finalAmount, 0.0001);
		
	}
	@Test
	public void WhenTheAllTheDetailsGivenValidThenTheAmountWithDrawSuccessfully() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
	
		
		double intialAmount = walletService.checkBalance("8171575996");
		double amount = 100;
		walletService.withdraw("8171575996", amount);
		double finalAmount = walletService.checkBalance("8171575996");
		assertEquals(intialAmount-amount, finalAmount, 0.0001);
		
	}
	
	
	@Test
	public void WhenAllTheDetailsGivenValidThenTheFundTransferredSuccessfully() throws InsufficientBalanceException, DuplicateMobileNumberException, MobileNoIsNotFoundException {
		
		double intialAmountSender = walletService.checkBalance("8171575996");
		double amount = 100;
		walletService.fundTransfer("8171575996", "9897421625", amount);
		double finalAmountSender = walletService.checkBalance("8171575996");
		assertEquals(intialAmountSender-amount, finalAmountSender, 0.0001);
		
	}

}
