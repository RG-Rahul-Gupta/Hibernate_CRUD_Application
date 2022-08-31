package com.database.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class ReadingFromTable {

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
			Teacher t1 = session.get(Teacher.class, 1);
			System.out.println(t1);
			ts.commit();
		} 
		catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
			ts.rollback();

		}
		finally {
			session.close();
		}
	}

}
