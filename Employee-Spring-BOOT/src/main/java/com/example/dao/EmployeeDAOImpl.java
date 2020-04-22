package com.example.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Employee;

@EnableTransactionManagement
@Repository(value="employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private Session session;
	@PostConstruct
	public void init()
	{
		session=entityManager.unwrap(Session.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		
		Query query=session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}


	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		session.save(employee);
		return employee;
	}

}
