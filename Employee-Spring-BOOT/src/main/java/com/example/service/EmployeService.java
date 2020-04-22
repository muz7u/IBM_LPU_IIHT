package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeService 
{
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
}
