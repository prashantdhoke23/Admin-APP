package com.zensar.exception;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = InvalidSearchingDataException.class)
	public ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\":" + exception.toString() + " \"}";
		ResponseEntity<Object> response = handleExceptionInternal(exception, errorMessage, new org.springframework.http.HttpHeaders(),
				HttpStatus.CONFLICT, request);
		return response;
	}
	
	@ExceptionHandler(value = InvalidIDException.class)
	public ResponseEntity<Object> handleConflictInavlidID(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\":" + exception.toString() + " \"}";
		ResponseEntity<Object> response = handleExceptionInternal(exception, errorMessage, new org.springframework.http.HttpHeaders(),
				HttpStatus.CONFLICT, request);
		return response;
	}
}
