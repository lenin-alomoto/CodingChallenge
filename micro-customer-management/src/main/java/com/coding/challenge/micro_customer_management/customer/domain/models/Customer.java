package com.coding.challenge.micro_customer_management.customer.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	private int age;
	
}
