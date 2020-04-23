package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetails;

@Repository("instructorDetailsDAO")
public class InstructorDetailsDAOImpl implements InstructorDetailsDAO {

	EntityManager entityManager;
	
	@Autowired
	public InstructorDetailsDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private Session session; 

	@Override
	public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails) {
		// TODO Auto-generated method stub
		session=entityManager.unwrap(Session.class);
		Instructor objInstructor=instructorDetails.getInstructor();
		objInstructor.setInstructorDetails(instructorDetails);
		session.getTransaction().begin();
		session.save(objInstructor);
		session.getTransaction().commit();
		return instructorDetails;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<InstructorDetails> getAllInstructorDetails() {
		session=entityManager.unwrap(Session.class);
		
		Query query=session.createQuery("from InstructorDetails", InstructorDetails.class);
		return query.getResultList();	
	}
	
	
	@Override
	public InstructorDetails findInstructorDetailsById(int id) {
		session=entityManager.unwrap(Session.class);
		session.getTransaction().begin();
		InstructorDetails objInstructorDetails=session.get(InstructorDetails.class, id);
		session.getTransaction().commit();
		return objInstructorDetails;
	}
	

}
