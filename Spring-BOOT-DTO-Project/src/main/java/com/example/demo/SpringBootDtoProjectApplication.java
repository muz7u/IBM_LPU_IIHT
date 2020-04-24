package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.model.Project;

@SpringBootApplication
public class SpringBootDtoProjectApplication implements CommandLineRunner{

	private ProjectDAO projectDAO;
	
	@Autowired 
	public SpringBootDtoProjectApplication(ProjectDAO projectDAO) {
		super();
		this.projectDAO = projectDAO;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDtoProjectApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		projectDAO.save(new Project("project 1", "demo description-1", "agent-1"));
		projectDAO.save(new Project("project 2", "demo description-2", "agent-2"));
		projectDAO.save(new Project("project 3", "demo description-3", "agent-3"));
		projectDAO.save(new Project("project 4", "demo description-4", "agent-4"));
		
	}
	
}
