package com.coding.challenge.micro_customer_management.customer.infrastructure.rest.controllers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

	@Autowired
	private MockMvc mockController;
	
	@Test
	void testFindAllCustomer() throws Exception {
		mockController.perform(get("/api/customers")
                .with(httpBasic("springadmin", "security123")))
                .andExpect(status().is(HttpStatus.OK.value()));
	}

	@Test
	void testFindCustomerById() throws Exception {
		mockController.perform(get("/api/customers/11111111111111"))
				.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));
	}
	
}
