package com.capgemini.exception;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.beans.ErrorDetails;

@ControllerAdvice
public class ProductExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DuplicateProductIdException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(DuplicateProductIdException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(ProductNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ProductNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		return new ResponseEntity<>(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}  
	
}