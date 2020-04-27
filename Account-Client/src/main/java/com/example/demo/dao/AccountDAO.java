package com.example.demo.dao;



import com.example.demo.model.Account;


public interface AccountDAO {

	public Account findByNumber(String number);
	public Account findById(Integer id);
	public Account findByCustomerId(Integer customerId);
	public Account createAccount(Account account);
	
	
}
