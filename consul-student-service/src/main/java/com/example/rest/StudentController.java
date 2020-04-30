package com.example.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
@EnableAutoConfiguration
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService taskService) {
		super();
		this.studentService = studentService;
	}


	@GetMapping("/students")
	public ResponseEntity<Iterable<Student>> findAllTask()
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllTasks());
	}
	
	@RequestMapping("/students/{schoolName}")
	public List<Student> findBySchoolName(@PathVariable("schoolName") String schoolName)
	{
		List<Student> list=new ArrayList<>();
		Iterable<Student> itr=studentService.findBySchoolName(schoolName);
		for(Student s:itr)
		{
			list.add(s);
		}
		return list;
	}
	
}
