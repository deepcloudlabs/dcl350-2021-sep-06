package com.example.crm.event;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerevents")
public class CustomerEvent<T> {
	@Id
	private String eventId;
	private String transactionId;
	private long timestamp;
	private T eventData;
	
	public CustomerEvent() {
		this.transactionId = UUID.randomUUID().toString();
		this.eventId = UUID.randomUUID().toString();
		this.timestamp = ZonedDateTime.now().toEpochSecond();
	}

	public CustomerEvent(String transactionId) {
		this.transactionId = transactionId;
		this.eventId = UUID.randomUUID().toString();
		this.timestamp = ZonedDateTime.now().toEpochSecond();
	}

	public CustomerEvent(String transactionId, T eventData) {
		this.transactionId = transactionId;
		this.eventData = eventData;
		this.eventId = UUID.randomUUID().toString();
		this.timestamp = ZonedDateTime.now().toEpochSecond();
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public T getEventData() {
		return eventData;
	}

	public void setEventData(T eventData) {
		this.eventData = eventData;
	}

	@Override
	public String toString() {
		return "CustomerEvent [eventId=" + eventId + ", transactionId=" + transactionId + ", timestamp=" + timestamp
				+ "]";
	}

}
