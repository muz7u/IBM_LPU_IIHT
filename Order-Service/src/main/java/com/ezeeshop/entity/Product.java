package com.ezeeshop.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Product {

	private Long productId;
	private String productName;
	private Long productPrice;
	
	@ManyToOne
	@JoinColumn(name="categoryId", nullable=false)
	private ProductCategory objProductCategory;
	
	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.PERSIST})
	private List<Order> orderList;
	
	private String productImageUrl;
	private LocalDate productAddDate;
	private String productDescription;
}
