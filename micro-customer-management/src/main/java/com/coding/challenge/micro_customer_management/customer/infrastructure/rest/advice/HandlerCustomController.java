package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.exception.CustomerException;

@RestControllerAdvice
public class HandlerCustomController {

	@ExceptionHandler({ CustomerException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> errorCustom(Exception ex) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("date", LocalDate.now());
		errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorMap.put("error", "Internal Server Error");
		errorMap.put("message", ex.getMessage());
		
		return errorMap;
	}
}
