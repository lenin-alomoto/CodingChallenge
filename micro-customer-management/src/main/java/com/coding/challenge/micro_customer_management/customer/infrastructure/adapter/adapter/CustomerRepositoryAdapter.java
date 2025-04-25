package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.adapter;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.CustomerRepositoryPort;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.constant.CustomerConstant;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.exception.CustomerException;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper.DateHelper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.mapper.CustomerMapper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.repository.CustomerRepositoryJpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {

	private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

	private final CustomerRepositoryJpa customerRepositoryJpa;

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepositoryJpa.findAll().stream()
			.map(customer -> customerMapper.toDomain(customer)).toList();
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerRepositoryJpa.findById(id)
				.map(customer -> customerMapper.toDomain(customer))
				.orElseThrow(() -> new CustomerException(String.format(CustomerConstant.MESSAGE_NO_CUSTOMER, id)));
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setAge(DateHelper.calculateBirthDays(customer.getBirthDate()));
		return customerMapper.toDomain(customerRepositoryJpa.save(customerMapper.toEntity(customer)));
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		findCustomerById(id);
		customer.setId(id);
		return saveCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(Long id) {
		try {
			findCustomerById(id);
			customerRepositoryJpa.deleteById(id);
			return true;
		} catch (CustomerException ex) {
			log.error(ex.getMessage());
			return false;
		}
	}

}
