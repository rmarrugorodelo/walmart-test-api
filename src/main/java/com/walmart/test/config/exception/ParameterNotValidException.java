package com.walmart.test.config.exception;

public class ParameterNotValidException extends RuntimeException {

	public ParameterNotValidException() {}
	
	public ParameterNotValidException(String message) {
		super(message);
	}

}
