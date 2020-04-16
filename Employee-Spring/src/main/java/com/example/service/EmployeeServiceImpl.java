package com.example.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;

import comm.example.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO refEmployeeDAO;
	
	public Employee createEmployee(Employee employee) {
		return refEmployeeDAO.createEmployee(employee);
	}

	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		refEmployeeDAO.removeEmployee(id);

	}

	public Employee raiseEmployeeSalary(int id, long raise) {
		// TODO Auto-generated method stub
		return refEmployeeDAO.raiseEmployeeSalary(id, raise);
	}

	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return refEmployeeDAO.findEmployee(id);
	}

	public Collection<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return refEmployeeDAO.findAllEmployees();
	}

}
