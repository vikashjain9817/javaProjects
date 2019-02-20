package com.capgemini.repo;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;

public interface WalletRepoInterface {

	boolean save(Customer Customer);

	Customer findOne(String mobileNo);

	Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	Customer depositAmount(String mobileNo, BigDecimal balance);

	Customer withDrawAmount(String mobileNo, BigDecimal amount);

}
