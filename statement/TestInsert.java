package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] agrs) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		Statement stmt= conn.createStatement();
		
		int i= stmt.executeUpdate(
				"insert into users values(4, 'ujj','Patidar','ujj@gmail.com','1234','2024-12-02','Indore' )");
		
		System.out.println("data inserted :)");
		
	}
	
}
