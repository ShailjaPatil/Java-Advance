package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCRUD {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		
		Date dob= sdf.parse("10-10-2024");
		
//		display();
		
//		add(7, "Nirmal","Kandel", "nirmal@gmail.com", "1234",dob, "Inodore" );
		
//		delete(7); // delete by id= 7
		
//		authenticate("milind@gmail.com", "4321");

	}
	
	private static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		return conn;
	}
	
	private static void authenticate(String loginid, String pass) throws Exception {
		
		Connection conn= getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("select * from users where loginid= ? and password= ? ");
		
		pstmt.setString(1, loginid);
		pstmt.setString(2, pass);
		
		ResultSet rst= pstmt.executeQuery();
		
		if(rst!=null) {
			
		System.out.println("Data authenticated");}
		
		else {
			System.out.println("Data not authenticated");
		}
	}
	
	private static void delete(int id) throws Exception {
		
		Connection conn= getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("Delete from users where id = ? ");
		
		pstmt.setInt(1, id);
		
		int i= pstmt.executeUpdate();
		
		System.out.println("Data deleted" + i);
	}
	
	
	private static void add(int id, String fname, String lname, String loginid, String pass, Date dob, String addr ) throws Exception {
		
		Connection conn= getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("insert into users values(? , ? , ? , ? , ? , ? , ?) ");
		
		pstmt.setInt(1, id);
		pstmt.setString(2, fname);
		pstmt.setString(3, lname);
		pstmt.setString(4, loginid);
		pstmt.setString(5, pass);
		pstmt.setDate(6, new java.sql.Date(dob.getTime()));
		pstmt.setString(7, addr);
		
		int i= pstmt.executeUpdate();
		
		System.out.println("Data inserted successfully!!" + i);
				
	}
	
	private static void display() throws Exception {
		
		Connection conn= getConnection();
		
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
}
