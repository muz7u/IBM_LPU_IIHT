package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private CustomerType type;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer id, String name, CustomerType type) {
		super();
		this.id = id;
		
		this.name = name;
		this.type = type;
	}


	public Customer( String name, CustomerType type) {
		super();
		
		this.name = name;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public CustomerType getType() {
		return type;
	}


	public void setType(CustomerType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
}
