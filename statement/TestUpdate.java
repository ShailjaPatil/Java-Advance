package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		System.out.println("connection done");
		
		Statement stmt= conn.createStatement();
		
		int i= stmt.executeUpdate("update users set password='4321' where firstname='Milind'");
		
		System.out.println("Data updated "+ i);

	}

}
