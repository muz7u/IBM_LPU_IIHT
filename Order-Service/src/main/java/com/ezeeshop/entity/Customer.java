package com.ezeeshop.entity;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
public class Customer {

	@OneToOne(fetch=FetchType.LAZY)
	private Long customerId;
	
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private Long customerMobileNo;
	private String customerImageUrl;
	private Address customerAddress;
}
