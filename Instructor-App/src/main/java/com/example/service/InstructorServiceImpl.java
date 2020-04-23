package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.InstructorDAO;
import com.example.entity.Instructor;


@Service
public class InstructorServiceImpl implements InstructorService {

	private InstructorDAO instructorDAO;
	
	
	@Autowired
	public InstructorServiceImpl(InstructorDAO instructorDAO) {
		super();
		this.instructorDAO = instructorDAO;
	}
	
	@Override
	public List<Instructor> getAllInstructor() {
		
		return instructorDAO.getAllInstructor();
	}



	@Override
	public Instructor createInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorDAO.createInstructor(instructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		
		return instructorDAO.findInstructorById(id);
	}

	@Override
	public void deleteInstructorById(int id) {
		// TODO Auto-generated method stub
		instructorDAO.deleteInstructorById(id);
	}

}
