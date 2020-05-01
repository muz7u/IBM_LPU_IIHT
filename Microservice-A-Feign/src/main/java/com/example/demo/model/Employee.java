package com.example.demo.model;

import javax.persistence.Entity;

public class Employee {


//	private Integer employeeId;
	

	private String firstName;

	private String lastName;
	
	private String email;

	private String departmentname;


	public Employee( String firstName, String lastName, String email, String departmentname) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentname = departmentname;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", departmentname=" + departmentname + "]";
	}
	
	
}
