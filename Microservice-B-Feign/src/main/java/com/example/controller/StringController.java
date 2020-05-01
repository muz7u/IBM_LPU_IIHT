package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class StringController {

	private EmployeeDAO employeeDAO;
	@Autowired
	public StringController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	@RequestMapping("/string/hi")
	public String hi(@RequestParam String name)
	{
		return "Hello"+name+", Training is going good";
	}
	
	@RequestMapping("/find")
	public ResponseEntity<Iterable<Employee>> findEmployeeByDepatrmentName(@RequestParam String name)
	{
		
		return ResponseEntity.ok().body(employeeDAO.findByDepartmentname(name));
	}
	
	@PostMapping("/employees")
	@Transactional
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.ok().body(employeeDAO.save(employee));
	}
	
}
