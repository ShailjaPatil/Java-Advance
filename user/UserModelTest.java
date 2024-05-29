package com.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.rays.bean.UserBean;

public class UserModelTest {
	
	public static void main(String[] args) throws Exception {

		testFindByPk();
		testAdd();
		
	}
	
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
	
	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		
		UserBean bean= new UserBean();
		
		UserModel model= new UserModel();

		
		bean.setFirstname("Zainab");
		bean.setLastname("Akkad");
		bean.setLoginid("Zainab@gmial.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("12-02-2024"));
		bean.setAddress("Indore");
		
		model.add(bean);
		
	}

}
