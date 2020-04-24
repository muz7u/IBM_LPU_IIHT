package com.example.demo.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.model.Project;

public interface ProjectDTOService 
{
	 public ProjectDTO getProjectById(Integer id);
	 
	 
	 public List<ProjectDTO> getAllProjects();
	 public ProjectDTO createProject(ProjectDTO projectDTO);
	 public ProjectDTO updateProject(ProjectDTO projectDTO);
	 public ProjectDTO deleteProjectById(Integer id);
	 
	 public ProjectDTO findByName(String name);
	 public ProjectDTO findByAgentName(String name);
	 public ProjectDTO findByAgentNameAndName(String agentName, String Name);
	 public void removeByName(String name);
}
