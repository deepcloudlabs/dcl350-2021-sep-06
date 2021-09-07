package com.example.hr.adapter;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.domain.event.DomainEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
@Adapter
public class EventPublisherKafkaAdapter implements EventPublisher {
	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper objectMapper;

	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void publish(DomainEvent domainEvent) {
		try {
			var json = objectMapper.writeValueAsString(domainEvent);
			kafkaTemplate.send("hr-events", json);
		} catch (JsonProcessingException e) {
			System.err.println("Error while converting to json: " + e.getMessage());
		}
	}

}
