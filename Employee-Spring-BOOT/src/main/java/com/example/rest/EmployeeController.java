package com.example.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api/version1")
@Api(value="Employee Management System", description = "Perform CURD operations on employee")
public class EmployeeController 
{
	private EmployeeServiceImpl employeeService;

	@Autowired
	public EmployeeController(EmployeeServiceImpl refEmployeeService) 
	{
		super();
		this.employeeService = refEmployeeService;
	}
	
	
	@ApiOperation(value = "List all Employees",response = List.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/employees/{id}")
	public Employee findEmployeeById(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true)
			@PathVariable(value = "id") int id)
			 {
		
				
		return employeeService.findEmployeeById(id);
		}
	
	
	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(
			@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)
			@PathVariable(value = "id") int id)
			 {			

		employeeService.deleteEmployeeById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	@ApiOperation(value = "Add an employee")
	@PostMapping("/employees")
	public Employee createEmployee(@ApiParam(value = "Employee object store in database table", required = true)
	@Valid @RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	
	
	@ApiOperation(value = "Update an employee")
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(
			@ApiParam(value = "Employee Id to update employee object", required = true)
			@PathVariable(value = "id") int id,
			@ApiParam(value = "Update employee object", required = true)
			@Valid @RequestBody Employee employee) {
		
		employeeService.updateEmployee(employee, id);
		return employee;
	}
	
	
	
}
