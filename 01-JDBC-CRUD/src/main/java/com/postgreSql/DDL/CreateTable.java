package com.postgreSql.DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username ="postgres";
		String password ="root";
		String query = "CREATE TABLE employee( "
				+ "empId varchar(20) PRIMARY KEY,"
				+ "empName varchar(20) NOT NULL UNIQUE,"
				+ "empSalary bigint ,"
				+ "empDesignation varchar(20) NOT NULL)";
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			Class.forName("org.postgresql.Driver");
			System.out.println("class loaded");
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
