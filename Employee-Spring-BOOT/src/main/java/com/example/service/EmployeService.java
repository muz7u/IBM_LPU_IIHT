package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeService 
{
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	public Employee findEmployeeById(int id);
	public void deleteEmployeeById(int id);
	public Employee updateEmployee(Employee employee, int id);
}
