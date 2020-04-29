package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeController 
{
	
	EntityManager em;
	
	@Autowired	
	public EmployeeController(EntityManager em) {
		super();
		this.em = em;
	}

	@GetMapping("/employees")
	public String findAllEmployee(Model model)
	{
		List<Employee> list= em.createQuery("from Employee",(Employee.class)).getResultList();
		model.addAttribute("employees", list);
		return "employeelist";
	}

	 @RequestMapping(value="/employees/getById")
		public String getById(Model model)
		{
			model.addAttribute("employeeId", new Employee());
			return "idform";
		}
	
	@GetMapping("/employees/{employeeId}")
	public String findEmployeeById(@PathVariable("employeeId") int employeeId, Model model)
	{
		model.addAttribute("employee",em.find(Employee.class, employeeId));
		 return "findbyid";
	}
	
	 
	
	@RequestMapping(value="/employee/new")
	public String newProduct(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "employeeform";
	}
	

	@PostMapping("/employee")
	public String createEmployee(Employee employee)
	{
		em.persist(employee);
		return "redirect:/employees";
	}
	
}
