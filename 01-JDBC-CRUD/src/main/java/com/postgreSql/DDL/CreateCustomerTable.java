package com.postgreSql.DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCustomerTable {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		String query = "CREATE TABLE Customer( " + 
				"CID varchar(10) PRIMARY KEY," 
				+ "CNAME varchar(20) NOT NULL,"
				+ "PhoneNo bigint NOT NULL," +
				"PID varchar(10),"
				+ "CONSTRAINT PID_FK FOREIGN KEY(PID) "
				+ "REFERENCES PRODUCT(PID) )";

		try (Connection con = DriverManager.getConnection(url, username, password)) {
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
