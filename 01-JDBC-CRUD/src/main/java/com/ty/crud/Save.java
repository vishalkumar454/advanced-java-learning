package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Save {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		
		String query = "insert into student values(104,'nishant','nishant@gmail.com',8998765555)";
		
		try {
			
			// step 1 : Load the driver
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			// step 2 : Establish a connection
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			// step 3 : create a statement
			
			Statement stm =  con.createStatement();
			
			// step 4 : execute a query
			
			stm.execute(query);
			
			System.out.println("query executed");
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
