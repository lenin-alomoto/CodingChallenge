package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.entity.CustomerEntity;

public interface ScheduleRepositoryJpa extends JpaRepository<CustomerEntity, Long> {
	
	@Query("SELECT c FROM CustomerEntity c WHERE MONTH(c.birthDate) = :month AND DAYOFMONTH(c.birthDate) = :day")
    List<CustomerEntity> findAllByMonthAndDay(@Param("month") int month, @Param("day") int day);
}
