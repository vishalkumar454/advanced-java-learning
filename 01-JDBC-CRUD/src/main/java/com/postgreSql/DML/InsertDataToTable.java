package com.postgreSql.DML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataToTable {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=root";
		String query = "insert into emp"
				+ "(empid,empname,empsalary,empdesignation) VALUES(?,?,?,?)";

		
		try(Connection con =  DriverManager.getConnection(url)){
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "203");
			ps.setString(2, "radhekrishn");
			ps.setInt(3, 135000);
			ps.setString(4, "Backend Developer");
			
			int rowsEffected = ps.executeUpdate();
			System.out.println("number of rows effected = " + rowsEffected);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
