package com.example.securitycard.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SecurityCardListenerService {

	@KafkaListener(topics = { "hr-events" })
	public void listenEmployeeEvents(String json) {
		System.err.println("New event has arrived through kafka: " + json);
	}
}
