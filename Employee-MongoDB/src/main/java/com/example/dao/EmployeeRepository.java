package com.example.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public List<Employee> findByEmail(String email);
}
