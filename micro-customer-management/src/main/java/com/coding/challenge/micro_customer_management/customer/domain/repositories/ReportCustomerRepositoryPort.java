package com.coding.challenge.micro_customer_management.customer.domain.repositories;

import java.util.List;

import com.coding.challenge.micro_customer_management.customer.domain.models.CustomerReport;

public interface ReportCustomerRepositoryPort {
	Double calculateTheAverageAge(); 
	
	Double calculateTheStandardDeviationOfAges();
	
	List<CustomerReport> findAllCustomerWithLifeExpectancy(int ageLifeExpectancy);
}
