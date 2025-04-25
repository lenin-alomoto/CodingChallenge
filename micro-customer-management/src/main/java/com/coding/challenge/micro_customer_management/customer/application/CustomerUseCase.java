package com.coding.challenge.micro_customer_management.customer.application;

import java.util.List;

import com.coding.challenge.micro_customer_management.customer.application.dto.CustomerRequest;
import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;

public interface CustomerUseCase {

	List<Customer> findAllCustomer();
	
	Customer findCustomerById(Long id);
	
	Customer saveCustomer(CustomerRequest customerRequest);
	
	Customer updateCustomer(Long id, CustomerRequest customerRequest);
	
	boolean deleteCustomer(Long id);
	
}
