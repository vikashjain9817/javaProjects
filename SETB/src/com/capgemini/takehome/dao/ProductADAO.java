package com.capgemini.takehome.dao;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.util.CollectionUtil;

public class ProductADAO implements IProductDAO {
	
	/* (non-Javadoc)
	 * @see com.capgemini.takehome.dao.IProductDAO#getProductDetails(java.lang.String)
	 */
	@Override
	public Product getProductDetails(int productCode)
	{
		return CollectionUtil.getProductDetails(productCode);
		
	}
}
