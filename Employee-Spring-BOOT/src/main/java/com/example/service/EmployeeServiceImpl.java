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

}
