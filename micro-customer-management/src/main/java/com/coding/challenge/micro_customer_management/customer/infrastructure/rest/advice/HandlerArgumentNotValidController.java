package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerArgumentNotValidController {
	
	@ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<Map<String, Object>> httpRequestNotReadable(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors()
	                .stream().map(FieldError::getDefaultMessage)
	                .toList();
	        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
	
	private Map<String, Object> getErrorsMap(List<String> errors) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("date", LocalDate.now());
        errorMap.put("status", HttpStatus.BAD_REQUEST.value());
        errorMap.put("error", "Bad Request");
        errorMap.put("message", errors);
        return errorMap;
    }
}
