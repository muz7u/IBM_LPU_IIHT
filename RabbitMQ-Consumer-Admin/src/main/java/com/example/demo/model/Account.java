package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id",scope = Account.class)
@Data
@ToString
@NoArgsConstructor
@ApiModel(description="All details about the Account. ")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated ID")	
	private Integer id;
	
	@ApiModelProperty(notes = "The account type")
    private String accountType;
	
	@ApiModelProperty(notes = "The account balance")
    private String accountBalance;
	@ApiModelProperty(notes = "The account holder name")
    private String accountHolder;
	public Account(String accountType, String accountBalance, String accountHolder) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountHolder = accountHolder;
	}
    
    
	
	}
