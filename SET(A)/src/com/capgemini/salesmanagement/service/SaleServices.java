package com.capgemini.salesmanagement.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.salesmanagement.beans.Sale;
import com.capgemini.salesmanagement.dao.ISaleDAO;
import com.capgemini.salesmanagement.dao.SaleDAO;

public class SaleServices implements ISaleServices {
	
	ISaleDAO saleDAO = new SaleDAO();
	
	/*
	 * This Method will insert all
	 * the details of the sale into the HashMap using repo object.
	 * And return the details.
	 */
	@Override
	public HashMap<Integer, Sale> insertSalesDetails(Sale product)
	{
		return saleDAO.insertSalesDetails(product);
	}
	
	/*
	 * This Method will 
	 * return the HashMap 
	 */
	@Override
	public Sale getDetails(int productCode) {
		return saleDAO.getDetails(productCode);
	}
	
	
	/*
	 * This Method Will validate product price
	 *  and return true/false for the same.
	 */
	public boolean validateProductPrice(float productPrice) {
		try {
			if(productPrice > 200f)
				return true;
		}catch(Exception e) {
			return false;
		}
		return false;
	}
		
	
	/*
	 * This Method Will validate product Name
	 *  and return true/false for the same.
	 */
	public  boolean validateProductName(String productName) {
		if(productName.charAt(0) == 'E')
		{
			productName = productName.substring(1);
			if(productName.equals("TV") || productName.equals("Smart Phone") || productName.equals("Video Game"))
			{
				return true;
			}
			else {
				return false;
			}
		}
		else {
			productName = productName.substring(1);
			System.out.println(productName);
			if(productName.equals("Soft Toy") || productName.equals("Telescope") || productName.equals("Barbee Doll"))
			{
				return true;
			}
			else {
				return false;
			}
		}
		
	}

	/*
	 * This Method Will validate product category
	 *  and return true/false for the same.
	 */
	public  boolean validateProductCategory(String category) {
		
		if(category.equals("Electronics") || category.equals("Toys"))
			return true;
		else
			return false;
	}
	/*
	 * This Method Will validate product code
	 *  and return true/false for the same.
	 */
	public  boolean validateProductCode(int productCode) {
		
		String productCodeStr = Integer.toString(productCode);
		Pattern pattern = Pattern.compile("[1]{1}[0]{2}[1-4]{1}");
		Matcher match = pattern.matcher(productCodeStr);
		if(match.matches())
			return true;
		else
			return false;
	}
	/*
	 * This Method will validate product quantity.
	 * 
	 */
	@Override
	public boolean validateProductQuantity(int quantity) {
		if(quantity <= 0 || quantity > 5)
			return false;
		else
			return true;
	}

}
