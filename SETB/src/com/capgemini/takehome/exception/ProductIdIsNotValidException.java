package com.capgemini.takehome.exception;

@SuppressWarnings("serial")

/*
 * 
 * user defined exception class.
 */

public class ProductIdIsNotValidException extends Exception {
	
	/*
	 * constructor which takes string as a message
	 * and passed to the constructor of super class.
	 */
	public ProductIdIsNotValidException(String msg)
	{
		super(msg);
	}
}
