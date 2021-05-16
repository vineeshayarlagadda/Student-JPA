package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainClassStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Student s= new Student();
		s.setId(222);
		s.setName("Vineesha");
		s.setAge(20);
		s.setMarks(90);
		
		Course course = new Course("Python","JNTUH");
		s.setTechnicalCourse(course);
		
		Course nontechnicalcourse = new Course("Web development","Coursera");
		s.setNontechnical_course(nontechnicalcourse);
		
		
		Certificate c1 = new Certificate("Java basics","Java","SimpliLearn");
		Certificate c2 = new Certificate("Badminton gold medal","Shuttle Badminton","Games_Event");
		Certificate c3 = new Certificate("Python Basics","Python for everybody","Hackerrank");
		Certificate c4 = new Certificate("Foreign language","French","Coursera");
		
		Set<Certificate> cerSet = new HashSet<Certificate>();
		cerSet.add(c1);
		cerSet.add(c2);
		cerSet.add(c3);
		s.setCertificate(cerSet);
		
		// ------------ One To One

				Laptop l = new Laptop(101,"Lenovo");
				s.setLaptop(l);
				
        // ----------  One to Many Entry -----------
				
				com.capg.jpa.p1.Courses course1 = new com.capg.jpa.p1.Courses("java");
				com.capg.jpa.p1.Courses course2 = new com.capg.jpa.p1.Courses("spring");
				com.capg.jpa.p1.Courses course3 = new com.capg.jpa.p1.Courses("jpa");
				
				List<com.capg.jpa.p1.Courses> coursesList = Arrays.asList(course1,course2,course3);  // stream session
				
				s.setCourses(coursesList);		
		
				
		//------------------------
				Examination e1 = new InternalExam("SSP",24,17,70);
				Examination e2 = new ExternalExam("SSP",100,25,65);
				
				
				List<Examination> examList = Arrays.asList(e1,e2);
				s.setExamList(examList);
				
				
		session.save(s);  // insert into Account .....
//		System.out.println(s);
		System.out.println("  -->> Data Saved ..");
		
		//------------getDetails--------//
		/*s = (Student)session.get(Student.class,111);
		  // 
			System.out.println(s);*/
		//--------------Update-------------//
			/*s = (Student)session.load(Student.class,111);
		    s.setName("Vins");
		    session.saveOrUpdate(s);*/
		//-------------Delete-----------//
		/*s = (Student)session.load(Student.class,1);
		session.delete(s);*/
		t.commit();
		
		
		session.close();
		System.out.println("----Done----");

	}

}