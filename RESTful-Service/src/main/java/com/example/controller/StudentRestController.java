package com.example.controller;

import java.util.ArrayList;import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;

import com.example.exception.StudentResponseEntity;

import com.example.exception.StudentNotFoundException;


@RestController
@RequestMapping("/rest")
public class StudentRestController {

	List<Student> theStudents=null;
	@PostConstruct
	public void init()
	{
		theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Ghulam", "Mozammil"));
		theStudents.add(new Student("Harrison", "Wells"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {

		
		return theStudents;
	}
	
	
	@PostMapping("/students/create")
	public Student createStudent(@RequestBody Student objStudent)
	{
		theStudents.add(objStudent);
		return objStudent;
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudentByID(@PathVariable int studentID) throws StudentNotFoundException
	{
		if ( (studentID >= theStudents.size()) || (studentID < 0) )
		{
			throw new StudentNotFoundException("Student id not found - " + studentID);
		}
		return theStudents.get(studentID);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleException(StudentNotFoundException s)
	{
		
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.NOT_FOUND.value(),s.getMessege(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleNubmerFormatException(NumberFormatException n){
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.BAD_REQUEST.value(),"Enter numeric value",System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}

	/*
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> golbalException(Exception e)
	{
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.NOT_ACCEPTABLE.value(),"Exception",System.currentTimeMillis()),HttpStatus.NOT_ACCEPTABLE);
	}
	*/

	
}





