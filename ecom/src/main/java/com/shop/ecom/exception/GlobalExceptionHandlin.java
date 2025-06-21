package com.shop.ecom.exception;


import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandlin {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> getErrorMessage(Exception ex,WebRequest request){
		
		ErrorDetails errorMsg = new ErrorDetails(new Timestamp(System.currentTimeMillis()),ex.getMessage(), "404", request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorMsg, HttpStatus.NOT_FOUND);
	}

}
