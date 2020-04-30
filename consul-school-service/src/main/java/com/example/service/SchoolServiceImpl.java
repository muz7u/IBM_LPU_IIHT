package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.SchoolRepository;
import com.example.model.School;

@Service(value = "schoolService")
public class SchoolServiceImpl {
	private SchoolRepository schoolRepository;

	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}


	public Iterable<School> getAllTasks() {
		// TODO Auto-generated method stub
		return schoolRepository.findAll();
	}
	
	 @Autowired
	    RestTemplate restTemplate;

	    public List<Object> getAllService() {
	        return restTemplate.getForObject("http://java76.iiht.tech:8502/students",List.class);
	    }


	    public Object getStudentBySchoolName(String schoolName) {
	        return restTemplate.getForObject("http://java76.iiht.tech:8502/students/"+schoolName,Object.class);
	    }
}
