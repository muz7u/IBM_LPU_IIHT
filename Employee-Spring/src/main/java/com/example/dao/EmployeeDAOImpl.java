package com.example.dao;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.example.model.Employee;
@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@PostConstruct
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}
	
	public Employee createEmployee(Employee employee) {
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		return employee;
	}

	public void removeEmployee(int id) 
	{
		Employee employee= findEmployee(id);
		if(employee.getId()==id)
		{
		entityManager.getTransaction().begin();
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("No such employee with ID : "+ id);
		}

	}

	public Employee raiseEmployeeSalary(int id, long raise)
	{
		Employee employee=findEmployee(id);
		if(employee==null)
		{
			System.out.println("No such employee with ID : "+ id);
			return null;
		}
		else
		{
			employee.setSalary(employee.getSalary()+raise);
			entityManager.getTransaction().begin();
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
			return employee;
		}
			
	}

	public Employee findEmployee(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		if(employee==null)
			return null;
		else
			return employee;
	}

	public Collection<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}

}
