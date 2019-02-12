package com.capgemini.ui;

import java.time.LocalDate;

import com.capgemini.bean.Sale;
import com.capgemini.dao.SaleDAO;
import com.capgemini.exception.ProductIdIsNotValidException;
import com.capgemini.exception.ProductPriceIsNotValidException;
import com.capgemini.service.SaleService;

public class Client {

	public static void main(String[] args) throws ProductIdIsNotValidException, ProductPriceIsNotValidException {
		
		
		SaleService saleService = new SaleService();
		SaleDAO saleDao = new SaleDAO();
		
		
		Sale sale = new Sale(1001, "Tv", "Electronics", LocalDate.now(), 2, 0, 35000);
		Sale sale1 = new Sale(1209, "Tv", "Electronics", LocalDate.now(), 2, 0, 100);
		
		if(saleService.validateProduct(sale.getProdCode()))
				System.out.println("product id is validated");
		else
			System.out.println("not validated");
		
		if(saleService.validateProduct(sale1.getProdCode()))
			System.out.println("product id is validated");
		else
			System.out.println("not validated");
		
		if(saleService.validateProductPrice(sale1.getPrice()))
			System.out.println("product id is validated");
		else
			System.out.println("not validated");
		
		System.out.println(saleDao.insertSalesDetails(sale));
		

	}

}
