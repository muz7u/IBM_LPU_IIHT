package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerClientApplication implements CommandLineRunner{

	private CustomerDAO customerDAO;
	private CustomerType customerType;
	@Autowired
	public CustomerClientApplication(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDAO.createAccount(new Customer("Mozammil",customerType.COMPANY));
		customerDAO.createAccount(new Customer("Shubham",customerType.INDIVIDUAL));
		customerDAO.createAccount(new Customer("Yasir",customerType.COMPANY));
	}

}
