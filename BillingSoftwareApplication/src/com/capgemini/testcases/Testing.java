package com.capgemini.testcases;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bean.Sale;
import com.capgemini.dao.SaleDAO;
import com.capgemini.exception.ProductIdIsNotValidException;
import com.capgemini.exception.ProductNameIsNotValidException;
import com.capgemini.exception.ProductPriceIsNotValidException;
import com.capgemini.exception.ProductQuantityIsNotValidException;
import com.capgemini.exception.ProductcateIsNotValidException;
import com.capgemini.service.SaleService;


public class Testing {
	
	SaleService saleService = new SaleService();
	SaleDAO saleDao = new SaleDAO();
	
	@Test(expected = com.capgemini.exception.ProductIdIsNotValidException.class)
	public void WhenTheIDIsNotValidThenThrowAnError() throws ProductIdIsNotValidException {
		Sale sale = new Sale(1209, "Tv", "Electronics", LocalDate.now(), 2, 0, 35000);
		saleService.validateProduct(sale.getSaleId());
	}
	
	@Test
	public void WhenTheAllDetailsAreValidThenStoreSuccessfully() throws ProductIdIsNotValidException {
		Sale sale = new Sale(1001, "Tv", "Electronics", LocalDate.now(), 2, 0, 35000);
		saleDao.insertSalesDetails(sale);
	}
	
	@Test(expected = com.capgemini.exception.ProductNameIsNotValidException.class)
	public void WhenTheNameIsNotValidThenThrowAnError() throws ProductNameIsNotValidException {
		Sale sale = new Sale(1001, "Tv", "", LocalDate.now(), 2, 0, 35000);
		saleService.validateProductName("Soft Toy", "Electronics");
	}
	
	
	@Test(expected = com.capgemini.exception.ProductcateIsNotValidException.class)
	public void WhenTheCategoryIsNotValidThenThrowAnError() throws ProductcateIsNotValidException, ProductNameIsNotValidException {
		Sale sale = new Sale(1001, "Tv", "painter", LocalDate.now(), 2, 0, 35000);
		saleService.validateProductCat(sale.getCategory());
	}
	
	
	@Test(expected = com.capgemini.exception.ProductPriceIsNotValidException.class)
	public void WhenThePriceIsNotValidThenThrowAnError() throws ProductcateIsNotValidException, ProductNameIsNotValidException, ProductPriceIsNotValidException {
		Sale sale = new Sale(1001, "Tv", "Electronics", LocalDate.now(), 2, 0, 100);
		saleService.validateProductPrice(sale.getPrice());
	}

	
	@Test(expected = com.capgemini.exception.ProductQuantityIsNotValidException.class)
	public void WhenTheQuantityIsNotValidThenThrowAnError() throws ProductcateIsNotValidException, ProductNameIsNotValidException, ProductPriceIsNotValidException, ProductQuantityIsNotValidException {
		Sale sale = new Sale(1001, "Tv", "Electronics", LocalDate.now(), 6, 0, 35000);
		saleService.validateQuantity(sale.getQuantity());
	}

}
