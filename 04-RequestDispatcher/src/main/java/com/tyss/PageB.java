package com.tyss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-b")

public class PageB extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("pageB is triggered");
		
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body>"
				+ "<h2>pageB servlet is triggred"
				+ "<html><body>");
		
		Student student = new Student("mangi", 20, 234567);
		
		Object obj = req.getAttribute("personName");
		Object obj2 = req.getAttribute("personAge");
		
		System.out.println(obj);
		System.out.println(obj2);
		
		req.setAttribute("pname", obj);
		req.setAttribute("page", obj2);
		req.setAttribute("student", student);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, resp);
		
		
		
	}
}
