package comm.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import comm.example.exception.CustomerNotFoundException;
import comm.example.exception.CustomerResponseEntity;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(CustomerNotFoundException c)
	{
		return new ResponseEntity<CustomerResponseEntity>(new CustomerResponseEntity(HttpStatus.NOT_FOUND.value(),c.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);

	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(Exception e)
	{
		return new ResponseEntity<CustomerResponseEntity>(new CustomerResponseEntity(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}
}
