package com.capgemini.takehome.ui;

import java.util.Scanner;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exception.ProductIdIsNotValidException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class Client {

	/*
	 * create scanner class object for taking input from the user.
	 */
	static Scanner sc = new Scanner(System.in);
	
	/*
	 * create the object of product service class to call the method 
	 * to find out the product.
	 */
	static IProductService productService = new ProductService();
	
	/*
	 * main method
	 */
	
	public static void main(String[] args) throws ProductIdIsNotValidException {
		
		/*
		 * menu which will appear to the end user.
		 */
		while(true)
		{
			System.out.println("1) Generating Bill by entering Product code and quantity");
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
    /*
     * This Method will take the details so that product 
     * line total will be printed.
     */
	private static void getDetails() throws ProductIdIsNotValidException {
		System.out.println("1) Enter The Product Code");
		int productCode = sc.nextInt();
		/*
		 * this loop will be executed until 
		 * you given the valid valid product code.
		 */
		while(!validateProductCode(productCode)) {
			System.out.println("1)Product Code is Not valid :: Enter The Product Code Again");
			productCode = sc.nextInt();
		}
		
		System.out.println("2) Enter The Quantity");
		int quantity = sc.nextInt();
		
		/*
		 * this loop will be executed until 
		 * you given the valid valid product quantity.
		 */
		
		while(!validateQuantity(quantity)) {
			System.out.println("1)Quantity Is Not Valid :: Enter The Product quantity should be greater than 0:");
			quantity = sc.nextInt();
		}
		try {
			
			Product p = productService.getProductDetails(productCode);
			int lineTotal = p.getProductPrice()*quantity;
			System.out.println("Product Name:"+ p.getProductName());
			System.out.println("Product Category:" + p.getProductCategory());
			System.out.println("Product Description:"+ p.getProductDescription());
			System.out.println("Product price:"+ p.getProductPrice());
			System.out.println("Product Quantity:"+ p.getProductPrice());
			System.out.println("Line Total(Rs):" +lineTotal);
		}catch(ProductIdIsNotValidException e) {
			System.out.println(e);
			System.out.println("________________________________________________________________________________________");
		}
	}
	/*
	 * validate the product code and return the false if :
	 * the product code is less/greater than 4.
	 * and else return true.
	 */
	private static boolean validateProductCode(int productCode)
	{
		int count = 0 ;
		while(productCode != 0)
	    {
	        productCode /= 10;
	        ++count;
	    }
		if(count == 4)
			return true;
		else
			return false;
		
	}
	/*
	 * validate the product quantity and return the false if :
	 * the product quantity is less or equal to 0.
	 * and else return true.
	 */
	private static boolean validateQuantity(int quantity)
	{
		if(quantity <= 0)
			return false;
		else
			return true;
		
	}

}
