package com.database.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class QueryingDatabase {

	public static void main(String[] args) {

		SessionFactory factory = null;
		Session session = null;
		Transaction ts = null;
		List<Teacher> teacher = null;
		List<Teacher_Details> teacher_details = null;

		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Teacher_Details.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();

		try {
			ts = session.beginTransaction();
			String query1 = "FROM Teacher";
			teacher = session.createQuery(query1).list();
			String query2 = "FROM Teacher_Details";
			teacher_details = session.createQuery(query2).list();
			
		} 
		catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
		}
		
		for( Teacher t1:teacher) {
			System.out.println(t1);
		}
		for( Teacher_Details t2:teacher_details) {
			System.out.println(t2);
		}
	}
}
