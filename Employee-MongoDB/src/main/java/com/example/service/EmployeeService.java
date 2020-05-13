package com.example.service;

import java.util.List;

import com.example.domain.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public Employee createEmployee(Employee employee);
	public List<Employee> getEmployeeByEmail(String email);
	public void deleteById(String id);
	public Employee findById(String id);
}
