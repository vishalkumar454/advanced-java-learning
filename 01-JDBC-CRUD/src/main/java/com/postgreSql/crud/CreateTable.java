package com.postgreSql.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";
		
		String query = "CREATE TABLE student("
				+ "sid INTEGER PRIMARY KEY,"
				+ "sname VARCHAR(20) NOT NULL,"
				+ "semail VARCHAR(25) NOT NULL,"
				+ "sphone VARCHAR(10) NOT NULL UNIQUE )";
				
		
		try {
			Class.forName(driver);
			System.out.println("driver loaded");
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection created");
			
			Statement stm = con.createStatement();
			System.out.println("statement created");
			
			stm.execute(query);
			System.out.println("query executed");
			
			con.close();
			System.out.println("connection closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
