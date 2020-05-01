package com.example.demo.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.feign.StringFeignClient;
import com.example.demo.model.Employee;

@Component
public class StringFallback implements StringFeignClient{

	@Override
	public String callHi(String name) {
		
		return "<p>Service is unavailable, Please try again after some time</p>"; 
	}

	@Override
	public ResponseEntity<Iterable<Employee>> callFindEmployeeByDepartmentName(String name) {
		// TODO Auto-generated method stub
		return new ResponseEntity("Service DOWN",HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<Employee> callEmployees(Employee employee) {
		// TODO Auto-generated method stub
		return new ResponseEntity("Service DOWN",HttpStatus.SERVICE_UNAVAILABLE);
	}




}
