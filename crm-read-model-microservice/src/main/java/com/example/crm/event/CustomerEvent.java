package com.example.crm.event;

public class CustomerEvent<T> {
	private String eventId;
	private String transactionId;
	private long timestamp;
	private T eventData;
	
	public CustomerEvent() {
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
