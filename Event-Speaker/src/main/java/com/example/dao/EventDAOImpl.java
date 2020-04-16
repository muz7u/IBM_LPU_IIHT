package com.example.dao;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import comm.example.model.Event;
import comm.example.model.Speaker;

public class EventDAOImpl implements EventDAO {

	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	@Autowired
	public EventDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@PostConstruct
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}
	
	public Event createEvent(Event event) {
		entityManager.getTransaction().begin();
		entityManager.persist(event);
		entityManager.getTransaction().commit();
		
		return event;
	}

	public void removeEvent(int id) 
	{
		Event event=findEvent(id);
		if(event==null)
		{
			System.out.println("No event with event ID : "+id+" to be removed");
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.remove(event);
			entityManager.getTransaction().commit();
		}

	}

	public Event findEvent(int id) {
		Event event=entityManager.find(Event.class, id);
		if(event==null)
		{
			System.out.println("No Event with event ID : "+id);
			return null;
		}
		else
			return event;
	}

	public Collection<Event> findAllEvent() {

		Collection<Event> collection=entityManager.createQuery("select e from event s", Event.class).getResultList();
		return collection;
	}

}
