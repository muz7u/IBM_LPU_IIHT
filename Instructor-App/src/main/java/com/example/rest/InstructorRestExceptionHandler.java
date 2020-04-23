package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InstructorRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorEntity> handleException(InstuctorNotFoundException exc)
	{
		ErrorEntity error = new ErrorEntity(HttpStatus.NOT_FOUND.value(),exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
