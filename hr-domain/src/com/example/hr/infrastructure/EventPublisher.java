package com.example.hr.infrastructure;

import com.example.hr.domain.event.DomainEvent;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Infrastructure
public interface EventPublisher {

	void publish(DomainEvent domainEvent);

}
