package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Employee {

	private String _id;
	private String firstName;
	private String lastName;
	private String email;
}
