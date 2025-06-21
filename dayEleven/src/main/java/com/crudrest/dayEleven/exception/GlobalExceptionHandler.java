package com.crudrest.dayEleven.exception;


import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.crudrest.dayEleven.entity.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Resource404Exception.class)
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorMessage> handle404Exception(Resource404Exception ex, WebRequest request){
		ErrorMessage message = new ErrorMessage(new Timestamp(System.currentTimeMillis()), ex.getMessage(),request.getDescription(false));
		
		  return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorMessage> handleOtherException (Exception ex, WebRequest request){
		ErrorMessage message = new ErrorMessage(new Timestamp(System.currentTimeMillis()), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
