package com.capgemini.wallet.ui;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.exception.MobileNoIsNotFoundException;
import com.capgemini.wallet.service.IWalletService;
import com.capgemini.wallet.service.WalletService;



public class Client {
	
	static IWalletService serviceImpl = new WalletService();
    static Scanner sc = new Scanner(System.in);
	
    static String name,mobileNo;
	static float age;
	static double amount;
	public static void main(String[] args) {
		

		int ch = 0;
		
		 while(true){
			System.out.println("1.Add Customer Details");
			System.out.println("2.Deposit amount");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Funds Transfer");
			System.out.println("5.Check Customer Balance");
			System.out.println("6.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch(ch){
			case 1 : addCustomer();break;
			case 2 : deposit(); break;					
			case 3 : withdraw(); break;				
			case 4 : fundTransfer();break;
			case 5 : checkBalance(); break;
			case 6 : System.exit(0);
			default : System.out.println("Invalid input!");break;
			}
          }
		}
		
		private static void addCustomer() throws MobileNoIsNotFoundException  {
			
			Customer customer = new Customer();						
			System.out.println("Enter customer name : ");
		    name = sc.next();
			System.out.println("Enter mobile no. : ");
			mobileNo = sc.next();
			while(!validateMobileNo(mobileNo))
			{
				System.out.println("Mobile Number is Not valid:: Enter again");
				mobileNo = sc.next();
			}
			System.out.println("Enter  amount : ");
			amount = sc.nextDouble();
			BigDecimal balance = new BigDecimal(amount);
			
			customer.setName(name);
			customer.setMobileNo(mobileNo);
			Wallet wallet = new Wallet();
			wallet.setBalance(balance);
			customer.setWallet(wallet);
			
			serviceImpl.createAccount(customer);
			System.out.println("Customer added successfully");
		}
	
		private static void deposit()  {
			
			System.out.println("Enter your mobile number : ");
			mobileNo = sc.next();
			while(!validateMobileNo(mobileNo))
			{
				System.out.println("Mobile Number is Not valid:: Enter again");
				mobileNo = sc.next();
			}
	
			System.out.println("Enter the amount you want to deposit");
			amount = sc.nextDouble();
			serviceImpl.deposit(mobileNo, amount);
			
		}
     
     private static void withdraw()  {
		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();
		while(!validateMobileNo(mobileNo))
		{
			System.out.println("Mobile Number is Not valid:: Enter again");
			mobileNo = sc.next();
		}

		System.out.println("Enter the amount you want to withdraw : ");
		amount = sc.nextDouble();
		serviceImpl.withdraw(mobileNo, amount);
      }
      
      private static void fundTransfer() {
		String mobileNoReciever;
		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();
		while(!validateMobileNo(mobileNo))
		{
			System.out.println("Mobile Number is Not valid:: Enter again");
			mobileNo = sc.next();
		}

		System.out.println("Enter the amount you want to transfer : ");
		amount = sc.nextDouble();

		System.out.println("Enter receivers mobile number : ");
		mobileNoReciever = sc.next();
		while(!validateMobileNo(mobileNoReciever))
		{
			System.out.println("Receiver Mobile Number is Not valid:: Enter again");
			mobileNoReciever = sc.next();
		}
		
		if(mobileNo.equals(mobileNoReciever)){								
			System.out.println("Both numbers are same!");
		}
			serviceImpl.fundTransfer(mobileNo, mobileNoReciever, amount);
		}
		
		private static void checkBalance()  {

			System.out.println("Enter the moible id to check balance");
			mobileNo = sc.next();
			while(!validateMobileNo(mobileNo))
			{
				System.out.println("Mobile Number is Not valid:: Enter again");
				mobileNo = sc.next();
			}
			System.out.println("Current Amount is Rs."+serviceImpl.checkBalance(mobileNo));
		}
		private static boolean validateMobileNo(String mobileNo)
		{
			Pattern pattern = Pattern.compile("[6789]{1}[0-9]{9}");
			Matcher match = pattern.matcher(mobileNo);
			if(match.matches())
				return true;
			else
				return false;
		}
}