package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao dao;
	@Autowired
	public UserServiceImpl(UserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) dao.findAll();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		if(dao.existsById(userId))
		return dao.findById(userId).get();
		else
			return null;
	}

	@Override
	public boolean userExist(int userId) {
		// TODO Auto-generated method stub
		if(dao.findById(userId).isPresent())
		return true;
		else
			return false;
	}

}
