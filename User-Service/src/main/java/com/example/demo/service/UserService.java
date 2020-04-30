package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUser(int userId);
	public boolean userExist(int userId);
}
