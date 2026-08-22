package demo.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")

public class GetData extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reading data from Form using Get method");
		
		String firstInt = req.getParameter("firstInt");
		int int1 = Integer.parseInt(firstInt);
		
		String secondInt = req.getParameter("secondInt");
		int int2 = Integer.parseInt(secondInt);
		
		String thirdInt = req.getParameter("thirdInt");
		int int3 = Integer.parseInt(thirdInt);
		
		String string = req.getParameter("string");
		
		String decimal = req.getParameter("decimal");
		double dec = Double.parseDouble(decimal);
		
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
		System.out.println(string);
		System.out.println(dec);
		
		PrintWriter pw = resp.getWriter();
		pw.print("Welcome to our page");
		
	}
}
