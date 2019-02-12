package com.capgemini.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.exception.ProductIdIsNotValidException;
import com.capgemini.exception.ProductNameIsNotValidException;
import com.capgemini.exception.ProductPriceIsNotValidException;
import com.capgemini.exception.ProductQuantityIsNotValidException;
import com.capgemini.exception.ProductcateIsNotValidException;

public class SaleService implements ISaleService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.ISaleService#validateProduct(int)
	 */
	
	/*
	 * 
	 * Validate product id*/
	@Override
	public boolean validateProduct(int productId) throws ProductIdIsNotValidException
	{
		if(productId == 1001 || productId == 1002 || productId == 1003 || productId == 1004)
			
			return true;   // This is for Client Class validation.
		else
			throw new ProductIdIsNotValidException();
			// return false;   // This is for Client Class validation.
		
	}
	
	public boolean validateQuantity(int qty) throws ProductQuantityIsNotValidException
	{
		if(qty > 0 && qty < 5)
			return true;    // This is for Client Class validation.
		else
			throw new ProductQuantityIsNotValidException();
			//return false;   // This is for Client Class validation.
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.ISaleService#validateProductCat(java.lang.String)
	 */
	@Override
	public boolean validateProductCat(String prodCat) throws ProductcateIsNotValidException
	{
		if(prodCat.equals("Electronics") || prodCat.equals("Toys"))
			return true;   // This is for Client Class validation.  
		else
			throw new ProductcateIsNotValidException();
			//return false;   // This is for Client Class validation.
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.ISaleService#validateProductName(java.lang.String)
	 */
	@Override
	public boolean validateProductName(String prodName, String prodCat) throws ProductNameIsNotValidException
	{
		if(prodCat.equals("Electronics"))
		{
			if(prodName.equals("TV") || prodName.equals("Smart Phone") || prodName.equals("Video Game"))
					return true;   // This is for Client Class validation.  
		}
		
		if(prodCat.equals("Toys"))
		{
			if(prodName.equals("Soft Toy") || prodName.equals("Telescope") || prodName.equals("Barbee Doll"))
					return true;    // This is for Client Class validation.
		}
		throw new ProductNameIsNotValidException();
		//return false;           // This is for Client Class validation.
	     
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.ISaleService#validateProductPrice(float)
	 */
	@Override
	public boolean validateProductPrice(float price) throws ProductPriceIsNotValidException
	{
		
		try {
			if(price >= 200f)
				return true;          // This is for Client Class validation.
		}catch(Exception e) {
		}
		throw new ProductPriceIsNotValidException();
		//return false;                 // This is for Client Class validation.
		
	}

}
