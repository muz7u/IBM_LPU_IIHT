package com.example.service;

import com.example.bean.Account;

public interface AccountService 
{
	public Account insertAccount(Account refAccount);
	public void deleteAccountById(Account refAccount);
	public Account updateAccountById(Account refAccount);
}
