package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.dto.ProjectDTO;
import com.example.demo.model.Project;


@Service
public class ProjectDTOServiceImpl implements ProjectDTOService
{
	private ProjectDAO projectDAO;
	@Autowired
	public ProjectDTOServiceImpl(ProjectDAO projectDAO) {
		super();
		this.projectDAO = projectDAO;
	}

	@Override
	public ProjectDTO getProjectById(Integer id)
	{
	  if (projectDAO.findById(id).isPresent())
	  {
	   Project objProject = projectDAO.findById(id).get();
	   ProjectDTO objProjectDTO=new ProjectDTO(objProject.getName(),objProject.getAgentName());
	   return  objProjectDTO;
	  }
	  else 
	  {
	   return null;
	  }
 }

 @Override
 public List<ProjectDTO> getAllProjects() 
 {
	 List<ProjectDTO> projectDTOList = new ArrayList<>();
	 projectDAO.findAll().forEach(project -> 
	 {
		 projectDTOList.add(new ProjectDTO(project.getName(),project.getAgentName()));
	 }
	 );

  return projectDTOList;
 }

 @Override
 public ProjectDTO createProject(ProjectDTO projectDTO)
 	{
 		
 		Project project = new Project(UUID.randomUUID().toString(),projectDTO.getAgentName(), projectDTO.getName());
 		projectDAO.save(project);
 		return projectDTO;
 	}

@Override
public ProjectDTO updateProject(ProjectDTO projectDTO) {
	Project objProject=new Project();
	
	objProject.setAgentName(projectDTO.getAgentName());
	objProject.setName(projectDTO.getName());
	objProject.setDescription(UUID.randomUUID().toString());
	projectDAO.save(objProject);
	return projectDTO;
}

@Override
public ProjectDTO deleteProjectById(Integer id) {
	if (projectDAO.findById(id).isPresent()) {
		Project project = projectDAO.findById(id).get();
		ProjectDTO projectDTO = new ProjectDTO(project.getAgentName(),project.getName());
		projectDAO.deleteById(id);
		return projectDTO;
	} else
		return null;
}

@Override
public Iterable<Project> findByName(String name) {
	
		return projectDAO.findByName(name);

}

@Override
public Iterable<Project> findByAgentName(String name) {
	// TODO Auto-generated method stub
	return projectDAO.findByAgentName(name);
}

@Override
public Iterable<Project> findByAgentNameAndName(String agentName, String Name) {
	// TODO Auto-generated method stub
	return projectDAO.findByAgentNameAndName(agentName, Name);
}

@Override
@Transactional
public void removeByName(String name) {
	projectDAO.removeByName(name);
	
}


	
}
