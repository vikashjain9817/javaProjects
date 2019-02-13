package com.capgemini.service;

import com.capgemini.exception.ProductIdIsNotValidException;
import com.capgemini.exception.ProductNameIsNotValidException;
import com.capgemini.exception.ProductPriceIsNotValidException;
import com.capgemini.exception.ProductcateIsNotValidException;

public interface ISaleService {

	boolean validateProduct(int productId) throws ProductIdIsNotValidException;

	boolean validateProductCat(String prodCat) throws ProductcateIsNotValidException;

	boolean validateProductName(String prodName, String prodCat) throws ProductNameIsNotValidException;

	boolean validateProductPrice(float price) throws ProductPriceIsNotValidException;

}