package com.capgemini.service;

import java.util.List;

//import java.util.List;

import com.capgemini.beans.Products;
import com.capgemini.exception.DuplicateProductIdException;
import com.capgemini.exception.ProductNotFoundException;

public interface ProductService {

	public Products createProduct(Products products) throws DuplicateProductIdException, ProductNotFoundException;

	public Products deleteProduct(String id) throws ProductNotFoundException;
	
	public List<Products> viewProducts() throws ProductNotFoundException;
	
	public Products findProduct(String id) throws ProductNotFoundException;

	public Products updateProduct(Products products, String id) throws ProductNotFoundException;

	
}
