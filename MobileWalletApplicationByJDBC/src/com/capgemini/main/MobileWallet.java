package com.capgemini.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.capgemini.beans.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;
import com.capgemini.repo.WalletRepoInterface;
import com.capgemini.repo.WalletRepositoryImp;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImp;

public class MobileWallet {

	static Scanner sc = new Scanner(System.in);
	static WalletRepoInterface walletRepo = new WalletRepositoryImp();
	static WalletService walletService = new WalletServiceImp(walletRepo);
	
	public static void main(String[] args) throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		while(true)
		{
			System.out.println("1) To Add New Customer");
			System.out.println("2) To Fund Transfer");
			System.out.println("3) To Deposit Amount");
			System.out.println("4) To WithDraw Amount");
			System.out.println("5) To Show BAlance");
			System.out.println("6) exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: getDetails();break;
			case 2: fundTransfer();break;
			case 3: depositAmount();break;
			case 4: WithDrawAmount();break;
			case 5: show();break;
			case 6: System.exit(0);
			default: System.out.println("Wrong choice!");break;
			}
		}
	}

	private static void show() {
		System.out.println("enter mobile number");
		sc.nextLine();
		String mobileNo = sc.nextLine();
		try {
			System.out.println(walletService.showBalance(mobileNo));
		}catch(Exception e) {System.out.println("not found");}
		
	}

	private static void WithDrawAmount() {
		System.out.println("enter mobile number");
		sc.nextLine();
		String mobileNo = sc.nextLine();
		System.out.println("enter balance");
		BigDecimal amount = new BigDecimal(sc.nextInt());
		try {
			System.out.println(walletService.withDrawAmount(mobileNo, amount));
			
		}catch(Exception e)
		{
			System.out.println("mobile number not found/ insufficient balance");
		}
	}

	private static void depositAmount() {
		System.out.println("enter mobile number");
		sc.nextLine();
		String mobileNo = sc.nextLine();
		System.out.println("enter balance");
		BigDecimal amount = new BigDecimal(sc.nextInt());
		try {
			System.out.println(walletService.depositAmount(mobileNo, amount));
			
		}catch(Exception e)
		{
			System.out.println("mobile number not found");
		}
		
	}

	
	private static void fundTransfer() throws InsufficientBalanceException, MobilenumberIsNotFoundException {
		System.out.println("Enter source mobile No");
		sc.nextLine();
		String sourceMobileNo = sc.nextLine();
		System.out.println("Enter target mobile No");
		String targetMobileNo = sc.nextLine();
		System.out.println("enter amount to be transferred");
		BigDecimal amount = new BigDecimal(sc.nextInt());
		try {
			walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		}catch(Exception e) {System.out.println(e);}
	}

	
	private static void getDetails() throws DupicateMobileNumberException {
		System.out.println("enter mobileno");
		sc.nextLine();
		String mobileNo = sc.nextLine();
		System.out.println("enter name");
		String name = sc.nextLine();
		System.out.println("enter balance");
		BigDecimal amount = new BigDecimal(sc.nextInt());
		Wallet wallet = new Wallet(amount);
		try {
			System.out.println(walletService.createAccount(name, mobileNo, wallet));
		}catch(DupicateMobileNumberException e) {
			System.out.println("Duplicate mobile number");
		}
	}
}
