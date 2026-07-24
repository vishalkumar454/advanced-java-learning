package com.postgreSql.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RenameTable {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		String query = "ALTER TABLE student "
				+ "RENAME COLUMN studname TO sid";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection connected");
			
			Statement stm = con.createStatement();
			System.out.println("statement created");
			
			stm.execute(query);
			con.close();
			System.out.println("connection closed");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
