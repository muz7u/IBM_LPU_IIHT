package com.example.dao;

import java.util.Collection;

import comm.example.model.Employee;


public interface EmployeeDAO 
{
	public Employee createEmployee(Employee employee);
	public void removeEmployee(int id);
	public Employee raiseEmployeeSalary(int id, long raise);
	public Employee findEmployee(int id);
	public Collection<Employee> findAllEmployees();
}
