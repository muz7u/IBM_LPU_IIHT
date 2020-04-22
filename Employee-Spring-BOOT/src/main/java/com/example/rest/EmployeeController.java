package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	private EmployeeServiceImpl employeeService;

	@Autowired
	public EmployeeController(EmployeeServiceImpl refEmployeeService) 
	{
		super();
		this.employeeService = refEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
}
