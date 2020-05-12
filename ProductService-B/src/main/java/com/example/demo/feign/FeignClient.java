package com.example.demo.feign;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.fallback.ProductFallback;

@org.springframework.cloud.openfeign.FeignClient(value ="product-service") //, fallback = ProductFallback.class
public interface FeignClient {

		@GetMapping("/api/products")
		public ResponseEntity<List<Product>> getAllProducts();
		@GetMapping("/api/productsBycategory")
		public ResponseEntity<List<Product>> findByCategoryId(@RequestParam long id);
		
		@GetMapping("/api/product-category")
		public ResponseEntity<List<ProductCategory>> getAllCategory();
		
		@GetMapping("/api/products/findByName")
		public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name);
		
		@GetMapping("/api/products/{id}")
		public Product getProduct(@PathVariable("id") long id);
	}
