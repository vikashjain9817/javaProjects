package com.capgemini.service;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Products;
import com.capgemini.exception.DuplicateProductIdException;
import com.capgemini.exception.ProductNotFoundException;
import com.capgemini.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo prorepo;
	
	@Override
	public Products createProduct(Products products) throws DuplicateProductIdException, ProductNotFoundException {
		
		if(prorepo.findById(products.getId()) == null)
			return prorepo.save(products) ;
		else
			throw new DuplicateProductIdException();
	}
	
	@Override
	public Products deleteProduct(String id) throws ProductNotFoundException {
		Products product;
		product = prorepo.findById(id);
		if(product != null) {
			return prorepo.deleteById(product);
		}
		else
			throw new ProductNotFoundException();
	}
		

	@Override
	public List<Products> viewProducts() throws ProductNotFoundException {
		
		List<Products> listProduct= prorepo.findAll();
		if (listProduct.isEmpty()) {
	        throw new ProductNotFoundException();
	    }
		else
			return listProduct;
		
	}
	@Override
	public Products findProduct(String id) throws ProductNotFoundException {
		
		Products product = prorepo.findById(id);
		if(product == null)
			throw new ProductNotFoundException();
		else
			return product;
	}

	@Override
	public Products updateProduct(Products products, String id) throws ProductNotFoundException{
		
		Products product = prorepo.findById(id);
		if(product == null)
			throw new ProductNotFoundException();
		else {
			return prorepo.update(product, products);
		}
	}

	}