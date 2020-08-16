package com.walmart.test.config.advice;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	
	private LocalDateTime date;
	
	private String message;
	
	private String description;

	public ErrorResponse(String message, String description) {
		this.date = LocalDateTime.now();
		this.message = message;
		this.description = description;
	}
	
	public ErrorResponse(LocalDateTime date, String message, String description) {
		this.date = date;
		this.message = message;
		this.description = description;

	}
	
}
