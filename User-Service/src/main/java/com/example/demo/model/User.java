package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int userId;
	private String password;
	private String userName;
	private String email;
	public User(int userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = name;
		this.email = email;
	}
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + userName + ", email=" + email + "]";
	}
	
	
}
