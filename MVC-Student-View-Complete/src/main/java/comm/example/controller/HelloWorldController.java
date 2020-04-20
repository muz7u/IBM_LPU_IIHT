package comm.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController 
{

	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld_form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request)
	{
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersion2")
	public String processForm(HttpServletRequest request, Model model)
	{
		String message="Yo!" + request.getParameter("studentName").toString();
		model.addAttribute("Message ", message);
		return "helloworld2";
	}
	
	@RequestMapping("/processFormVersion3")
	public String processForm(@RequestParam ("message") String str, Model model)
	{		
		model.addAttribute("Message", str);
		return "helloworld3";
		
	}
}
