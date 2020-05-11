package com.ezeeshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class ProductCategory 
{
	private Long productCategoryId;
	private String productCategoryName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="objectProductCategory")
	private List<Product> productList;
	
}
