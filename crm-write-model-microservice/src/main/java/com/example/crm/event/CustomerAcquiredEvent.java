package com.example.crm.event;

import com.example.crm.entity.Customer;

public class CustomerAcquiredEvent extends CustomerEvent<Customer> {

	public CustomerAcquiredEvent(String transactionId, Customer eventData) {
		super(transactionId, eventData);
	}
	
}
