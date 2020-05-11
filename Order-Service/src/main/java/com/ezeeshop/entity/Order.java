package com.ezeeshop.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="orderId")
	private Customer customerId;
	
	private String transactionId;
	
	private boolean transactionStatus;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="orderList")
	private List<Product> productList;
	
	private Integer orderQuantity;
	
	@CreationTimestamp
	private LocalDate orderDate;


	public void addProduct(Product objProduct)
	{
		productList.add(objProduct);
	}


	public Order(Customer customerId, String transactionId, boolean transactionStatus, List<Product> productList,
			Integer orderQuantity, LocalDate orderDate) {
		super();
		this.customerId = customerId;
		this.transactionId = transactionId;
		this.transactionStatus = transactionStatus;
		this.productList = productList;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}


	
}
