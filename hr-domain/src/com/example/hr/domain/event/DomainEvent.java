package com.example.hr.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public abstract class DomainEvent {
	private static AtomicLong sequenceGenerator = new AtomicLong();
	private final String eventId;
	private final long sequence;
	private final long timestamp;

	public DomainEvent() {
		this.eventId = UUID.randomUUID().toString();
		this.sequence = sequenceGenerator.incrementAndGet();
		this.timestamp = ZonedDateTime.now().toEpochSecond();
	}

	public static AtomicLong getSequenceGenerator() {
		return sequenceGenerator;
	}

	public String getEventId() {
		return eventId;
	}

	public long getSequence() {
		return sequence;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
