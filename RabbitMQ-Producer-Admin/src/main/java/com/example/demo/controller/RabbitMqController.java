package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.RabbitMqService;

@RestController
public class RabbitMqController {

	private RabbitMqService rabbitMqService;

	@Autowired
	public RabbitMqController(RabbitMqService rabbitMqService) {
		super();
		this.rabbitMqService = rabbitMqService;
	}
	
	
	@PostMapping("/items")
	public ResponseEntity<String> postMessage(@RequestBody Item item)
	{
		rabbitMqService.sendMessage(item);
		return new ResponseEntity<String>("Item is pushed",HttpStatus.OK);
	}
	
	
}
