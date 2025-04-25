package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DateHelperTest {

	@Test
	void testCalculateBirthDays() {
		var dateBirth = DateHelper.calculateBirthDays(LocalDate.of(1980, 9, 4));
		assertTrue(dateBirth >= 44);
	}

	@Test
	void testCalculateLifeExpectancy() {
		var date = DateHelper.calculateLifeExpectancy(100, 0);
		assertTrue(date >= 100);
	}

}
