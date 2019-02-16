package com.capgemini.salesmanagement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.beans.Sale;

public interface ISaleDAO {

	HashMap<Integer, Sale> insertSalesDetails(Sale sale);

	Sale getDetails(int productCode);

}