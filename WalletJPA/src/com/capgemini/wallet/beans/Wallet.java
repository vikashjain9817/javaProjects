package com.capgemini.wallet.beans;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

@Embeddable
public class Wallet {
	
	private BigDecimal balance;
	
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}	

}
