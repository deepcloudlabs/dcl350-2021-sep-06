package com.example.hr.infrastructure;

import com.example.hr.domain.event.DomainEvent;

@Infrastructure
public interface EventPublisher {

	void publish(DomainEvent domainEvent);

}
