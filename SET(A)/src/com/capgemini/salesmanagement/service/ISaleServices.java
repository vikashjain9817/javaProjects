package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.beans.Sale;

public interface ISaleServices {

	/*
	 * This Method will insert all
	 * the details of the sale into the HashMap using repo object.
	 * And return the details.
	 */
	HashMap<Integer, Sale> insertSalesDetails(Sale product);
	public boolean validateProductPrice(float productPrice);
	public boolean validateProductName(String productName);
	public boolean validateProductCategory(String category);
	public boolean validateProductCode(int productCode);
	public Sale getDetails(int productCode);
	boolean validateProductQuantity(int quantity);
}