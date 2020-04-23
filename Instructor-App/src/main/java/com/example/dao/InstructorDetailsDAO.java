package com.example.dao;

import java.util.List;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetails;

public interface InstructorDetailsDAO {

	public List<InstructorDetails> getAllInstructorDetails();
	public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails);
	public InstructorDetails findInstructorDetailsById(int id);
}
