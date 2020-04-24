package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ProjectDTO;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectDTOService;

@RestController
@RequestMapping("/api")
public class ProjectDTOController 
{
	private ProjectDTOService projectDTOService;
	
	@GetMapping("/projects")
	public ResponseEntity<List<ProjectDTO>> getAllProjects() 
	{
	return new ResponseEntity<>(projectDTOService.getAllProjects(), HttpStatus.OK);
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<ProjectDTO>(projectDTOService.getProjectById(id),HttpStatus.OK);
	 }
	
	@PostMapping("/projects")
	public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO)
	{
		return ResponseEntity.ok().body(projectDTOService.createProject(projectDTO));
	}
	
	@PutMapping("/projects")
	public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO)
	{
		return ResponseEntity.ok().body(projectDTOService.updateProject(projectDTO));
	}
	
	@GetMapping("/projects/name/{name}")
	public ResponseEntity<Iterable<Project>> findByAgentName(@PathVariable("name")String name)
	{
		return ResponseEntity.ok().body(projectDTOService.findByAgentName(name));
	}
	
	@GetMapping("/projects/agent-name/{name}")
	public ResponseEntity<Iterable<Project>> findByName(@PathVariable("name")String name)
	{
		return ResponseEntity.ok().body(projectDTOService.findByName(name));
	}
	
	@GetMapping("/projects/name-n-agent-name/{name}/{agentName}")
	public ResponseEntity<Iterable<Project>> findByAgentNameAndName(@PathVariable("agentName")String agentName, @PathVariable("name")String Name)
	{
		return ResponseEntity.ok().body(projectDTOService.findByAgentNameAndName(agentName, Name));
	}
	
	
	
}
