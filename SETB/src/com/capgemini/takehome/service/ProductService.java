package com.capgemini.takehome.service;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductADAO;
import com.capgemini.takehome.exception.ProductIdIsNotValidException;

public class ProductService implements IProductService {
	
	static IProductDAO productDAO = new ProductADAO();
	
	/* (non-Javadoc)
	 * @see com.capgemini.takehome.service.IProductService#getProductDetails(java.lang.String)
	 */
	@Override
	public Product getProductDetails(int productCode) throws ProductIdIsNotValidException
	{
		/*
		 * check whether the product is available or not
		 * if available then return product
		 * if not then throw an user difind exceptioon.
		 */
		if(productDAO.getProductDetails(productCode) == null)
			throw new ProductIdIsNotValidException("product id is not valid OR product is not available");
		else
			return productDAO.getProductDetails(productCode);
					
	}
}
