package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee()
	{
		return employeeDAO.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findEmployeeById(@PathVariable("id") Integer id)
	{
		return employeeDAO.findById(id).get();
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee objEmployee)
	{
		employeeDAO.save(objEmployee);
		return objEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee objEmployee)
	{
		employeeDAO.save(objEmployee);
		return objEmployee;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable("id") Integer id)
	{
		Employee objEmployee=findEmployeeById(id);
		employeeDAO.delete(objEmployee);
	}
	
	
}
