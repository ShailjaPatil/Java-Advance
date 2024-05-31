package com.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.UserBean;

public class UserModelTest {
	
	public static void main(String[] args) throws Exception {

//		testAdd();
//		testFindByPk();
//		testFindByLoginId();
//		testAuth();
//		testSearch();
		
	}
	
// TEST_ADD METHOD
	private static void testAdd() throws Exception {
			
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			
			UserBean bean= new UserBean();
			
			UserModel model= new UserModel();
	
			
			bean.setFirstname("shivangi");
			bean.setLastname("savita");
			bean.setLoginid("shivangi@gmial.com");
			bean.setPassword("123");
			bean.setDob(sdf.parse("2024-02-02"));
			bean.setAddress("Indore");
			
			model.add(bean);
			
		}
	
//TEST_FIND_BY_PK METHOD
	private static void testFindByPk() throws Exception {
			
			UserBean bean= new UserBean();
			
			UserModel model= new UserModel();
			
			bean= model.findByPk(6);
			
			if(bean!=null) {
				
				System.out.println(bean.getId());
				System.out.println(bean.getFirstname());
			}
			else {
				System.out.println("User not found!");
			}
		}
	
//TEST_FIND_BY_LOGINID
	private static void testFindByLoginId() throws Exception {
			
			UserBean bean=new UserBean();
			
			UserModel model= new UserModel();
			
			bean= model.findByLoginId("milind@gmail.com");
			
			if(bean!=null) {
				
				System.out.println("User found");
				System.out.println(bean.getFirstname());
			}
			else {
				System.out.println("Invalid");
			}
	}
	
//TEST_AUTH METHOD
	private static void testAuth() throws Exception {
		
		UserBean bean= new UserBean();
		
		UserModel model= new UserModel();
		
		bean= model.authenticate("shailja@gmail.com", "4321");
		
		if(bean!=null) {
			
			System.out.println("User logged in");
			System.out.println(bean.getFirstname());
		}
		else {
			System.out.println("Invalid User");
		}
		
	}
	
//TEST_SEARCH METHOD
	private static void testSearch() throws Exception {
			
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			 Date dob= sdf.parse("2002-02-02");
			
			UserBean bean= new UserBean();
			
			List list = new ArrayList();
			
			UserModel model= new UserModel();
			
			bean.setFirstname("Shailja");
			
			bean.setDob(new java.sql.Date(dob.getTime()));
			
			list= model.search(bean);
			
			Iterator it = list.iterator();
			
			while(it.hasNext()) {
				
				bean= (UserBean)it.next();
				
				System.out.println(bean.getFirstname()+ "hello");
			}
			
		}

}
