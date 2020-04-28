package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDAO 
{
	public Customer findById(Integer id);
	public Customer findByName(String name);
	public Customer createAccount(Customer customer);
	public List<Customer> fetchAll();
	
}
