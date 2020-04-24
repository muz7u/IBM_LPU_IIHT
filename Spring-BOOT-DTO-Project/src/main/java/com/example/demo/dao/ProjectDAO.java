package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;

@Repository(value = "projectDAO")
public interface ProjectDAO extends CrudRepository<Project, Integer>{
	
	
	@Query
	public Iterable<Project> findByName(String name);
	public Iterable<Project> findByAgentName(String name);
	public Iterable<Project> findByAgentNameAndName(String agentName, String Name);
	public void removeByName(String name);
}