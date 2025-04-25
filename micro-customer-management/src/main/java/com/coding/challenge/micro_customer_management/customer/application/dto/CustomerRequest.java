package com.coding.challenge.micro_customer_management.customer.application.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record CustomerRequest (
		
		@NotEmpty(message = "Name is required.")
		@Size(min = 4, max = 50, message = "The size for the name must be between 5 and 50.")
		String name,
		
		@NotEmpty(message = "Last name is required.")
		@Size(min = 4, max = 50, message = "The size for the last name must be between 5 and 50.")
		String lastName,
		
		@NotNull(message = "Date of birth is required.")
		@PastOrPresent(message = "The date must be equal to or less than the current date.")
		LocalDate birthDate
	) {

}
