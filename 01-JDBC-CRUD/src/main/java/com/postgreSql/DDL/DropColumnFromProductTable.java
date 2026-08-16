package com.postgreSql.DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropColumnFromProductTable {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=root";
		String query = "ALTER TABLE PRO "
				+ "DROP COLUMN MFD";
				
		try(Connection con = DriverManager.getConnection(url)) {
			Class.forName("org.postgresql.Driver");
			Statement stm = con.createStatement();
			stm.execute(query);
			System.out.println("connection closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
