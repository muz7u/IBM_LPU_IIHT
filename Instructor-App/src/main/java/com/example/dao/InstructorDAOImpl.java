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

import com.example.entity.Instructor;

@EnableTransactionManagement
@Repository(value="instructorDAO")
public class InstructorDAOImpl implements InstructorDAO {

	private EntityManager entityManager;
	
	@Autowired
	public InstructorDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private Session session;
	


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Instructor> getAllInstructor() {
		session=entityManager.unwrap(Session.class);
		
		Query query=session.createQuery("from Instructor", Instructor.class);
		return query.getResultList();	
	}


	@Override

	public Instructor createInstructor(Instructor instructor) {
		session=entityManager.unwrap(Session.class);
			session.getTransaction().begin();
			session.save(instructor);
			session.getTransaction().commit();
			return instructor;
	}


	@Override
	public Instructor findInstructorById(int id) {
		session=entityManager.unwrap(Session.class);
		Instructor instructor=session.get(Instructor.class, id);
		return instructor;
	}


	@Override
	public void deleteInstructorById(int id) {
		session=entityManager.unwrap(Session.class);
		
		Instructor instructor=findInstructorById(id);
		session.getTransaction().begin();
		session.remove(instructor);
		session.getTransaction().commit();
		
	}
/*
 * {
        "firstName": "Ghulamsdfgh",
        "lastName": "Mozafdghfdhgmmmil",
        "email": "mozammil010@gmdsaghfdailvdvfd.com",
        "instructorDetails": {
        	"course":"sciafdhgmasdghfsence",
        	"hobby":"dsghsdafghj-fi"
        }
        
    }
   */
}
