package com.example.demo.dto;


public class ProjectDTO
{
	
	 private String name;
//	 private String description;
	 private String agentName;
	
	 public ProjectDTO(String name, String agentName)
	 {
	
	  this.name = name;
//	  this.description = description;
	  this.agentName = agentName;
	 }
	
	
	
//	 public String getDescription() {
//	  return description;
//	 }
	
	 public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getAgentName() {
	  return agentName;
	 }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
//	public void setDescription(String description) {
//		this.description = description;
	//}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}



	@Override
	public String toString() {
		return "ProjectDTO [name=" + name + ", agentName=" + agentName + "]";
	}

	
	
	
	
	 
	}
