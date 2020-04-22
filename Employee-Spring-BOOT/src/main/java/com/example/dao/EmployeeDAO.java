package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDAO 
{
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
}
