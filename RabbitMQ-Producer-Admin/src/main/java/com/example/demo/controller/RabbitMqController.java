package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.RabbitMqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Account Management System", description="Operations pertaining to accounts in Accounts Management System")
@RestController
public class RabbitMqController {

	private RabbitMqService rabbitMqService;

	@Autowired
	public RabbitMqController(RabbitMqService rabbitMqService) {
		super();
		this.rabbitMqService = rabbitMqService;
	}
	
	@ApiOperation(value = "Add an account.")
	@PostMapping("/accounts")
	public ResponseEntity<String> postMessage(@ApiParam(value = "Account object store in database table", required = true)
	@Valid@RequestBody Account account)
	{
		rabbitMqService.sendMessage(account);
		return new ResponseEntity<String>("Account is pushed",HttpStatus.OK);
	}
	
	
}
