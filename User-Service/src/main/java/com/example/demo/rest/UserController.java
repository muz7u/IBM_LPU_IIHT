package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable("userId")int userId)
	{
		return service.getUser(userId);
	}
	
	@GetMapping("/userExist/{userId}")
	public boolean userExists(@PathVariable("userId")int userId)
	{
		return service.userExist(userId);
	}
}
