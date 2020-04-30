package com.example.rest;



import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SchoolServiceImpl;

@RestController
@EnableAutoConfiguration
public class SchoolController {

	@Autowired
	private SchoolServiceImpl schoolService;
	
	


    @RequestMapping("/studentBySchoolName/{schoolName}")
    public Object getStudentBySchoolName(@PathVariable("schoolName") String schoolName){
        return schoolService.getStudentBySchoolName(schoolName);
    }
	
	
}
