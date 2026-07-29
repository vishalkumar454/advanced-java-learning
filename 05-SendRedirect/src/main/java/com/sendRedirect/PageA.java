package com.sendRedirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-a")

public class PageA extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet PageA was triggred");
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h2>Welcome to Servlet pageA </h2>");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		req.setAttribute("panme", "rahul");
		req.setAttribute("page", 20);
		
		rd.forward(req, resp);
		
//		we can use both forward or sendredirect at a time 
//		Cannot call sendRedirect() after the response has been committed
		
//		resp.sendRedirect("page-a"); 
	
	}
}
