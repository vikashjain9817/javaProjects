package com.capgemini.repo;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.connection.ConnectionJDBC;

public class WalletRepositoryImp implements WalletRepoInterface {
	
	Connection con;
	@Override
	public boolean save(Customer customer) {
		
		try{  
			
			con = ConnectionJDBC.getConnection();
	        PreparedStatement stmt = con.prepareStatement("insert into customers(mobileno, name, balance) values(?,?,?)");  
	        stmt.setString(1,customer.getMobileNo());  
	        stmt.setString(2, customer.getName());
	        stmt.setInt(3,customer.getWallet().getBalance().intValue());
	        stmt.executeUpdate();
	        con.close();
	        return true;
		}catch(Exception e) {System.out.println("error occur in sql connectivity");}
		
		return false;
		
	}
	
	
	@Override
	public Customer findOne(String mobileNo) {
		try {
			con = ConnectionJDBC.getConnection();
	        Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from customers");  
	        System.out.println("_______________________________________________________________________");
	        while(rs.next()){
	        	//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
	        	if(rs.getString(1).equals(mobileNo))
	        	{
	        		BigDecimal balance = new BigDecimal(rs.getInt(3));	 
	        		Wallet wallet = new Wallet(balance);	        		
	        		return new Customer(rs.getString(2), rs.getString(1), wallet);
	        	}
	        }
	        con.close();
		}catch(Exception e) {System.out.println(e);}
		return null;
	}


	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		
		try {
			con = ConnectionJDBC.getConnection();
			PreparedStatement stmt=con.prepareStatement("update customers set balance = ? where mobileno = ?");
	        stmt.setInt(1,findOne(sourceMobileNo).getWallet().getBalance().subtract(amount).intValue());
	        stmt.setString(2, sourceMobileNo);
	        stmt.executeUpdate();
	        stmt.setInt(1,findOne(targetMobileNo).getWallet().getBalance().add(amount).intValue());
	        stmt.setString(2, targetMobileNo);
	        stmt.executeUpdate();
	        return findOne(targetMobileNo);
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount)
	{
		try {
			con = ConnectionJDBC.getConnection();
			PreparedStatement stmt=con.prepareStatement("update customers set balance = ? where mobileno = ?");
	        stmt.setInt(1,findOne(mobileNo).getWallet().getBalance().add(amount).intValue());
	        stmt.setString(2, mobileNo);
	        stmt.executeUpdate();
			con.close();
			return findOne(mobileNo);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


	@Override
	public Customer withDrawAmount(String mobileNo, BigDecimal amount) {
		try {
			con = ConnectionJDBC.getConnection();
			PreparedStatement stmt=con.prepareStatement("update customers set balance = ? where mobileno = ?");
	        stmt.setInt(1,findOne(mobileNo).getWallet().getBalance().subtract(amount).intValue());
	        stmt.setString(2, mobileNo);
	        stmt.executeUpdate();
	        
			con.close();
			return findOne(mobileNo);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
