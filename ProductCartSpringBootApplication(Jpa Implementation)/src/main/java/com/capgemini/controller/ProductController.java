package com.capgemini.controller;

import java.util.List;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Products;
import com.capgemini.exception.DuplicateProductIdException;
import com.capgemini.exception.ProductNotFoundException;
import com.capgemini.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService proservice;

	@RequestMapping(method = RequestMethod.POST, value = "/addproduct")
	public Products createProduct(@Valid @RequestBody Products products) throws DuplicateProductIdException, ProductNotFoundException {
		return proservice.createProduct(products);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteproduct/{id}")
	public Products deleteProduct(@Valid @PathVariable String id) throws ProductNotFoundException {
		return proservice.deleteProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewproducts")
	public List<Products> viewProducts() throws ProductNotFoundException {
		return  proservice.viewProducts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findproduct/{id}")
	public Products findProduct(@Valid @PathVariable String id) throws ProductNotFoundException {
		
		return proservice.findProduct(id);
		
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateproduct/{id}")
	public Products findProduct(@Valid @RequestBody Products products ,@Valid @PathVariable String id) throws ProductNotFoundException {
		return proservice.updateProduct(products,id);
	}
}