package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
	@GetMapping("/employees/{email}")
	public ResponseEntity<List<Employee>> getEmployeeByEmail(@PathVariable("email") String email)
	{
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByEmail(email));
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable("id") String id)
	{
		employeeService.deleteById(id);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		return  ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
}
