package com.example.demo.dao;


import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Account;


@Repository
public class AccountDAOImpl implements AccountDAO {

	private EntityManager em;
	private SessionFactory sessionFactory;
	
	@Autowired
	public AccountDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
			





	@Override
	@Transactional
	public Account findByNumber(String number) {
		
		em=sessionFactory.createEntityManager();
		Session session=em.unwrap(Session.class);
		
		Query<Account> query=session.createQuery("select a Account from Account a where a.number= :number");
		query.setParameter(1, number);
		return query.getSingleResult();
		
	}

	
	@Override
	@Transactional
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Account.class, id);
	}

	@Override
	@Transactional
	public Account findByCustomerId(Integer customerId) {
		
		em=sessionFactory.createEntityManager();
		Session session=em.unwrap(Session.class);
		
		Query<Account> query=session.createQuery("select a Account from Account a where a.customerId= :customerId");
		query.setParameter(1, customerId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
	}






	@Override
	public List<Account> fetchAll() {
		em=sessionFactory.createEntityManager();
		Session session=em.unwrap(Session.class);
		
		Query<Account> query=session.createQuery("from Account",Account.class);
		return query.getResultList();
	}

}
