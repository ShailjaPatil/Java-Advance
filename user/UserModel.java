package com.rays.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserBean;

public class UserModel {
	
	public int nextpk() throws Exception {
		
		int pk=0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		PreparedStatement pstmt= conn.prepareStatement("select max(id) from users");
		
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next()) {
			
			pk = rst.getInt(1);
			
			System.out.println("max id= "+ pk);
		}
		
		return pk+1;
	}
	
	public void add(UserBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcadvance", "root", "root");
		
		PreparedStatement pstmt= conn.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		
		UserBean existBean= findByLoginId(bean.getLoginid());
		
		if(existBean!=null) {
			System.out.println("Login id already existing");
		}
		else {
			
			pstmt.setInt(1, nextpk());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getLoginid());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getAddress());
			
			int i= pstmt.executeUpdate();
			
			System.out.println("Data added" + i);
		}	
		
	}
	
	public void update(UserBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update users set firstname=?, lastname=?, loginid=?, password=?, dob=?, address=? where id= ?");
		
		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getLoginid());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getAddress());
		
		int i= pstmt.executeUpdate();
		
		System.out.println("Data Updated"+ i);
			
	}
	
	public void delete( int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from users where id = ?");
		
		pstmt.setInt(1, id);
		
		int i= pstmt.executeUpdate();
		
		if(i!=0) {
		System.out.println("data deleted "+ i);
		}
		else {
			System.out.println("Data not deleted "+ i);
		}

	}
	
	public UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from users where id = ?");

		pstmt.setInt(1, id);

		ResultSet rst = pstmt.executeQuery();

		UserBean bean = null;

		while (rst.next()) {

			bean = new UserBean();

			bean.setId(rst.getInt(1));
			bean.setFirstname(rst.getString(2));
			bean.setLastname(rst.getString(3));
			bean.setLoginid(rst.getString(4));
			bean.setPassword(rst.getString(5));
			bean.setDob(rst.getDate(6));
			bean.setAddress(rst.getString(7));

		}
		return bean;
		
	}
	
	public UserBean findByLoginId(String loginid) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from users where loginid = ?");
		
		pstmt.setString(1,loginid);
		
		ResultSet rst= pstmt.executeQuery();
		
		UserBean bean= null;
		
		while(rst.next()) {
			
			bean= new UserBean();
			
			bean.setId(rst.getInt(1));
			bean.setFirstname(rst.getString(2));
			bean.setLastname(rst.getString(3));
			bean.setLoginid(rst.getString(4));
			bean.setPassword(rst.getString(5));
			bean.setDob(rst.getDate(6));
			bean.setAddress(rst.getString(7));
		}

		return bean;
	}

	
	public UserBean authenticate(String loginid, String password) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from users where loginid = ? and password= ?");
		
		pstmt.setString(1, loginid);
		pstmt.setString(2, password);
		
		ResultSet rst= pstmt.executeQuery();
		
		UserBean bean= null;
		
		while(rst.next()) {
			
			bean= new UserBean();
			
			bean.setId(rst.getInt(1));
			bean.setFirstname(rst.getString(2));
			bean.setLastname(rst.getString(3));
			bean.setLoginid(rst.getString(4));
			bean.setPassword(rst.getString(5));
			bean.setDob(rst.getDate(6));
			bean.setAddress(rst.getString(7));
		}
		
		return bean;		
	}
	
	public List search(UserBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");
		
		StringBuffer sql= new StringBuffer("select * from users where 1=1");
		
		if(bean!=null) {
			
			if( bean.getFirstname()!=null && bean.getFirstname().length()>0) {
				
				sql.append(" and firstname like '" + bean.getFirstname()+ "%'");
			}
			
			if(bean.getDob()!=null && bean.getDob().getTime()>0) {
				
				sql.append("and dob like'"+ new java.sql.Date(bean.getDob().getTime())+ "%'");
			}
			
		}
		
		System.out.println("sql==>"+ sql.toString());
		
		PreparedStatement pstmt= conn.prepareStatement(sql.toString());
		
		ResultSet rst = pstmt.executeQuery();
		
		List list= new ArrayList();
		 
		
		while(rst.next()) {
			bean = new UserBean();
		
			bean.setId(rst.getInt(1));
			bean.setFirstname(rst.getString(2));
			bean.setLastname(rst.getString(3));
			bean.setLoginid(rst.getString(4));
			bean.setPassword(rst.getString(5));
			bean.setDob(rst.getDate(6));
			bean.setAddress(rst.getString(7));
			
			list.add(bean);
		}
		return list;
	}

}
