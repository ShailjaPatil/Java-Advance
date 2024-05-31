package com.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class HiPropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResourceBundle rb= ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));
		
		System.out.println(rb.getString("greeting"));

	}

}
