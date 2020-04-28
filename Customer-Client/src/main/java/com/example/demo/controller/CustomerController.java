package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;

	

@RestController
public class CustomerController 
{
	protected Logger logger=Logger.getLogger("customerController");
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/customers")
	public List<Customer> fetchAll()
	{
		logger.info("port"+port);
		System.out.println("***"+port);
		return customerDAO.fetchAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") Integer id)
	{
		return customerDAO.findById(id);
	}
	
	@GetMapping("/customers/name/{name}")
	public Customer getCustomerByName(@PathVariable("name") String name)
	{
		return customerDAO.findByName(name);
	}
	
	
	
}
