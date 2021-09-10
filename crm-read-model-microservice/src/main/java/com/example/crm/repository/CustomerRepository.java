package com.example.crm.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.crm.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	@Query("{}")
	List<Customer> findAllByPage(Pageable page); // asynchronous
	Customer findByEmail(String email); // asynchronous
	List<Customer> findAllByBirthYearBetween(int fromYear,int toYear); // asynchronous
}
