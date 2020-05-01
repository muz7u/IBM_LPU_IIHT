package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.StringFeignClient;
import com.example.demo.model.Employee;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class StringController {

	StringFeignClient refClient;

	@Autowired
	public StringController(StringFeignClient refClient) {
		super();
		this.refClient = refClient;
	}
	
	@RequestMapping("/string/hello")
	public ResponseEntity<String> callHello(@RequestParam String name)
	{
		//return new ResponseEntity<String>(refClient.callHi(name),HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(refClient.callHi(name));
	}
	
	@RequestMapping("/findemployees")
	public ResponseEntity<Iterable<Employee>> callgetEmployeeByDepartmentName(@RequestParam String name)
	{
		//return new ResponseEntity<String>(refClient.callHi(name),HttpStatus.OK);
		
		
			return refClient.callFindEmployeeByDepartmentName(name);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<ResponseEntity<Employee>> callAddEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.ok().body(refClient.callEmployees(employee));
	}
}
