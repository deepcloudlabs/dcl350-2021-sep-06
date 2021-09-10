package com.example.crm.service;

import java.util.function.Consumer;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CrmReactiveService {
	private CustomerReactiveRepository customerReactiveRepository;
	
	public CrmReactiveService(CustomerReactiveRepository customerReactiveRepository) {
		this.customerReactiveRepository = customerReactiveRepository;
	}

	public Mono<Customer> findCustomerById(String identity) {
		return customerReactiveRepository.findById(identity);
	}

	public Flux<Customer> findAllCustomersByPage(int no, int size) {
		return customerReactiveRepository.findAllByPage(PageRequest.of(no, size));
	}

	public Mono<Customer> addCustomer(Customer customer) {
		return customerReactiveRepository.insert(customer);
	}

	public Mono<Customer> updateCustomer(String identity, Customer customer) {
		return customerReactiveRepository.save(customer);
	}

	public Mono<Customer> removeCustomerById(String identity) {
		var customer = customerReactiveRepository.findById(identity);
		System.err.println("removeCustomerById::Line40");
		Consumer<Customer> removeCustomer = cust -> {			
			System.err.println("removeCustomerById::Line42::"+Thread.currentThread().getName());
			customerReactiveRepository.delete(cust).subscribe( removeCust -> System.err.println("Customer finally removed!"));
		};
		System.err.println("removeCustomerById::Line45");
		customer.subscribe( removeCustomer );
		System.err.println("removeCustomerById::Line47");
		return customer;
	}

}
