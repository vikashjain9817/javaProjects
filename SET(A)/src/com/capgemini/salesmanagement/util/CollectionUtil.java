package com.capgemini.salesmanagement.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.salesmanagement.beans.Sale;

public class CollectionUtil {
	/*
	 * create HashMap of type (Integer, Sale). 
	 */
	private static Map<Integer, Sale> sales = new HashMap<Integer, Sale>();
	
	/*
	 * This Method will return the HashMap.
	 */
	public static Sale getCollection(int productCode)
	{
		for (Map.Entry<Integer, Sale> entry : sales.entrySet())  {	
			if(entry.getKey().equals(productCode)) {
				return sales.get(productCode);
			}
		  }
		return null;
		
	}

	public static HashMap<Integer, Sale> insertDetails(Sale sale) {
		int key = (int)Math.random()*1000;
		sales.put(key, sale);
		return (HashMap<Integer, Sale>) sales; 
	}
}
