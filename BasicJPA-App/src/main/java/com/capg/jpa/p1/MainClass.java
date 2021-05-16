package com.capg.jpa.p1;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capg.jpa.p3.Insurance;
import com.capg.jpa.p3.LifeInsurance;
import com.capg.jpa.p3.MedicalInsurance;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Account a = new Account();
		//---------Insert--------------//
		a.setAccountHolderName("Vineesha");
		a.setBalance(5000);
		a.setOpenningDate(LocalDate.now());
		Address address = new Address(400,"Hyderabad","Telangana");
		a.setAddress(address);
		
		Address officeaddress = new Address(41,"Nizampet","Telangana");
		a.setOffice_address(officeaddress);
		  // insert into Account .....
		
		Policy p1 = new Policy("a1");
		Policy p2 = new Policy("a2");
		Policy p3 = new Policy("a3");
		
		List<Policy> policylist = Arrays.asList(p1,p2,p3);
		
		a.setPolicies(policylist);
		
 // ---------- Adding Insurance Inheritance Mapping ----------
		
		Insurance i1 = new LifeInsurance(16000, a.getAccountHolderName(), LocalDate.now(), 6500000, 45);
		Insurance i2 = new MedicalInsurance(7800, a.getAccountHolderName(), LocalDate.now(), 700000, 160000);
		
		
		List<Insurance> insuranceList = Arrays.asList(i1,i2);
		a.setInsuranceList(insuranceList);
		
		session.save(a);
		
		System.out.println("  -->> Data Saved ..");
		
		// HQL or JPQL List<?>
		//----------Get Details By Id------------//
					/*a = (Account)session.get(Account.class,1);
				  // 
					System.out.println(a);*/
		//-----------Update the details------------//
		  /*a = (Account)session.load(Account.class,101);
		  a.setAccountHolderName("Vineesha");
		  //session.update(a);
		  session.saveOrUpdate(a);
		  System.out.println(a);*/
		
		//-----------Delete the details-----------//
		  
		/*a = (Account)session.load(Account.class,1);
		session.delete(a);*/
		 
		t.commit();
		
		
		session.close();
		System.out.println("----Done----");

	}

}