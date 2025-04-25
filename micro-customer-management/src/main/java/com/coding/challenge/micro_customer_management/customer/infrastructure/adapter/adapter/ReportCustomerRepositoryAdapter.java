package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.adapter;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.coding.challenge.micro_customer_management.customer.domain.models.CustomerReport;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.ReportCustomerRepositoryPort;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.entity.CustomerEntity;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper.DateHelper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper.StandardDeviationHelper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.mapper.CustomerMapper;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.repository.CustomerRepositoryJpa;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReportCustomerRepositoryAdapter implements ReportCustomerRepositoryPort {

	private final CustomerRepositoryJpa customerRepositoryJpa;

	private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

	@Override
	public Double calculateTheAverageAge() {
		return customerRepositoryJpa.findTheAverageAge();
	}

	@Override
	public Double calculateTheStandardDeviationOfAges() {
		var valuesAge = findAllAge();

		return StandardDeviationHelper.calculateStandardDeviation(valuesAge);
	}

	private List<Integer> findAllAge() {
		return customerRepositoryJpa.findAll().stream().map(CustomerEntity::getAge).toList();
	}

	@Override
	public List<CustomerReport> findAllCustomerWithLifeExpectancy(int ageLifeExpectancy) {
		return customerRepositoryJpa.findAll().stream().map(customer -> {
			var customerAge = customerMapper.toReportDomain(customer);
			customerAge.setAgeLifeExpectancy(DateHelper.calculateLifeExpectancy(ageLifeExpectancy, customer.getAge()));
			return customerAge;
		}).toList();

	}

}
