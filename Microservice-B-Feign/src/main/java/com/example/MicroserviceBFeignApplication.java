package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceBFeignApplication implements CommandLineRunner{

	EmployeeDAO employeeDAO;
	@Autowired
	public MicroserviceBFeignApplication(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBFeignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeDAO.save(new Employee("Ghulam","Mozammil","mozammil@protonmail.com","Electronics"));
		employeeDAO.save(new Employee("Ankit","Choudhary","ankit@protonmail.com","CSE"));
		employeeDAO.save(new Employee("Nilay","DAs","nilay@protonmail.com","JAVA"));
	}

}
