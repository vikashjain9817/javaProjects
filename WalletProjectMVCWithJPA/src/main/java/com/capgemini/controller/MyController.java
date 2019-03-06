package com.capgemini.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.service.WalletService;

@RestController
public class MyController {
	
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value = "Wallet/{mobileNo}/{name}/{balance}", method = RequestMethod.GET)
	public Customer insert(@PathVariable String mobileNo, @PathVariable String name, @PathVariable double balance)
	{
		BigDecimal amount = new BigDecimal(balance);
		Wallet wallet = new Wallet(amount);
		Customer customer = new Customer(name, mobileNo, wallet);
		return walletService.createAccount(customer);
	}
	
	@RequestMapping(value = "ShowWalletByMobileNo/{mobileNo}", method = RequestMethod.GET)
	public Customer showById(@PathVariable String mobileNo)
	{
		return walletService.showById(mobileNo);
	}
	
	@RequestMapping(value = "deposit/{mobileNo}/{balance}", method = RequestMethod.GET)
	public Customer deposit(@PathVariable String mobileNo,@PathVariable double balance)
	{
		return walletService.deposit(mobileNo, balance);
	}
	
	@RequestMapping(value = "withdraw/{mobileNo}/{balance}",  method = RequestMethod.GET)
	public Customer withDraw(@PathVariable String mobileNo,@PathVariable double balance)
	{
		return walletService.withDraw(mobileNo, balance);
	}
	
	@RequestMapping(value = "fundtransfer/{sourceMobileNo}/{targetMobileNo}/{balance}",  method = RequestMethod.GET)
	public Customer fundTransfer(@PathVariable String sourceMobileNo, @PathVariable String targetMobileNo, @PathVariable double balance)
	{
		return walletService.fundtransfer(sourceMobileNo, targetMobileNo, balance);
	}
	@RequestMapping(value = "showAll",  method = RequestMethod.GET)
	public List<Customer> showAll()
	{
		return walletService.showAll();
	}
	
}
