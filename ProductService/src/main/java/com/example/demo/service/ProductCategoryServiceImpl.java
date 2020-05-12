package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductCategoryRepository;
import com.example.demo.entity.ProductCategory;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository dao;
	@Override
	public List<ProductCategory> getAllCategory() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
