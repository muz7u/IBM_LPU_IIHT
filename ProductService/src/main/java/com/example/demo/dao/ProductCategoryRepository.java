package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.ProductCategory;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
