package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;
import com.coding.challenge.micro_customer_management.customer.domain.models.CustomerReport;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {

	Customer toDomain(CustomerEntity customerEntity);
	
	CustomerEntity toEntity(Customer customer);
	
	@Mapping(ignore = true, target = "ageLifeExpectancy")
	CustomerReport toReportDomain(CustomerEntity customerEntity);
}
