package com.capgemini.service;

import java.util.List;


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
			throw new DuplicateProductIdException("Product is Already registered with this id :: please entered another id");
	}
	
	@Override
	public Products deleteProduct(String id) throws ProductNotFoundException {
		Products product;
		product = prorepo.findById(id);
		if(product != null) {
			return prorepo.deleteById(product);
		}
		else
			throw new ProductNotFoundException("Product Not found for Delete");
	}
		

	@Override
	public List<Products> viewProducts() throws ProductNotFoundException {
		
		List<Products> listProduct= prorepo.findAll();
		if (listProduct.isEmpty()) {
	        throw new ProductNotFoundException("The products are not avaliable");
	    }
		else
			return listProduct;
		
	}
	@Override
	public Products findProduct(String id) throws ProductNotFoundException {
		
		Products product = prorepo.findById(id);
		if(product == null)
			throw new ProductNotFoundException("Product is not exist");
		else
			return product;
	}

	@Override
	public Products updateProduct(Products products, String id) throws ProductNotFoundException{
		
		Products product = prorepo.findById(id);
		if(product == null)
			throw new ProductNotFoundException("This product id does not exist to Update");
		else {
			return prorepo.update(product, products);
		}
	}

	}