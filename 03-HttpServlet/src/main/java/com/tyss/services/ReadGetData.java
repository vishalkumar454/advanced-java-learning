package com.tyss.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class ReadGetData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reading data from Form using Get method");
		
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		PrintWriter pw = resp.getWriter();
		pw.print("Welcome to our page");
		
	}
}
