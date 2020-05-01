package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Account Management System", description="Operations pertaining to accounts in Accounts Management System")

@RestController
public class AccoutController 
{
	AccountDAO accountDAO;;

	@Autowired	
	public AccoutController(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}


	@ApiOperation(value = "View a list of available accounts", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts()
	{
		List<Account> list=new ArrayList<>();
		Iterable<Account> itr=accountDAO.findAll();
		for(Account a:itr)
		{
			list.add(a);
		}
		return new ResponseEntity<List<Account>>(list,HttpStatus.OK);
	}
	@ApiOperation(value = "Get an account by Id")
	@GetMapping("/accounts/{accountdId}")
	public ResponseEntity<Account> getAccountById(@ApiParam(value = "Account id from which account object will retrieve", required = true)@PathVariable("accountId") Integer accountId)
	{

		return new ResponseEntity<Account>(accountDAO.findById(accountId).get(),HttpStatus.FOUND);
	}
	
}
