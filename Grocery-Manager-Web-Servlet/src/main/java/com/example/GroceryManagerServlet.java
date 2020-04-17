package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Items;

/**
 * Servlet implementation class GroceryManagerServlet
 */
public class GroceryManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Items> list=null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Items>();
		list.add(new Items(1,"Chicken",200));
		list.add(new Items(2,"Rice",100));
		list.add(new Items(3,"Masur Dal",60));
		list.add(new Items(4,"Onion",70));
		out.println("<html><head><title>list all league</title></head><body><table border='1'><tr><td>Item ID</td>"
				+ "<td>Item Name</td><td>Item price</td>");
		for(Items i:list)
		{
			out.println("<tr><td>"+i.getItemId()+"</td><td>"+i.getItemName()+"</td><td>"+i.getItemPrice()+"</td></tr>");
		}
		out.println("</table></body></html>");
		
		
		
	}

}
