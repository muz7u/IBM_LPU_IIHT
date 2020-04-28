package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;

@Repository
public class ImageDAOImpl implements ImageDAO
{

	private EntityManager em;
	
	@Autowired
	public ImageDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	


	@Override
	@Transactional
	public List<Image> getAllImages() {
		
		 return em.createQuery("FROM Image",Image.class).getResultList(); 
		
	}



	@Override
	@Transactional
	public void addImage(Image image) {
		em.persist(image);
		
	}
	
	
	
}
