package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager em;
	private SessionFactory sessionFactory;
	
	@Autowired
	public CustomerDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	@Transactional
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}

	@Override
	@Transactional
	public Customer findByName(String name) {
		em=sessionFactory.createEntityManager();
		Session session=em.unwrap(Session.class);
		Query<Customer> query=session.createQuery("select a Customer from Customer a where a.name= :name");
		query.setParameter(1, name);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Customer createAccount(Customer customer) {
		// TODO Auto-generated method stub
		em.persist(customer);
		
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> fetchAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

}
