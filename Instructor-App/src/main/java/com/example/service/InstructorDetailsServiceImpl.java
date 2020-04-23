package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.InstructorDetailsDAO;
import com.example.entity.InstructorDetails;

@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

	private InstructorDetailsDAO instructorDetailsDAO;

	@Autowired
	public InstructorDetailsServiceImpl(InstructorDetailsDAO instructorDetailsDAO) {
		super();
		this.instructorDetailsDAO = instructorDetailsDAO;
	}

	@Override
	public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails) {
		// TODO Auto-generated method stub
		return instructorDetailsDAO.createInstructorDetails(instructorDetails);
	}

	@Override
	public List<InstructorDetails> getAllInstructorDetails() {
		// TODO Auto-generated method stub
		return instructorDetailsDAO.getAllInstructorDetails();
	}
	
	@Override
	public InstructorDetails findInstructorDetailsById(int id)
	{
		return instructorDetailsDAO.findInstructorDetailsById(id);
	}

	@Override
	public void deleteInstructorDetailsById(int id) {
		
		instructorDetailsDAO.deleteInstructorDetailsById(id);
	}

	@Override
	public InstructorDetails updateInstructorDetails(InstructorDetails instructorDetails) {
		// TODO Auto-generated method stub
		return instructorDetailsDAO.updateInstructorDetails(instructorDetails);
	}

}
