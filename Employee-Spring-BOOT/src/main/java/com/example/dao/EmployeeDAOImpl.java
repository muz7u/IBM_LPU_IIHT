package com.example.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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


		
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		
		
		TypedQuery<Employee> query=entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}


	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		
	//	session.getTransaction().begin();
		entityManager.persist(employee);
	//	session.getTransaction().commit();
		return employee;
	}


	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);
		
	}


	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee objEmployee=findEmployeeById(id);
		entityManager.remove(objEmployee);
		
	}


	@Transactional
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		
		
		
		return entityManager.merge(employee);
	}

}
