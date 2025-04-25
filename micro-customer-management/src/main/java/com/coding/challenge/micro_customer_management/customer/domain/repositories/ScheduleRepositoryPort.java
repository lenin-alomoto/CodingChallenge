package com.coding.challenge.micro_customer_management.customer.domain.repositories;

import java.util.List;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;

public interface ScheduleRepositoryPort {

	List<Customer> findAllCustomerByMonthAndDay(int month, int day);
	
	void updateCustomer(Customer customer);
}
