package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper;

import java.time.LocalDate;
import java.time.Period;

public class DateHelper {
	
	private DateHelper() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int calculateBirthDays(LocalDate birthDate) {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
	
	public static double calculateLifeExpectancy(int ageLifeExpectancy, int age) {
        if (ageLifeExpectancy <= age) {
            return 0; 
        }
        return  Math.floor((ageLifeExpectancy - age) * (1.0 - ((double) age / ageLifeExpectancy)));
    }
}
