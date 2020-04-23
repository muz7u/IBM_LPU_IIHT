package com.example.service;

import java.util.List;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetails;

public interface InstructorService 
{
	public List<Instructor> getAllInstructor();
	public Instructor createInstructor(Instructor instructor);
	public Instructor findInstructorById(int id);
	public void deleteInstructorById(int id);


}
