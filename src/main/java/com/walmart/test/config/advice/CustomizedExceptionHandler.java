package com.walmart.test.config.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.walmart.test.config.exception.ParameterNotValidException;

@ControllerAdvice
public class CustomizedExceptionHandler {
	

	@ExceptionHandler(ParameterNotValidException.class)
	public ResponseEntity<ErrorResponse> handleException(ParameterNotValidException ex) {
		ErrorResponse exception = new ErrorResponse( "Parameter not valid", ex.getMessage());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

}
