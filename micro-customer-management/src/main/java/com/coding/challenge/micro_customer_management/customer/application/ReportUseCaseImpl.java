package com.coding.challenge.micro_customer_management.customer.application;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.coding.challenge.micro_customer_management.customer.domain.models.CustomerReport;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.ReportCustomerRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportUseCaseImpl implements ReportUseCase {

	private final ReportCustomerRepositoryPort reportCustomerRepositoryPort;

	@Override
	public Double calculateTheAverageAge() {
		var averageAge = reportCustomerRepositoryPort.calculateTheAverageAge();
		
		return Objects.nonNull(averageAge) ? averageAge : 0.0;
	}

	@Override
	public Double calculateTheStandardDeviationOfAges() {
		return reportCustomerRepositoryPort.calculateTheStandardDeviationOfAges();
	}

	@Override
	public List<CustomerReport> findAllCustomerWithLifeExpectancy(int ageLifeExpectancy) {
		return reportCustomerRepositoryPort.findAllCustomerWithLifeExpectancy(ageLifeExpectancy);
	}

}
