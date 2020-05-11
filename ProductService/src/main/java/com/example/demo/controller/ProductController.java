package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class ProductController {

	private ProductRepository productRepository;
	@Autowired
	public ProductController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@GetMapping("/products")
	public List<Product> finAll()
	{
		List<Product> list= (List<Product>)productRepository.findAll();
		
		return list;
		
	} 
	
	@GetMapping("/products/{id}")
	public Product findById(@RequestParam Long id)
	{
		return productRepository.findById(id).get();
	}
	
	@GetMapping("/products/search/findByCategoryId")
	public Page<Product> findByCategoryId(@RequestParam("id")long id, Pageable pageable)
	{
		return productRepository.findByCategoryId(id, pageable);
	}
	
}
