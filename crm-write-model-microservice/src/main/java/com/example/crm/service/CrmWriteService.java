package com.example.crm.service;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crm.entity.Customer;
import com.example.crm.event.CustomerAcquiredEvent;
import com.example.crm.repository.CustomerEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CrmWriteService {
	private CustomerEventRepository<Customer> customerEventRepository;
	private RabbitTemplate rabbitTemplate;
	private ObjectMapper objectMapper;

	public CrmWriteService(CustomerEventRepository<Customer> customerEventRepository, RabbitTemplate rabbitTemplate,
			ObjectMapper objectMapper) {
		this.customerEventRepository = customerEventRepository;
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
	}

	@Transactional
	public void acquireCustomer(Customer customer) {
		var event = new CustomerAcquiredEvent(UUID.randomUUID().toString(), customer);
		customerEventRepository.save(event);
		// business
		try {
			var json = objectMapper.writeValueAsString(event);
			rabbitTemplate.convertAndSend("custex", null, json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
