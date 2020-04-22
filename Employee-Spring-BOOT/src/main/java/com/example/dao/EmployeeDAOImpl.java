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
		
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		session=entityManager.unwrap(Session.class);
		Query query=session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}


	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		session=entityManager.unwrap(Session.class);
		session.save(employee);
		return employee;
	}

}
