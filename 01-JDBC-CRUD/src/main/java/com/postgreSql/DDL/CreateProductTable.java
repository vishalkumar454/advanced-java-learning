package com.postgreSql.DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProductTable {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username ="postgres";
		String password ="root";
		String query = "CREATE TABLE Product( "
				+ "PID varchar(10) PRIMARY KEY,"
				+ "PNAME varchar(20) NOT NULL,"
				+ "PRICE bigint NOT NULL,"
				+ "QTY bigint NOT NULL )";
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			Class.forName("org.postgresql.Driver");
			
			System.out.println("driver loaded");
			
			System.out.println("connection created");
			
			Statement stm = con.createStatement();
			System.out.println("statement created");
			
			stm.execute(query);
			System.out.println("query executed");

			System.out.println("connection closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
