package com.database.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class DeleteRecord {
	
	public static void main(String[] args) {
		
		System.out.println("Connecting to Database");
		SessionFactory factory = null;
		Session session = null;
		Transaction ts = null;
		
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Teacher_Details.class)
				.buildSessionFactory();
		
		System.out.println("Connected to Database");
		
		try {
			session = factory.getCurrentSession();
			ts = session.beginTransaction();
			int id = 1;
			Teacher tempTeacher = session.get(Teacher.class, id);
			if(tempTeacher!=null) {
				System.out.println("Deleting Records with Reference ID"+id);
				session.delete(tempTeacher);
			}
			ts.commit();
		}
        catch ( Exception e) {
        	System.out.println("Error Occured While Deletion");
        	e.printStackTrace();
        	ts.rollback();
		}
		finally {
			session.close();
		}
		
	}

}
