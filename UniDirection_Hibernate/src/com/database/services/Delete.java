package com.database.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class Delete {
	
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
			
			 // Deleting Record Using Delete Method
			 Teacher tempTeacher = session.get(Teacher.class, 2);
			 session.delete(tempTeacher);
			 
			 //Deleting Record Using CreateQuery Method
			 String query = "DELETE FROM Teacher WHERE id = 2";
			session.createQuery(query).executeUpdate();
			
			ts.commit();
		}
		catch(Exception e) {
			System.out.println("Error Occured While Deleting the Record");
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
		}
	}

}

























