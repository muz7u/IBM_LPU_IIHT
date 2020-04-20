package comm.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import comm.example.model.Student1;

@Controller
@RequestMapping("/student1")
public class Student1Controller
{

	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		Student1 objStudent1=new Student1();
		model.addAttribute("student", objStudent1);
		return "student-form1";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student1 refStudent1)
	{
		System.out.println("Student: " + refStudent1.getFirstName()+ " " + refStudent1.getLastName());

		return "student-confirmation";
	}
	
}
