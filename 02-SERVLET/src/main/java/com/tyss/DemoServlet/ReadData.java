package com.tyss.DemoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/read")

public class ReadData extends GenericServlet{
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("welcome to App");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		
		PrintWriter pw = res.getWriter();
		pw.print("<html> <body> <h2>welcome " + username+ " to MY application </h2>"
				+ "<html> <body>");;
	}
	
}
