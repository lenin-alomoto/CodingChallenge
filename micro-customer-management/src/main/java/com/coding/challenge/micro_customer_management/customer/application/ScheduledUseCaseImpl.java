package com.coding.challenge.micro_customer_management.customer.application;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.coding.challenge.micro_customer_management.customer.domain.repositories.ScheduleRepositoryPort;
import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper.DateHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledUseCaseImpl implements ScheduledUseCase {

	private final ScheduleRepositoryPort scheduleRepositoryPort;
	
	@Scheduled(cron = "0 1 0 * * ?")
	@Override
	public void updateBirthDate() {
		var customers = scheduleRepositoryPort.findAllCustomerByMonthAndDay(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		log.info("Start update birth day");
		if(Objects.nonNull(customers) && !customers.isEmpty()) {
			log.info("Customers: " + customers.size());
			customers.stream().forEach( customer -> {
				customer.setAge(DateHelper.calculateBirthDays(customer.getBirthDate()));
				scheduleRepositoryPort.updateCustomer(customer);
			});
		}
	}
}
