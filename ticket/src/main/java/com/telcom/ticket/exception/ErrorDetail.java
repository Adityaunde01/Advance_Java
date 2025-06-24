package com.telcom.ticket.exception;

import java.sql.Timestamp;

public class ErrorDetail {
	private Timestamp timeStamp;
	private String message;
	private String details;
	private Integer status;
	
	public ErrorDetail() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetail(Timestamp timeStamp, String message, String details, Integer status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
		this.status = status;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErrorDetail [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + ", status="
				+ status + "]";
	}
	

}
