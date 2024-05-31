package com.rays.test;

import java.util.ResourceBundle;

public class TestSystemProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResourceBundle rb= ResourceBundle.getBundle("com.rays.bundle.system");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));

	}

}
