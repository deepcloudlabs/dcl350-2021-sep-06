package com.example.hr.adapter;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.hr.domain.event.DomainEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
@Adapter
public class EventPublisherMediatorAdapter implements EventPublisher {
	private ApplicationEventPublisher appEventPublisher;

	public EventPublisherMediatorAdapter(ApplicationEventPublisher appEventPublisher) {
		this.appEventPublisher = appEventPublisher;
	}

	@Override
	public void publish(DomainEvent domainEvent) {
		appEventPublisher.publishEvent(domainEvent);
	}

}
