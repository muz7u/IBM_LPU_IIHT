package com.example.dao;

import java.util.List;

import com.example.entity.Instructor;

public interface InstructorDAO 
{
	public List<Instructor> getAllInstructor();
	public Instructor createInstructor(Instructor instructor);
	public Instructor findInstructorById(int id);
	public void deleteInstructorById(int id);
	
	
}
