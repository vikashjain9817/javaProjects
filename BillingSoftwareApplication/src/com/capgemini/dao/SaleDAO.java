package com.capgemini.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.bean.Sale;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class SaleDAO implements ISaleDAO {
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IsaleDAO#insertSalesDetails(com.capgemini.bean.Sale)
	 */
	
	@Override
	public Sale insertSalesDetails(Sale sale)
	{
	
		return CollectionUtil.InsertDetails(sale);
		
	}
	
	
	
}
