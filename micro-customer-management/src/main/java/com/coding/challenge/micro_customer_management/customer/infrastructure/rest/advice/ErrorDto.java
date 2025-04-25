package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.advice;

import java.time.LocalDate;

public  record ErrorDto(
		LocalDate date,
		int status,
		String error,
		String messagge
	) {

}
