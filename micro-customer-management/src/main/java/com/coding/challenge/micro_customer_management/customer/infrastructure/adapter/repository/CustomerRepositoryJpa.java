package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.entity.CustomerEntity;

public interface CustomerRepositoryJpa extends JpaRepository<CustomerEntity, Long>{

	@Query(value = "SELECT AVG(c.age) FROM CustomerEntity c")
	public Double findTheAverageAge();
}
