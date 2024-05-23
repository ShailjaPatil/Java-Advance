package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestRead {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root","root");
		
		Statement stmt= conn.createStatement();
		
		ResultSet rst= stmt.executeQuery("select * from users");
		
		while(rst.next()) {
			
			System.out.println(rst.getInt(1));
			System.out.println("\t"+rst.getString(2));
			System.out.println("\t"+rst.getString(3));
			System.out.println("\t"+rst.getString(4));
			System.out.println("\t"+rst.getString(5));
			System.out.println("\t"+rst.getDate(6));
			System.out.println("\t"+rst.getString(7));
			
		}
	}

}
