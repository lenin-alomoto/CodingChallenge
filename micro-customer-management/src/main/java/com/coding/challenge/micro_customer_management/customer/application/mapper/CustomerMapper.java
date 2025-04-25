package com.coding.challenge.micro_customer_management.customer.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.coding.challenge.micro_customer_management.customer.application.dto.CustomerRequest;
import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;

@Mapper
public interface CustomerMapper {

	@Mapping(ignore = true, target = "id")
	@Mapping(ignore = true, target = "age")
	Customer toDomain(CustomerRequest customerRequest);
	
}
