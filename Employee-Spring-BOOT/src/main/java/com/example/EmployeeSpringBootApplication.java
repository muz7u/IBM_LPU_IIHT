package com.example;


import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;


@SpringBootApplication
public class EmployeeSpringBootApplication implements CommandLineRunner {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeSpringBootApplication(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		employeeDAO.createEmployee(new Employee("Ghulam","Mozammil","mozammil010@gmail.com"));
		employeeDAO.createEmployee(new Employee("Nilay","Das","nilay_das@gmail.com"));
	}
}
