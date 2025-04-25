package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerDataBaseController {
	
	@ExceptionHandler({ InvalidDataAccessResourceUsageException.class})
	public ResponseEntity<ErrorDto> accessDatabase(Exception ex) {
		ErrorDto errorDto = new ErrorDto(LocalDate.now(),
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"Internal Server Error",
			ex.getMessage()
		);
		
		return ResponseEntity.internalServerError().body(errorDto);
	}
}