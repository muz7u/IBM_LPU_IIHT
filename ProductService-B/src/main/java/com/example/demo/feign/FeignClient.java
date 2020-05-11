package com.example.demo.feign;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Product;
import com.example.demo.fallback.ProductFallback;

@org.springframework.cloud.openfeign.FeignClient(value ="product-service", fallback = ProductFallback.class)
public interface FeignClient {
	
	@RequestMapping("/api/products")
	public List<Object> callfindAll();
}
