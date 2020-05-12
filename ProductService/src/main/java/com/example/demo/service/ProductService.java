package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public List<Product> getAllProductsByCategoryId(long id);
	public List<Product> getProductByName(String name);
	public Product getProduct(long id);
}
