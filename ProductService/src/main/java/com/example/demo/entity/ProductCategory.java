package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

@Entity
@Table(name="product_category")
//@Data //-- known bug
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

	public ProductCategory(Long id, String categoryName, Set<Product> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}

	public ProductCategory(String categoryName, Set<Product> products) {
		super();
		this.categoryName = categoryName;
		this.products = products;
	}

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}







