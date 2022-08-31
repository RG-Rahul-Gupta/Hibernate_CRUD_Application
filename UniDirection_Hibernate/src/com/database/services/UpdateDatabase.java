package com.database.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class UpdateDatabase {
	
public static void main(String[] args) {
	 
	SessionFactory factory = null;
	Session session = null;
	Transaction ts = null;
	
	factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Teacher.class)
			.addAnnotatedClass(Teacher_Details.class)
			.buildSessionFactory();
	
	session = factory.getCurrentSession();
	
	try {
		ts = session.beginTransaction();
		
		// Updating Values Using Entity Class Methods 
		Teacher tempTeacher = session.get(Teacher.class, 1);
		tempTeacher.setF_Name("Rahul");
		
		// Updating Values Using the Create Query Method by HQL
		String query = "UPDATE Teacher SET email = 'Rahul@gl.com' WHERE Id = 1";
		session.createQuery(query).executeUpdate();
		
		ts.commit();
	}
	catch(Exception e) {
		System.out.println("Error Occured while updating the Records");
		e.printStackTrace();
		ts.rollback();
	}
	finally {
		session.close();
	}
}

}
