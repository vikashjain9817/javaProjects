package com.capgemini.repo;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;

public interface WalletRepoInterface {

	boolean save(Customer Customer);

	Customer findOne(String mobileNo);

	void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	void depositAmount(String mobileNo, BigDecimal balance);

	void withDrawAmount(String mobileNo, BigDecimal amount);

}