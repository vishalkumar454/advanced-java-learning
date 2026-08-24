package com.postgreSql.DML;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertDataUsingProcedure {
	
	public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/mydb"
        		+ "?user=postgres&password=root";

        String query = "CALL insert_emp_data(?, ?, ?, ?)";

        try(Connection con = DriverManager.getConnection(url)) {

            CallableStatement cstmt = con.prepareCall(query);

            cstmt.setString(1, "101");
            cstmt.setString(2, "Vishal");
            cstmt.setInt(3, 5000000);
            cstmt.setString(4, "Full stack Developer");

            cstmt.execute();

            System.out.println("Student inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
