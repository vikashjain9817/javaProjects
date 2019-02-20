package com.capgemini.wallet.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Column(name = "name")
	private String cusName;
	
	@Id
	@Column(name="mobile_no")
	private String cusMobileNo;
	
	@Embedded
	@Column(name="balance")
	Wallet wallet;
	
	public Customer() {
		super();
	}

	public Customer(String name, String mobileNo, Wallet wallet) {
		super();
		this.cusName = name;
		this.cusMobileNo = mobileNo;
		this.wallet = wallet;
	}

	public String getName() {
		return cusName;
	}

	public void setName(String name) {
		this.cusName = name;
	}

	public String getMobileNo() {
		return cusMobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.cusMobileNo = mobileNo;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
}