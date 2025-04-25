package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.challenge.micro_customer_management.customer.application.ReportUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
	
	private final ReportUseCase reportUseCase;
	
	private Map<String, Object> response;
	
	@GetMapping("/average") 
	public ResponseEntity<Map<String, Object>> findAverageAge() {
		response = new HashMap<> ();
		response.put("The average: ", reportUseCase.calculateTheAverageAge());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/standard-deviation") 
	public ResponseEntity<Map<String, Object>> findTheStandardDeviationOfAges() {
		response = new HashMap<> ();
		response.put("The standard deviation: ", reportUseCase.calculateTheStandardDeviationOfAges());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomerWithLifeExpectancy(@RequestParam int ageLifeExpectancy) {
		return ResponseEntity.ok(reportUseCase.findAllCustomerWithLifeExpectancy(ageLifeExpectancy));
	}

}
