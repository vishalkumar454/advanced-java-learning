package com.tyss;

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
		System.out.println("Servlet PageA is triggred");
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body>"
				+ "<h2>pageA servlet is triggred"
				+ "<html><body>");
		
		String personName = "penga";
		int personAge = 24;
		
		req.setAttribute("personName", personName);
		req.setAttribute("personAge", personAge);
		
		// 2nd servlet is invoking
		RequestDispatcher rd = req.getRequestDispatcher("page-b");
		rd.include(req, resp);
		
		// dispatching jsp file
		
//		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//		rd.forward(req, resp);
		
		
	
	}
}
