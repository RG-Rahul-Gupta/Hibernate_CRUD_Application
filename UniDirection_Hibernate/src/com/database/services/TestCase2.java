package com.database.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.database.entity.Teacher;

public class TestCase2 {
	
	public static void main(String[] args) {
		
		System.out.println("Connecting to database");
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		List<Teacher> teacher = null;
		
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
		          .addAnnotatedClass(com.database.entity.Teacher.class)
			      .buildSessionFactory();
		System.out.println("Created");
		
		//Creating of Objects of Class Teachers and Calling Constructors to Add Data to Tables 
		Teacher t1 = new Teacher("Ram","Sundar","RamSundar@xyz.com");
		Teacher t2 = new Teacher("Shyam","Babu","ShyamBabu@xyz.com");
		Teacher t3 = new Teacher("Seetal","Suri","SeetalSuri@xyz.com");
		Teacher t4 = new Teacher("Aradhya","Venu","AradhyaVenu@xyz.com");
		
		
		try {
		
		//Starting the Session for the function to be executed
			session = factory.getCurrentSession();
	    
	    //Starting the Transaction for activity to be executed 
			tx = session.beginTransaction();
		
		//Saving the Objects of Class to for Entry of Records into the Table 	
//			session.save(t1);
//			session.save(t2);
//			session.save(t3);
//			session.save(t4);
			
		//Using get Method of Session to get a single record from the Table 	
//			Teacher teacher= session.get(Teacher.class, 1);
// 			System.out.println("teacher details"+teacher);

		//Update the Values of the Table using Java for Single Record
//			Teacher temp_teacher = session.get(Teacher.class, 2);
//  		System.out.println(temp_teacher);
//	        System.out.println("Now we will be updating the Records");
//			temp_teacher.setF_Name("Ravi");
//	    	session.update(temp_teacher);
//	        System.out.println("Value Updated");
			
		//Update the Values of the Table for Multiple Records                                                                                                                                                                   
//			session.createQuery("UPDATE Teacher SET email='RaviBabu@gl.com' WHERE id = 2").executeUpdate();
			
		//Delete the records from the Table	
			Teacher temp_Teacher = session.get(Teacher.class, 1);
			session.delete(temp_Teacher);
		//Delete the records from the Table	
			session.createQuery("DELETE FROM Teacher WHERE id = 2").executeUpdate();	
			
		//Using Link Method of Session to get multiple record from Table ( Querying the Table )
     		teacher = session.createQuery("FROM Teacher").list();
	
			tx.commit();
		}
		catch ( Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback(); 
		}
		finally {
			session.close();
		}
		
		//Print the records obtained from Query
		for(Teacher teachers:teacher) {
			System.out.println(teachers);
		}
		
	}

}
