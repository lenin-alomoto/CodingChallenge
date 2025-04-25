package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.challenge.micro_customer_management.customer.application.CustomerUseCase;
import com.coding.challenge.micro_customer_management.customer.application.dto.CustomerRequest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerUseCase customerUseCase;

	private Map<String, Object> response;

	@GetMapping
	@Operation(description = "Returns all customers")
	public ResponseEntity<?> findAllCustomer() {
		return ResponseEntity.ok(customerUseCase.findAllCustomer());
	}

	@GetMapping("/{id}")
	@Operation(description = "Returnsthe customer by ID")
	public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
		return ResponseEntity.ok(customerUseCase.findCustomerById(id));
	}

	@PostMapping
	@Operation(description = "Create the customer")
	public ResponseEntity<?> saveCustomer(@Validated @RequestBody CustomerRequest customerRequest) {
		return ResponseEntity.ok(customerUseCase.saveCustomer(customerRequest));
	}

	@PutMapping("/{id}")
	@Operation(description = "Update the customer")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id,
			@Validated @RequestBody CustomerRequest customerRequest) {
		return ResponseEntity.ok(customerUseCase.updateCustomer(id, customerRequest));
	}

	@DeleteMapping("/{id}")
	@Operation(description = "Delete the customer")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		response = new HashMap<>();
		if (customerUseCase.deleteCustomer(id)) {
			response.put("message", "Customer deleted");
			return ResponseEntity.ok(response);
		}
		response.put("message", "Customer not deleted");
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
