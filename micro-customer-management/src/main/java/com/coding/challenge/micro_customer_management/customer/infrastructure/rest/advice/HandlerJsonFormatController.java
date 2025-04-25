package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerJsonFormatController {
	
	private static final String MESSAGE_FORMAT = "The correct format is: yyyy-MM-dd. Example: 1900-12-01. ";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handleNotReadableException(HttpMessageNotReadableException ex) {
		ErrorDto errorDto = new ErrorDto(
				LocalDate.now(), 
				HttpStatus.BAD_REQUEST.value(),
				"Bad Request", 
				MESSAGE_FORMAT.concat(ex.getMessage()));
		return ResponseEntity.badRequest().body(errorDto);
    }
}
