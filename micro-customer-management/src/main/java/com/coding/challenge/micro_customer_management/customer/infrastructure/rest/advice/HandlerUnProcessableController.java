package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerUnProcessableController {
	
	@ExceptionHandler({ DataIntegrityViolationException.class})
	public ResponseEntity<ErrorDto> accessDatabase(Exception ex) {
		ErrorDto errorDto = new ErrorDto(LocalDate.now(),
			HttpStatus.UNPROCESSABLE_ENTITY.value(),
			"Unprocessable Entity",
			ex.getMessage()
		);
		
		return ResponseEntity.unprocessableEntity().body(errorDto);
	}
}