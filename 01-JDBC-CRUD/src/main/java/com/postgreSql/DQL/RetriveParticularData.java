package com.postgreSql.DQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveParticularData {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=root";
		String query = ""
				+ "SELECT * "
				+ "FROM emp "
				+ "WHERE empname = 'radhekrishn'";

		try (Connection con = DriverManager.getConnection(url)) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				String id = rs.getString("empid");
				String name = rs.getString("empname");
				long salary = rs.getInt(3);
				String designation = rs.getString(4);

				System.out.println(
						"id = " + id + " name - " + name + " salary - " + salary + "  designation - " + designation);

			}
			System.out.println();
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
