package com.coding.challenge.micro_customer_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MicroCustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCustomerManagementApplication.class, args);
	}

}
