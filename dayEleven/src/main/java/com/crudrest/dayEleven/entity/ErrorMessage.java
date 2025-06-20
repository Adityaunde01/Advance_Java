package com.crudrest.dayEleven.entity;


import java.sql.Timestamp;

public class ErrorMessage {
	private Timestamp timestamp;
	private String message;
	private String Details;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(Timestamp timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		Details = details;
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

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	@Override
	public String toString() {
		return "ErrorMessage [timestamp=" + timestamp + ", message=" + message + ", Details=" + Details + "]";
	}
	
	

}
