package com.example.hr.dto.fault;

public class RestErrorMessage {

	private final String status;
	private final String reason;

	public RestErrorMessage(String status, String reason) {
		this.status = status;
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

}
