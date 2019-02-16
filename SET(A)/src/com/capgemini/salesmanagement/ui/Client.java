package com.capgemini.salesmanagement.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Sale;
import com.capgemini.salesmanagement.service.ISaleServices;
import com.capgemini.salesmanagement.service.SaleServices;

public class Client {

	/*
	 * create scanner class object for taking input from the user.
	 */
	static Scanner sc = new Scanner(System.in);
	
	/*
	 *create the object of service class. 
	 */
	static ISaleServices saleService = new SaleServices();
	/*
	 * create the object of product service class to call the method 
	 * to find out the product.
	 */
	static ISaleServices productService = new SaleServices();
	
	/*
	 * main method
	 */
	
	public static void main(String[] args){
		
		/*
		 * menu which will appear to the end user.
		 */
		while(true)
		{
			System.out.println("1) Enter Product Details");
			System.out.println("2) exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: getDetails();break;
			case 2: System.exit(0);
			default: System.out.println("Wrong choice!");break;
			}
		}
	}

	private static void getDetails() {
		/*
		 * This will receive the valid product code.
		 */
		
		System.out.println("Enter The Product Code:");
		int productCode = sc.nextInt();
		while(!saleService.validateProductCode(productCode)) {
			System.out.println("product code Invalid :: Enter Again:");
			productCode = sc.nextInt();
		}
		
		/*
		 * This will receive the valid product Quantity.
		 */
		System.out.println("Enter The Quantity:");
		int quantity = sc.nextInt();
		while(!saleService.validateProductQuantity(quantity)) {
			System.out.println("product quantity Invalid :: Enter Again:");
			quantity = sc.nextInt();
		}
		/*
		 * This will receive the valid product Category.
		 */
		System.out.println("Enter The Product Category:");
		String category = sc.next();
		while(!saleService.validateProductCategory(category)) {
			System.out.println("product category Invalid :: Enter Again:");
			category = sc.next();
		}
		/*
		 * This will receive the valid product Name.
		 */
		System.out.println("Enter The Product Name:");
		String productName = sc.next();
		if(category.equals("Electronics")) {
			productName = "E" + productName;
			System.out.println(productName);
			while(!saleService.validateProductName(productName)) {
				System.out.println("product Name Invalid :: Enter Again:");
				productName = sc.next();
				productName = "E" + productName;
			}
		}
		else {
			productName = "T" + productName;
			while(!saleService.validateProductName(productName)) {
				System.out.println("product Name Invalid :: Enter Again:");
				productName = sc.next();
				productName = "T" + productName;
			}
		}
		/*
		 * This will receive the valid product Description.
		 */
		System.out.println("Enter The Product Description:");
		String productDescription = sc.next();
		
		/*
		 * This will receive the valid product Price .
		 */
		System.out.println("Enter The Product Price:");
		float productPrice = sc.nextFloat();
		while(!saleService.validateProductPrice(productPrice)) {
			System.out.println("product Price Invalid :: Enter Again:");
			productPrice = sc.nextFloat();
		}
		
		try {
			Sale s1 = new Sale(productCode, productName, category, LocalDate.now(),quantity, 0);
			int lineTotal = (int) (s1.getQuantity()*productPrice);
			s1.setLineTotal(lineTotal);
			productService.insertSalesDetails(s1);
			Sale s = productService.getDetails(productCode);
			System.out.println("Product Name:"+ s.getProductName());
			System.out.println("Product Category:" + s.getCategory());
			System.out.println("Product Description:"+ productDescription);
			System.out.println("Product price:"+ productPrice);
			System.out.println("Product Quantity:"+ s.getQuantity());
			System.out.println("Line Total(Rs):" +s.getLineTotal());
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("________________________________________________________________________________________");
		}
	}
	

}
