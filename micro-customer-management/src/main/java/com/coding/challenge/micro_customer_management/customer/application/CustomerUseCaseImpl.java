package com.coding.challenge.micro_customer_management.customer.application;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coding.challenge.micro_customer_management.customer.application.dto.CustomerRequest;
import com.coding.challenge.micro_customer_management.customer.application.mapper.CustomerMapper;
import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.CustomerRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {

	private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

	private final CustomerRepositoryPort customerRepositoryPort;

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepositoryPort.findAllCustomer();
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerRepositoryPort.findCustomerById(id);
	}

	@Transactional
	@Override
	public Customer saveCustomer(CustomerRequest customerRequest) {
		return customerRepositoryPort.saveCustomer(customerMapper.toDomain(customerRequest));
	}

	@Transactional
	@Override
	public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
		return customerRepositoryPort.updateCustomer(id, customerMapper.toDomain(customerRequest));
	}

	@Override
	public boolean deleteCustomer(Long id) {
		return customerRepositoryPort.deleteCustomer(id);
	}

}
