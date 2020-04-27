package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;

@RestController
public class AccountController 
{
	private AccountDAO accountDAO;
	
	@Autowired
	public AccountController(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}



	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable("id")Integer id)
	{
		return accountDAO.findById(id);
	}
	
	
	@GetMapping("/accounts/number/{number}")
	public Account findByNumber(@PathVariable("number")String number)
	{
		return accountDAO.findByNumber(number);
	}
	
	
	
	@GetMapping("/accounts/cust/{customerId}")
	public Account findByCustomerId(@PathVariable("customerId")Integer customerId)
	{
		return accountDAO.findByCustomerId(customerId);
	}
	
	@GetMapping("/accounts")
	public List<Account> fetchAll()
	{
		return accountDAO.fetchAll();
	}
	
}
