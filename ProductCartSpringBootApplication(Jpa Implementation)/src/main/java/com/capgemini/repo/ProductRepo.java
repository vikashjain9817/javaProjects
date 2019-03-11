package com.capgemini.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Products;
import com.capgemini.exception.DuplicateProductIdException;
import com.capgemini.exception.ProductNotFoundException;

@Repository
public interface ProductRepo{

	Products findById(String id) throws ProductNotFoundException;

	Products save(Products products) throws DuplicateProductIdException, ProductNotFoundException;

	Products deleteById(Products products) throws ProductNotFoundException;

	List<Products> findAll() throws ProductNotFoundException;

	Products update(Products products, Products product) throws ProductNotFoundException;
	
	
	

}