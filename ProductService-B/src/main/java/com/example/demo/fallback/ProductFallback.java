package com.example.demo.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.feign.FeignClient;

@Component
public class ProductFallback implements FeignClient{



	@Override
	public ResponseEntity<List<Object>> callfindAll() {
		// TODO Auto-generated method stub
		return new ResponseEntity("Service DOWN",HttpStatus.SERVICE_UNAVAILABLE);
	}




}
