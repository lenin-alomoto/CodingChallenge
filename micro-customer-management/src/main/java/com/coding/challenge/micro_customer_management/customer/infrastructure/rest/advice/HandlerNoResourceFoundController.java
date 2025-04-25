package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class HandlerNoResourceFoundController {

	@ExceptionHandler({ NoResourceFoundException.class })
	public ResponseEntity<ErrorDto> noResourceFound(Exception ex) {
		ErrorDto errorDto = new ErrorDto(
				LocalDate.now(), 
				HttpStatus.NOT_FOUND.value(),
				"No Resource Found", 
				ex.getMessage());
		return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
