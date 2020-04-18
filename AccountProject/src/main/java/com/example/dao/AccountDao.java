package com.example.dao;

import java.util.List;

import com.example.bean.Account;

public interface AccountDao 
{

	public Account insertAccount(Account refAccount);
	public void deleteAccountById(Account refAccount);
	public Account updateAccountById(Account refAccount);
	public List<Account> getAllAccount();
}
