package com.capgemini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> productNotException(ProductNotFoundException e)
	{
		return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DuplicateProductIdException.class)
	public ResponseEntity<Object> duplicateIdFoundException(DuplicateProductIdException e)
	{
		return new ResponseEntity<>("Product Already Registered", HttpStatus.NOT_FOUND);
	}
	
}