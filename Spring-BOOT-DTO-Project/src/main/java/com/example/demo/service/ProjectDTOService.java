package com.example.demo.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.model.Project;

public interface ProjectDTOService 
{
	 public ProjectDTO getProjectById(Integer id);
	 public List getAllProjects();
	 public ResponseEntity<ProjectDTO> createProject(ProjectDTO projectDTO);
	 public ResponseEntity<ProjectDTO> updateProject(ProjectDTO projectDTO);
	 public ResponseEntity<ProjectDTO> deleteProjectById(Integer id);
	 public Iterable<Project> findByName(String name);
	 public Iterable<Project> findByAgentName(String name);
	 public Iterable<Project> findByAgentNameAndName(String agentName, String Name);
	 public void removeByName(String name);
}
