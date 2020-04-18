package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao
{
	


	private JdbcTemplate refJdbcTemplate;
	//private Logger logger=Logger.getLogger("AccountDAOImpl");
	@Autowired
	public AccountDaoImpl(JdbcTemplate refJdbcTemplate) {
		super();
		this.refJdbcTemplate = refJdbcTemplate;
	}


	public Account insertAccount(Account refAccount) 
	{
		
		String sql="insert into account values('"+refAccount.getAccountNumber()+"','"+refAccount.getAccountType()+"',"+refAccount.getInitialBalance()+")";
		refJdbcTemplate.update(sql);
		return refAccount;
	}
	
	public void deleteAccountById(Account refAccount) 
	{
		String sql="delete from account where accountNumber='"+refAccount.getAccountNumber()+"'";
		refJdbcTemplate.update(sql);
	}
	
	
	
	public Account updateAccountById(Account refAccount)
	{
		
		String sql="update account set accountType='CURRENT' where accountNumber='"+refAccount.getAccountNumber()+"'";
		return refAccount;
	}
	
	public List<Account> getAllAccount()
	{
		String sql="select * from account";
//		List<Account> list=refJdbcTemplate.query(sql, new AccountMapper());
		List<Account> list=refJdbcTemplate.query(sql, new BeanPropertyRowMapper(Account.class));
		return list;
	}
	

	
	
	/*
	 * private DataSource dataSource;
	 * 
	 * @Autowired public AccountDaoImpl(DataSource dataSource) throws SQLException {
	 * super(); // logger.log(Level.INFO, "connecting to database");
	 * dataSource.getConnection(); // logger.log(Level.INFO, "connected");
	 * this.dataSource = dataSource; }
	 */
	
	
}