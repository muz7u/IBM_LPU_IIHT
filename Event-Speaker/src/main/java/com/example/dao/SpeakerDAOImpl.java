package com.example.dao;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import comm.example.model.Speaker;

public class SpeakerDAOImpl implements SpeakerDAO {

	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	@Autowired
	public SpeakerDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@PostConstruct
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}
	
	public Speaker createSpeaker(Speaker speaker) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(speaker);
		entityManager.getTransaction().commit();
		
		return speaker;
	}

	public void removeSpeaker(int id) {
		
		Speaker speaker=findSpeaker(id);
		if(speaker==null)
		{
			System.out.println("No speaker with speaker ID : "+id+" to be removed");
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.remove(speaker);
			entityManager.getTransaction().commit();
		}

	}

	public Speaker findSpeaker(int id) {

		Speaker speaker=entityManager.find(Speaker.class, id);
		if(speaker==null)
		{
			System.out.println("No Speaker with speaker ID : "+id);
			return null;
		}
		else
			return speaker;
		
	}

	public Collection<Speaker> findAllSpeaker() {
		Collection<Speaker> collection=entityManager.createQuery("select s from speaker s", Speaker.class).getResultList();
		return collection;
	}

}
