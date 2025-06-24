package com.telcom.ticket.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(InvaldArgs.class)
	public ResponseEntity<ErrorDetail> invalidArguments(InvaldArgs ex,WebRequest request){
		
		ErrorDetail errorMsg = new ErrorDetail(new Timestamp(System.currentTimeMillis()),ex.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetail> invalidArguments(ResourceNotFound ex,WebRequest request){
		
		ErrorDetail errorMsg = new ErrorDetail(new Timestamp(System.currentTimeMillis()),ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorMsg,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDetail> invalidArguments(RuntimeException ex,WebRequest request){
		
		ErrorDetail errorMsg = new ErrorDetail(new Timestamp(System.currentTimeMillis()),ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorMsg,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> invalidArguments(Exception ex,WebRequest request){
		
		ErrorDetail errorMsg = new ErrorDetail(new Timestamp(System.currentTimeMillis()),ex.getMessage(),request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
