package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

	
	@Query
	public Iterable<Employee> findByDepartmentname(String departmentName);
}
