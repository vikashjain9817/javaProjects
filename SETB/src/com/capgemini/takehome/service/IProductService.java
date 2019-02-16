package com.capgemini.takehome.service;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exception.ProductIdIsNotValidException;
/*
 * interface of service class.
 */
public interface IProductService {

	/*
	 * 
	 * abstarct method ehich will be implemented whatever clas implemented this interface.
	 */
	Product getProductDetails(int productCode) throws ProductIdIsNotValidException;

}