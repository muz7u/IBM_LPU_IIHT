package com.example.service;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentRepository;
import com.example.model.Student;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	private EntityManager em;
	
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Iterable<Student> getAllTasks() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Iterable<Student> findBySchoolName(String schoolName) {
		return studentRepository.findBySchoolName(schoolName);
	}


}
