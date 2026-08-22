package com.postgreSql.DML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDataFromTable {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=root";
		String query = "DELETE FROM emp WHERE empid = ?";

		
		try(Connection con =  DriverManager.getConnection(url)){
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "201");
			
			int rowsEffected = ps.executeUpdate();
			System.out.println("number of rows effected = " + rowsEffected);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
