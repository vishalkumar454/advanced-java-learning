package com.postgreSql.DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Rename {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "root";
		String addQuery = "ALTER TABLE employee "
				+ "ADD loan bigint";
		String dropColumnQuery = "ALTER TABLE employee "
				+ "DROP COLUMN salary";
		String renameColumnQuery = "ALTER TABLE employee "
				+ "rename COLUMN empid To eid";
		
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			Class.forName("org.postgresql.Driver");
			
			Statement stm = con.createStatement();
			
//			stm.execute(addQuery);
			stm.execute(renameColumnQuery);
			stm.execute(dropColumnQuery);
			
			System.err.println("all done");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
