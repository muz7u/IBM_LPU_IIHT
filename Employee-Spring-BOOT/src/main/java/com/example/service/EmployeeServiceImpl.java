package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeService {

	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO refEmployeeDAO) {
		super();
		this.employeeDAO = refEmployeeDAO;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
	}



	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployeeById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee, id);
	}

}
