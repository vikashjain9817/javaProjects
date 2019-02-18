package com.capgemini.beans;

import java.math.BigDecimal;

public class Transcation {

	private String transctionName;
	private BigDecimal amount;
	
	
	public Transcation(String transctionName, BigDecimal amount) {
		super();
		this.transctionName = transctionName;
		this.amount = amount;
	}


	public String getTransctionName() {
		return transctionName;
	}


	public void setTransctionName(String transctionName) {
		this.transctionName = transctionName;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
