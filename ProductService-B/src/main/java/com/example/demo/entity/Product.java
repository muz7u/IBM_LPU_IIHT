package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class Product {



    private String sku;


    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private boolean active;

    private int unitsInStock;

    private Date dateCreated;

    private Date lastUpdated;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
}
