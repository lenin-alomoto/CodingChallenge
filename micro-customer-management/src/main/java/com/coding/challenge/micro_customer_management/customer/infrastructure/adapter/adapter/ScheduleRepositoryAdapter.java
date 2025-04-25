package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.adapter;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.ScheduleRepositoryPort;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.mapper.CustomerMapper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.repository.ScheduleRepositoryJpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ScheduleRepositoryAdapter implements ScheduleRepositoryPort {

	private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

	private final ScheduleRepositoryJpa scheduleRepositoryJpa;
	
	@Override
	public List<Customer> findAllCustomerByMonthAndDay(int month, int day) {
		return customerMapper.toDomain(scheduleRepositoryJpa.findAllByMonthAndDay(month, day));
	}

	@Override
	public void updateCustomer(Customer customer) {
		scheduleRepositoryJpa.save(customerMapper.toEntity(customer));
	}

}
