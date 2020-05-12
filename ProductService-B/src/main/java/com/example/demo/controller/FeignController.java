package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.feign.FeignClient;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FeignController {

	FeignClient refClient;

	@Autowired
	public FeignController(FeignClient refClient) {
		super();
		this.refClient = refClient;
	}
	
		@GetMapping("/products")
		public ResponseEntity<List<Product>> getProducts()
		{
			return refClient.getAllProducts();
		}
		@GetMapping("/products/findByCategoryId")
		public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam long id)
		{
			return refClient.findByCategoryId(id);
		}
		@GetMapping("/product-category")
		public ResponseEntity<List<ProductCategory>> getAllCategory()
		{
			return refClient.getAllCategory();
		}
		@GetMapping("/products/findByName")
		public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name)
		{
			return refClient.getProductsByName(name);
		}
		@GetMapping("/products/{id}")
		public Product getProduct(@PathVariable("id") long id)
		{
			return refClient.getProduct(id);
		}
	}

