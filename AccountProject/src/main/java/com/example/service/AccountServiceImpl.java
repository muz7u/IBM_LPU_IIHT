package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Account;
import com.example.dao.AccountDao;

@Service
public class AccountServiceImpl implements AccountService 
{
	
	private AccountDao refAccountDao;
	
	@Autowired
	public AccountServiceImpl(AccountDao refAccountDao) {
		super();
		this.refAccountDao = refAccountDao;
	}

	public Account insertAccount(Account refAccount) {
		// TODO Auto-generated method stub
		
		
		return refAccountDao.insertAccount(refAccount);
	}

	public void deleteAccountById(Account refAccount) {
		// TODO Auto-generated method stub
		refAccountDao.deleteAccountById(refAccount);

	}

	public Account updateAccountById(Account refAccount) {
		// TODO Auto-generated method stub
		return refAccountDao.updateAccountById(refAccount);
	}

}
