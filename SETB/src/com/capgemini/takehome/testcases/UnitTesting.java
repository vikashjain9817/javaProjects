package com.capgemini.takehome.testcases;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exception.ProductIdIsNotValidException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class UnitTesting {

	/*
	 * This method will be executed before every test cases and print the given message.
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("enter product code for testing:::");
	}

	/*
	 * The first test case will be green if the product id is valid.
	 */
	@Test
	public void WhenTheProductidIsValidThenPrintAllTheDetailsSuccessfully() throws ProductIdIsNotValidException {
		Scanner sc = new Scanner(System.in);
		IProductService productService = new ProductService();
		System.out.println("1st test case passed if you give the valid product code");
		int productCode = sc.nextInt();
		Product p = productService.getProductDetails(productCode);
		assertEquals(productCode, p.getProductId() );
		sc.close();
	}
	

	/*
	 * The Second test case will be green if the product id is Invalid.
	 */
	@Test(expected = com.capgemini.takehome.exception.ProductIdIsNotValidException.class)
	public void WhenTheProductidIsNotValidThenPrintAllTheDetailsSuccessfully() throws ProductIdIsNotValidException {
		Scanner sc = new Scanner(System.in);
		IProductService productService = new ProductService();
		System.out.println("2nd test case passed if you give the Invalid product code");
		int productCode = sc.nextInt();
		productService.getProductDetails(productCode);
		sc.close();
	}

}
