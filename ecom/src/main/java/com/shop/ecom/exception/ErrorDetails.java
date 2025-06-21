package com.shop.ecom.exception;

import java.sql.Timestamp;

public class ErrorDetails {
	private Timestamp timestamp;
	private String message;
	private String statusCode;
	private String details;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(Timestamp timestamp, String message, String statusCode, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.statusCode = statusCode;
		this.details = details;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", statusCode=" + statusCode
				+ ", details=" + details + "]";
	}
	
}
