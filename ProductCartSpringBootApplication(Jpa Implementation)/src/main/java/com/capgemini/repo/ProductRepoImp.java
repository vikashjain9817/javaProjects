package com.capgemini.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Products;
import com.capgemini.exception.DuplicateProductIdException;
import com.capgemini.exception.ProductNotFoundException;

@Transactional
@Repository
public class ProductRepoImp implements ProductRepo{

	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public Products findById(String id) throws ProductNotFoundException {
		
		Products product;
		product = manager.find(Products.class, id);
		return product;
	}

	@Override
	public Products save(Products products) throws DuplicateProductIdException, ProductNotFoundException{
		
			manager.persist(products);
			return products;
	}

	@Override
	public Products deleteById(Products product) throws ProductNotFoundException {
		
			manager.remove(product);
			return product;
		}

	@Override
	public List<Products> findAll() throws ProductNotFoundException {
		
		return manager.createQuery("SELECT e FROM Products e", Products.class).getResultList();
	}

	@Override
	public Products update(Products product, Products products) throws ProductNotFoundException {
			product.setName(products.getName());
			product.setModel(products.getModel());
			product.setPrice(products.getPrice());
			return product;
	}
	
	

}
