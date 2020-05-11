package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductCategoryRepository;
import com.example.demo.entity.ProductCategory;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductCategoryController {

	
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	public ProductCategoryController(ProductCategoryRepository productCategoryRepository) {
		super();
		this.productCategoryRepository = productCategoryRepository;
	}

	@GetMapping("/product-category")
	public Object[] finAll()
	{
		Iterable<ProductCategory> itr= productCategoryRepository.findAll();
		List<ProductCategory> list=new ArrayList<>();
		for(ProductCategory p:itr)
		{
			list.add(p);
		}
		return list.toArray();
		
	}
	
	@GetMapping("/products-category/{id}")
	public ProductCategory findById(@RequestParam Long id)
	{
		return productCategoryRepository.findById(id).get();
	}
	
}
