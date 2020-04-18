package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.bean.Account;

public class AccountMapper implements RowMapper<Account>
{
	public Account mapRow(ResultSet rs, int rowNum)throws SQLException
	{
		Account account=new Account();
		account.setAccountNumber(rs.getString("accountNumber"));
//		account.setAccountType(rs.getString("accountType"));
		account.setInitialBalance(rs.getInt("balance"));
		return account;
	}
}
