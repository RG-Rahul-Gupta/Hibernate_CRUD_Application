package com.database.services;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.database.entity.Courses;
import com.database.entity.ReviewOfCourses;
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
		// declare Session Factory
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Teacher_Details.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(ReviewOfCourses.class)
				.buildSessionFactory();
		
		System.out.println("Connected to Database and Created ");

		// start session for initiating the transactions 
		session = factory.getCurrentSession();

		try {
			// Start the Transaction
    		 ts = session.beginTransaction();

			// Creating of Objects of Class Teachers invoking its Constructors defined in its Entity declaration
			 Teacher t1 = new Teacher("Ram", "Gopal", "RamGopal@gl.com");
     	     Teacher t2 = new Teacher("Shyam", "Babu", "ShyamBabu@gmail.com");
			 Teacher t3 = new Teacher("Seetal","Suri","SeetalSuri@yahoo.com");
			 Teacher t4 = new Teacher("Aradhya","Venu","AradhyaVenu@microsoft.com");

			// Creating of Objects of Class Teacher_Details invoking its Constructors defined in its Entity declaration
			 Teacher_Details td1 = new Teacher_Details("Delhi","Swimming");
			 Teacher_Details td2 = new Teacher_Details("Lucknow", "Playing Football");
			 Teacher_Details td3 = new Teacher_Details("Mumbai","PC Gaming");
			 Teacher_Details td4 = new Teacher_Details("Pune","Playing Guitar");
			
			// Creating of Objects of Class Courses invoking its Constructors defined in its Entity declaration
			 Courses c1 = new Courses("Python",15000);
			 Courses c2 = new Courses("Java",10000);
			 Courses c3 = new Courses("Angular",8000);
			 
			 Courses c4 = new Courses("React",4000);
			 Courses c5 = new Courses("HTML",9000);
			 Courses c6 = new Courses("CSS",11000);
			 
			 Courses c7 = new Courses("C++",3000);
			 Courses c8 = new Courses("C#",4000);
			 Courses c9 = new Courses("C",5000);
			 
			 Courses c10 = new Courses("Back-End Developement",75000);
			 Courses c11 = new Courses("Front-End Developement",85000);
			 Courses c12 = new Courses("Full-Stack Developement",160000);
			
			// Creating of Objects of Class Reviews invoking its Constructors defined in its Entity declaration
			 ReviewOfCourses roc1 = new ReviewOfCourses("Excellent Lectures",5); 	 
			 ReviewOfCourses roc2 = new ReviewOfCourses("Great Lectures",4); 	 
			 ReviewOfCourses roc3 = new ReviewOfCourses("Good Lectures",3); 	 
			 ReviewOfCourses roc4 = new ReviewOfCourses("Average Lectures",2); 	 
			 ReviewOfCourses roc5 = new ReviewOfCourses("Poor Lectures",1); 	 
			 
			 List<Courses> t1Courses =new LinkedList<Courses>();
			 t1Courses.add(c1);
			 t1Courses.add(c2);
			 t1Courses.add(c3);
			 
			 List<Courses> t2Courses =new LinkedList<Courses>();
			 t1Courses.add(c4);
			 t1Courses.add(c5);
			 t1Courses.add(c6);
			 
			 List<Courses> t3Courses =new LinkedList<Courses>();
			 t1Courses.add(c7);
			 t1Courses.add(c8);
			 t1Courses.add(c9);
			 
			 List<Courses> t4Courses =new LinkedList<Courses>();
			 t1Courses.add(c10);
			 t1Courses.add(c11);
			 t1Courses.add(c12);
			 
			 List<ReviewOfCourses> c10reviews =new LinkedList<ReviewOfCourses>();
			 c10reviews.add(roc4);
			 c10reviews.add(roc5);
			 
			 List<ReviewOfCourses> c12reviews =new LinkedList<ReviewOfCourses>();
			 c12reviews.add(roc1);
			 c12reviews.add(roc3);
			 
			// Teacher and Teacher_Details are Mapped with EachOther 1-1 hence every 1 record of teacher will association with 1 record of Teacher Details
			// Teacher and Courses are Mapped with EachOther 1-M hence every 1 record of teacher will association with Multiple record of Courses 
			// Courses and Reviews are Mapped with EachOther 1-M hence every 1 record of Courses will association with Multiple record of Reviews 			

			// associate the Objects of Teacher and Teacher_Details with Each other
			 t1.setDetail_id(td1);
			 t2.setDetail_id(td2);
			 t3.setDetail_id(td3);
			 t4.setDetail_id(td4);
			
			 // associate the Objects of Teacher and Courses with Each other	 
			 t1.setCourse_id(t1Courses);
			 t2.setCourse_id(t2Courses);
			 t3.setCourse_id(t3Courses);
			 t4.setCourse_id(t4Courses);
			 
			// associate the Objects of Courses and Reviews with Each other	 	
			 c10.setReview_id(c10reviews);
			 c12.setReview_id(c12reviews);
			 
			// Saving Entries to Make Entry of Records
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(t4);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);
			session.save(c6);
			session.save(c7);
			session.save(c8);
			session.save(c9);
			session.save(c10);
			session.save(c11);
			session.save(c12);
						
			// Start the Transaction
			ts.commit();

		} 
		catch (Exception e) {
			System.out.println("Error in Records");
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
