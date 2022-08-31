package com.database.services;


import java.sql.DriverManager;

public class ConnectionCheck {
	
	public static void main(String[] args) {
		
		String jdbc = "jdbc:mysql://localhost:3306/Configuration_Testings";
		String user = "root";
		String pass = "123456789";
		
		try {
			System.out.println("jdbc url: "+jdbc);
			DriverManager.getConnection(jdbc,user,pass);
			System.out.println("Connection Successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
