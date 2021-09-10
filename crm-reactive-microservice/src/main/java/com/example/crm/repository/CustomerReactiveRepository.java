package com.example.crm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerReactiveRepository extends ReactiveMongoRepository<Customer, String>{
	@Query("{}")
	Flux<Customer> findAllByPage(Pageable page); // asynchronous
	Mono<Customer> findByEmail(String email); // asynchronous
	Flux<Customer> findAllByBirthYearBetween(int fromYear,int toYear); // asynchronous
}
