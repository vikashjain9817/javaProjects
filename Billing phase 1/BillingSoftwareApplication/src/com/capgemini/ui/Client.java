package com.capgemini.ui;

import java.time.LocalDate;

import com.capgemini.bean.Sale;
import com.capgemini.dao.SaleDAO;
import com.capgemini.exception.ProductIdIsNotValidException;
import com.capgemini.exception.ProductPriceIsNotValidException;
import com.capgemini.salesmanagement.util.CollectionUtil;
import com.capgemini.service.SaleService;

public class Client {

	public static void main(String[] args) throws ProductIdIsNotValidException, ProductPriceIsNotValidException {
		
		/*
		 * create the objects of SaleService 
		 * and SaleDAO.
		 */
		SaleService saleService = new SaleService();
		SaleDAO saleDao = new SaleDAO();
		
		/*
		 * 
		 * create the objects of Sale class. 
		 */
		Sale sale = new Sale(1001, "Tv", "Electronics", LocalDate.now(), 2, 0, 35000);
		Sale sale2 = new Sale(1002, "Smart Phone", "Electronics", LocalDate.now(), 2, 0, 15000);
		Sale sale3 = new Sale(1003, "Soft Toy", "Toys", LocalDate.now(), 2, 0, 500);
		Sale sale1 = new Sale(1245, "Barbee Doll", "Toys", LocalDate.now(), 2, 0, 800);
		
		/*
		 * 
		 * check whether the given product code is valid or not.
		 */
		try {
			if(saleService.validateProduct(sale.getProdCode()))
					System.out.println("product id is validated");
		}catch(Exception e) {
			System.out.println("not validated");
		}
		
		/*
		 * check whether the product id is validated or not.
		 */
		try {
			if(saleService.validateProduct(sale1.getProdCode()))
				System.out.println("product id is validated");
		}catch(Exception e) {
			System.out.println("not validated");
		}
		
		/*
		 * check whether the product price is validated or not.
		 */
		
		try {
			if(saleService.validateProductPrice(sale1.getPrice()))
				System.out.println("product id is validated");
		}catch(Exception e) {
			System.out.println("not validated");
		}
		
		/*
		 * To save the sale objects
		 *  to the collection of type HashMap.
		 */
		saleDao.insertSalesDetails(sale);
		saleDao.insertSalesDetails(sale2);
		saleDao.insertSalesDetails(sale3);
		
		/*
		 * This is the method of CollectionUtil class
		 *  and return all the objects of sale type class. 
		 */
		CollectionUtil.getCollection();
	}

}
