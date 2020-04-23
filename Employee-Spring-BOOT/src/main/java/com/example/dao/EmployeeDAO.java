package com.example.dao;

import java.util.List;

import com.example.entity.Employee;
public interface EmployeeDAO 
{
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	public Employee findEmployeeById(int id);
	public void deleteEmployeeById(int id);
	public Employee updateEmployee(Employee employee, int id);
}
