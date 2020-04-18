package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;


public class AddNewLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<League> list=new ArrayList<League>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doListProcess(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAddProcess(request, response);
	}
	
	protected void doAddProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String leagueId=request.getParameter("leagueId").toString();
		String season=request.getParameter("season").toString();
		int year=Integer.parseInt(request.getParameter("year"));
		String title=request.getParameter("title").toString();
		
		if(year>=1997 || year<=2020)
		{
			list.add(new League(leagueId,season,year,title));
			RequestDispatcher view=request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view=request.getRequestDispatcher("error.html");
			view.forward(request, response);
		}
		
	}
	
	protected void doListProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list.add(new League(UUID.randomUUID().toString(), "SUMMER", 2020, "Duke's Soccer League"));
		list.add(new League(UUID.randomUUID().toString(), "Autumn", 2020, "English Premere League"));
		list.add(new League(UUID.randomUUID().toString(), "Winter", 2020, "Beach Volley League"));
		out.println("<html><head><title>list all league</title></head><body><table border='1'><tr><td>League ID</td>"
				+ "<td>League Title</td><td>League Year</td><td>Season</td></tr>");
		for(League l:list)
		{
			out.println("<tr><td>"+l.getLeagueID()+"</td><td>"+l.getTitle()+"</td><td>"
					+l.getYear()+"</td><td>"+l.getSeason()+"</td></tr>");
		}
		out.println("</table></body></html>");
		
		
		
	}
	
	
	

}
