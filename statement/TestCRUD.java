package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD {

	public static void main(String[] args) throws Exception {
	
		display();
		add();
		update();
		delete();
		findById();	
		findByName();
		findByEmail();
		
	}
	
	
	public static void  add() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		System.out.println("connection");
		
		Statement stmt= conn.createStatement();
		
		int i= stmt.executeUpdate("insert into users values(6, 'rohan', 'joe', 'rohan@gmail.com', '1234', '2024-12-05', 'Indore')");
		
		System.out.println("Data inserted " + i);
	}
	
public static void  update() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		System.out.println("connection");
		
		Statement stmt= conn.createStatement();
		
		int i= stmt.executeUpdate("update users set password='4321' where firstname='Shailja'");
		
		System.out.println("Data updated " + i);
	}

public static void  delete() throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
	
	System.out.println("connection");
	
	Statement stmt= conn.createStatement();
	
	int i= stmt.executeUpdate("delete from users where id = 7");
	
	System.out.println("Data deleted " + i);
}
	
	
	public static void display() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance","root","root");
		
		Statement stmt= conn.createStatement();
		
		ResultSet rst= stmt.executeQuery("select * from users");
		
		while(rst.next()) {
			
			System.out.println(rst.getInt(1));
			System.out.println("\t"+ rst.getString(2));
			System.out.println("\t"+ rst.getString(3));
			System.out.println("\t"+ rst.getString(4));
			System.out.println("\t"+ rst.getString(5));
			System.out.println("\t"+ rst.getString(6));
			System.out.println("\t"+ rst.getString(7));
		}
	}
	
public static void findById() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance","root","root");
		
		Statement stmt= conn.createStatement();
		
		ResultSet rst= stmt.executeQuery("select * from users where id= 3");
		
		while(rst.next()) {
			
			System.out.println(rst.getInt(1));
			System.out.println("\t"+ rst.getString(2));
			System.out.println("\t"+ rst.getString(3));
			System.out.println("\t"+ rst.getString(4));
			System.out.println("\t"+ rst.getString(5));
			System.out.println("\t"+ rst.getString(6));
			System.out.println("\t"+ rst.getString(7));
		}
	}
	
public static void findByName() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance","root","root");
		
		Statement stmt= conn.createStatement();
		
		ResultSet rst= stmt.executeQuery("select * from users where firstname= 'Milind'");
		
		while(rst.next()) {
			
			System.out.println(rst.getInt(1));
			System.out.println("\t"+ rst.getString(2));
			System.out.println("\t"+ rst.getString(3));
			System.out.println("\t"+ rst.getString(4));
			System.out.println("\t"+ rst.getString(5));
			System.out.println("\t"+ rst.getString(6));
			System.out.println("\t"+ rst.getString(7));
		}
	}

public static void findByEmail() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance","root","root");
		
		Statement stmt= conn.createStatement();
		
		ResultSet rst= stmt.executeQuery("select * from users where loginid= 'zain@gmail.com'");
		
		while(rst.next()) {
			
			System.out.println(rst.getInt(1));
			System.out.println("\t"+ rst.getString(2));
			System.out.println("\t"+ rst.getString(3));
			System.out.println("\t"+ rst.getString(4));
			System.out.println("\t"+ rst.getString(5));
			System.out.println("\t"+ rst.getString(6));
			System.out.println("\t"+ rst.getString(7));
		}
	}

}
