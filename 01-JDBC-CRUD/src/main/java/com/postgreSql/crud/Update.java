package com.postgreSql.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		
		String query = "UPDATE student SET sname='Krishna' where sid=101";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stm = con.createStatement();
			
			stm.execute(query);
			con.close();
			System.out.println("done");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
