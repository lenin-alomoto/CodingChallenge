package com.coding.challenge.micro_customer_management.customer.application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.coding.challenge.micro_customer_management.customer.domain.models.Customer;
import com.coding.challenge.micro_customer_management.customer.domain.repositories.CustomerRepositoryPort;

class CustomerUseCaseImplTest {
	
	@Mock
	CustomerRepositoryPort customerRepositoryPort;
	
	@InjectMocks
	CustomerUseCaseImpl customerUseCaseImpl;

	@BeforeEach
	void setUp() {
		customerRepositoryPort = mock(CustomerRepositoryPort.class);
	}
	
	@Test
	void testFindAllCustomer() {
		when(customerRepositoryPort.findAllCustomer()).thenReturn(getDataResponse());
		Assertions.assertNotNull(getDataResponse());
	}

	@Test
	void testFindCustomerById() {
		Customer expectedCustomer = getDataResponse().get(1);
		when(customerRepositoryPort.findCustomerById(2L)).thenReturn(expectedCustomer);
		final Customer customerResult = customerRepositoryPort.findCustomerById(2L);
		Assertions.assertEquals(expectedCustomer, customerResult);
		Mockito.verify(customerRepositoryPort).findCustomerById(2L);
	}
	
	@Test
	void testSaveCustomer() {
		Customer newCustomer = getCustomer();
		when(customerRepositoryPort.saveCustomer(newCustomer)).thenReturn(getDataResponse().get(5));
		final Customer customerResult = customerRepositoryPort.saveCustomer(newCustomer);
		Assertions.assertEquals(newCustomer, customerResult);
		Mockito.verify(customerRepositoryPort).saveCustomer(newCustomer);
	}
	
	@Test
	void testUpdateCustomer() {
		Customer updateCustomer = getDataResponse().get(4);
		updateCustomer.setAge(10);
		when(customerRepositoryPort.updateCustomer(5L, updateCustomer)).thenReturn(getUpdateCustomer());
		final Customer customerResult = customerRepositoryPort.updateCustomer(5L, updateCustomer);
		Assertions.assertEquals(updateCustomer, customerResult);
		Mockito.verify(customerRepositoryPort).updateCustomer(5L, updateCustomer);
	}
	
	List<Customer> getDataResponse() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "Pepe", "Perez", LocalDate.of(1980, 9, 4), 44));
		customers.add(new Customer(2L, "Juan", "Borja", LocalDate.of(2024, 4, 26), 0));
		customers.add(new Customer(3L, "Maria", "Nieves", LocalDate.of(2024, 4, 23), 1));
		customers.add(new Customer(4L, "Segundo", "Bedoya", LocalDate.of(1990, 4, 24), 35));
		customers.add(new Customer(5L, "Jose", "Loachamin", LocalDate.of(2000, 4, 26), 24));
		customers.add(new Customer(6L, "Fernanda", "Trujillo", LocalDate.of(2010, 9, 4), 14));
		return customers;
	}
	
	Customer getCustomer() {
		return new Customer(6L, "Fernanda", "Trujillo", LocalDate.of(2010, 9, 4), 14);
	}
	
	Customer getUpdateCustomer() {
		return new Customer(5L, "Jose", "Loachamin", LocalDate.of(2000, 4, 26), 10);
	}

}
