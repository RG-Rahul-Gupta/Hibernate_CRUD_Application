package com.database.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Teacher;
import com.database.entity.Teacher_Details;

public class Insert {

	public static void main(String[] args) {

		// Step 1 - Start Connection With Database
		System.out.println("Connecting With the Datbase");

		// To proceed with Connection Create Objects for All functionalities
		SessionFactory factory = null;
		Session session = null;
		Transaction ts = null;

		// for database connectivity declare the connection statement with configuration
		// file and class declaration
		// declare Session Factory
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.database.entity.Teacher.class)
				.addAnnotatedClass(com.database.entity.Teacher_Details.class).buildSessionFactory();
		System.out.println("Connected to Database and Created ");

		try {
			// start session
			session = factory.getCurrentSession();

			// Creating of Objects of Class Teachers and Calling Constructors to Add Data to
			// Tables
			// Teacher t2 = new Teacher("Shyam", "Babu", "ShyamBabu@xyz.com");
			//Teacher t3 = new Teacher("Seetal","Suri","SeetalSuri@xyz.com");
			 Teacher t4 = new Teacher("Aradhya","Venu","AradhyaVenu@xyz.com");

			// Creating of Objects of Class Teacher_Details and Calling Constructors to Add
			// Data to Tables
			// Teacher_Details td2 = new Teacher_Details("Lucknow", "Playing Football");
			//Teacher_Details td3 = new Teacher_Details("Mumbai","PC Gaming");
			 Teacher_Details td4 = new Teacher_Details("Pune","Playing Guitar");

			// associate the Objects of Table with Each other
			t4.setTeacher_details(td4);
			// Start the Transaction
			ts = session.beginTransaction();

			// Saving Entries to Make Entry of Records
			session.save(t4);

			// Start the Transaction
			ts.commit();

		} catch (Exception e) {
			System.out.println("Error in Records");
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}

}
