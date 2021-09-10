package com.example.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerRepository;

@Service
public class CrmReadService {
	private CustomerRepository customerRepository;

	public CrmReadService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Optional<Customer> findCustomerById(String identity) {
		return customerRepository.findById(identity);
	}

	public List<Customer> findAllCustomersByPage(int no, int size) {
		return customerRepository.findAllByPage(PageRequest.of(no, size));
	}

}
