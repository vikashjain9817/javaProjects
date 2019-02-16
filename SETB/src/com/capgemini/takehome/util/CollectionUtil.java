package com.capgemini.takehome.util;

import java.util.HashMap;
import java.util.Map;
import com.capgemini.takehome.beans.Product;

public class CollectionUtil {
	
	/*
	 * create map which store the information of products.
	 */
	private static Map<Integer, Product> products = new HashMap<Integer, Product>();
	
	/*
	 * static initilizer block which intilize the map which the values.
	 */
	static {
		products.put(1001, new Product(1001,"iPhone","Electronics","Smart Phone",35000));
		products.put(1002, new Product(1002,"LEDTV","Electronics","Smart TV",45000));
		products.put(1003, new Product(1003,"Teddy","Toys","Play",800));
		products.put(1004, new Product(1004,"TeleSCOPE","Toys","Instrument",5000));
	}
	
	/*
	 * 
	 * method which will search for the given
	 * product code then return the product
	 * if not exist then return null.
	 */
	public static Product getProductDetails(int productCode)
	{
		
		for (Map.Entry<Integer, Product> entry : products.entrySet())  {	
			if(entry.getKey().equals(productCode)) {
				return products.get(productCode);
			}
		  }
		return null;
		
	}

}
