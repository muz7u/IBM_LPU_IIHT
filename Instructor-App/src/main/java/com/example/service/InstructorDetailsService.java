package com.example.service;

import java.util.List;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetails;

public interface InstructorDetailsService {
	
	public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails);

	public List<InstructorDetails> getAllInstructorDetails();
	public InstructorDetails findInstructorDetailsById(int id);

}
