package com.capgemini.salesmanagement.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.bean.Sale;

public class CollectionUtil {
	
	private static Map<Integer, Sale>  sales=new HashMap<Integer, Sale>();
	
	public static Sale InsertDetails(Sale sale)
	{
		int id = (int) (Math.random()*1000);
		int price = sale.getQuantity()*sale.getPrice();
		sale.setLineTotal(price);
		sales.put(id, sale);
		return sales.get(id);
		
	}
	public static Map<Integer, Sale> getCollection()
	{
		
		return sales;
	}
	

}
