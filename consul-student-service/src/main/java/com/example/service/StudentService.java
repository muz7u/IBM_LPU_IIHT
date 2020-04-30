package com.example.service;



import com.example.model.Student;

public interface StudentService {
	
	public Iterable<Student> getAllTasks();
	public Iterable<Student> findBySchoolName(String schoolName);
}
