package com.capgemini.repo;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;

public class WalletRepositoryImp implements WalletRepoInterface {
	
	
	@Override
	public boolean save(Customer customer) {
		
		try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123"); 
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
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");  
	        Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from customers");  
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
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");  
	        Statement stmt=con.createStatement();  
	        ResultSet sourceBalance = stmt.executeQuery("select balance from customers where mobileno = '"+sourceMobileNo+"'");
	        ResultSet targetBalance = stmt.executeQuery("select balance from customers where mobileno = '"+targetMobileNo+"'");
	        int sBalance = 0,tBalance = 0;
	        if(sourceBalance.next()) {
	        	sBalance = sourceBalance.getInt(1);
	        	sBalance = sBalance - (amount.intValue());
	        	System.out.println(sBalance);
	        }
	        if(targetBalance.next()) { 
		        tBalance = targetBalance.getInt(1);
		        tBalance = tBalance + (amount.intValue());
		        System.out.println(tBalance);
	        }
	        stmt.executeUpdate("update customers set balance = '"+ sBalance +"' where mobileno = '"+sourceMobileNo+"'");
	        stmt.executeUpdate("update customers set balance = '"+ tBalance +"' where mobileno = '"+targetMobileNo+"'");
	        con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void depositAmount(String mobileNo, BigDecimal amount)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");  
	        Statement stmt = con.createStatement();  
	        ResultSet balance = stmt.executeQuery("select balance from customers where mobileno = '"+mobileNo+"'");
	        int sBalance = 0;
	        if(balance.next()) {
	        	sBalance = balance.getInt(1);
	        	sBalance = sBalance + (amount.intValue());
	        	System.out.println(sBalance);
	        }
	        stmt.executeUpdate("update customers set balance = '"+ sBalance +"' where mobileno = '"+mobileNo+"'");
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}


	@Override
	public void withDrawAmount(String mobileNo, BigDecimal amount) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");  
	        Statement stmt = con.createStatement();  
	        ResultSet balance = stmt.executeQuery("select balance from customers where mobileno = '"+mobileNo+"'");
	        int sBalance = 0;
	        if(balance.next()) {
	        	sBalance = balance.getInt(1);
	        	sBalance = sBalance - (amount.intValue());
	        	System.out.println(sBalance);
	        }
	        stmt.executeUpdate("update customers set balance = '"+ sBalance +"' where mobileno = '"+mobileNo+"'");
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
