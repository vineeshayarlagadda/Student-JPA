package com.capg.jpa.p2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
public static void main(String[] args) {
		
		MainApp obj = new MainApp();
		
		Configuration cfg = new Configuration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		Courses c1 = obj.getCourses();
		Courses c2 = obj.getCourses();
		Courses c3 = obj.getCourses();
		
		Student1 s1 = obj.getStudents(); 
		Student1 s2 = obj.getStudents(); 
		
		///----- Creating collections for  Hotels to App1 ----
		
		List<Student1> student_list1 = new ArrayList<Student1>();
		student_list1.add(s1);
		student_list1.add(s2);
		
		
		List<Student1> student_list2 = new ArrayList<Student1>();
		student_list2.add(s1);
        
		
		List<Student1> student_list3 = new ArrayList<Student1>();
		student_list3.add(s1);
		student_list3.add(s2);
		
		// -------- Creating collections for  Courses ---------
		
		List<Courses> course_list1 = new ArrayList<Courses>();
		course_list1.add(c1);
		course_list1.add(c2);
		course_list1.add(c3);
		
		List<Courses> course_list2 = new ArrayList<Courses>();
		course_list2.add(c1);
		course_list2.add(c2);
	
		
		
		// ------------ Adding Collection of Studnets to Courses ----- 
		
	    c1.setStudents(student_list1);
		c2.setStudents(student_list2);
		c3.setStudents(student_list3);
				
		// ------------ Adding Collection of Courses to Students ----- 
				
		s1.setCourse(course_list1);
		s2.setCourse(course_list1);
		
				
				
		Transaction t = session.beginTransaction();
		
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		session.save(s1);
		session.save(s2);
		
		
		t.commit();
		
		System.out.println(" Data Saved");
		
	}
	
	public Courses getCourses()
	{
		Courses c = new Courses();
		System.out.println("Enter Course Id ");
		c.setCourseId(new Scanner(System.in).nextInt());
		
		System.out.println("Enter Course Name ");
		c.setCoursename(new Scanner(System.in).nextLine());
		
		return c;
	}
	
	public Student1 getStudents()
	{
		Student1 s = new Student1();
		System.out.println("Enter Student Name ");
		s.setName(new Scanner(System.in).nextLine());
		System.out.println("Enter Student Age ");
		s.setAge(new Scanner(System.in).nextInt());
		System.out.println("Enter Student Marks ");
		s.setAge(new Scanner(System.in).nextInt());
		return s;
	}

}
