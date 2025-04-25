package com.coding.challenge.micro_customer_management.customer.domain.repositories;

import java.util.List;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;

public interface CustomerRepositoryPort {

	List<Customer> findAllCustomer();
	
	Customer findCustomerById(Long id);
	
	Customer saveCustomer(Customer customer);
	
	Customer updateCustomer(Long id, Customer customer);
	
	boolean deleteCustomer(Long id);

}
