package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetails;
import com.example.service.InstructorServiceImpl;

@RestController
@RequestMapping("/api")
public class InstructorController 
{
	private InstructorServiceImpl instructorService;

	@Autowired
	public InstructorController(InstructorServiceImpl instructorService) 
	{
		super();
		this.instructorService = instructorService;
	}
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructor()
	{
		return instructorService.getAllInstructor();
	}
	
	@PostMapping("/instructors")
	public Instructor createInstructor(@RequestBody Instructor instructor)
	{
		return instructorService.createInstructor(instructor);
	}
	
	@DeleteMapping("/instructors/{id}")
	public void deleteInstructorById(@PathVariable("id")int id)
	{
		instructorService.deleteInstructorById(id);
	}
	
	@GetMapping("/instructors/{id}")
	public Instructor findInstructorById(@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		Instructor objInstructor=instructorService.findInstructorById(id);
		if(objInstructor==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			return objInstructor;
	}
	

	
}
