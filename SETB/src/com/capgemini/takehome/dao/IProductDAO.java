package com.capgemini.takehome.dao;

import com.capgemini.takehome.beans.Product;

/*
 * 
 * create interface of productDAO
 */

public interface IProductDAO {

	/*
	 * 
	 * abstract method which will be 
	 * implemnted whatever class implemented this interface.
	 */
	Product getProductDetails(int productCode);

}