package com.postgreSql.DML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDataIntoTable {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=root";
		String query = "UPDATE emp SET empsalary = ? WHERE empid = ?";

		
		try(Connection con =  DriverManager.getConnection(url)){
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 160000);
			ps.setString(2, "201");
			
			int rowsEffected = ps.executeUpdate();
			System.out.println("number of rows effected = " + rowsEffected);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
