package com.capg.jpa.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForGet {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		System.out.println("1");

		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		Student s= new Student();
		s = (Student)session.get(Student.class,222); 

		System.out.println("\n Students Info :- "+s);
		System.out.println("\n Laptop Information :- "+s.getLaptop());
		
		
		Laptop lappy = session.get(Laptop.class, s.getLaptop().getLappyid());
		
		System.out.println("\n Laptop Info :- "+lappy);
		System.out.println("\n Student Info  :- "+lappy.getStudent());
		
				
				
		t.commit();
		
	}

}
