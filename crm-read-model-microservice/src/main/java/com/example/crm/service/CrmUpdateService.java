package com.example.crm.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CrmUpdateService {

	@RabbitListener
	public void handleEvent(String json) {
		System.err.println(json);
		//TODO : event -> update read model
	}
}
