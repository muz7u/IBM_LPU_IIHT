package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.InstructorDetails;
import com.example.service.InstructorDetailsService;

@RestController
@RequestMapping("/api")
public class InstructorDetailsController 
{
	
	private InstructorDetailsService instructorDetailsService;
	
	@Autowired
	public InstructorDetailsController(InstructorDetailsService instructorDetailsService) {
		super();
		this.instructorDetailsService = instructorDetailsService;
	}


	@PostMapping("/instructors_details")
	public InstructorDetails createInstructorDetails(@RequestBody InstructorDetails instructorDetails)
	{
		return instructorDetailsService.createInstructorDetails(instructorDetails);
	}
	
	@GetMapping("/instructors_details")
	public List<InstructorDetails> getAllInstructorDetails()
	{
		return instructorDetailsService.getAllInstructorDetails();
	}
	
	
	@GetMapping("/instructors_details/{id}")
	public InstructorDetails findInstructorDetailsById(@PathVariable("id")int id)
	{
		return instructorDetailsService.findInstructorDetailsById(id);
	}
}
