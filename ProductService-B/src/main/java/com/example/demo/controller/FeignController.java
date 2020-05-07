package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.FeignClient;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
@CrossOrigin("*")
public class FeignController {

	FeignClient refClient;

	@Autowired
	public FeignController(FeignClient refClient) {
		super();
		this.refClient = refClient;
	}
	
	@RequestMapping("/products")
	public ResponseEntity<ResponseEntity<List<Object>>> callGetAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(refClient.callfindAll());
	}
}
