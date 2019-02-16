package com.capgemini.salesmanagement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.beans.Sale;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class SaleDAO implements ISaleDAO {
	
	/* (non-Javadoc)
	 * @see com.capgemini.salesmanagement.dao.ISaleDAO#insertSalesDetails(com.capgemini.salesmanagement.beans.Sale)
	 */
	@Override
	public  HashMap<Integer, Sale> insertSalesDetails(Sale sale)
	{
		return CollectionUtil.insertDetails(sale);
		
	}

	@Override
	public Sale getDetails(int productCode) {
		// TODO Auto-generated method stub
		return CollectionUtil.getCollection(productCode);
	}

}
