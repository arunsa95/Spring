import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
	
 public static void main(String[] args) {
 
	 Session session = HibernateUtil.getSessionFactory().openSession(); 
	 Transaction transaction = null;
	 try { 
		 transaction = session.beginTransaction(); 
		 Set<Phone> phoneNumbers = new HashSet<Phone>(); 
		 Phone p= new Phone();
		 p.setPhoneNumber("34233455");
		 p.setPhoneType("Home");
		 phoneNumbers.add(p); 
		 Phone p1= new Phone();
		 p.setPhoneNumber("342334556");
		 p.setPhoneType("Mobile");
		 phoneNumbers.add(p1); 
		 
		 Student student = new Student();
		 student.setStudentId(123L);
		 student.setStudentName("Sunil");
		 student.setStudentPhoneNumbers(phoneNumbers);
		 
		 session.save(student); 
		 transaction.commit(); 
	 } catch (HibernateException e) 
	 { 
		 transaction.rollback(); e.printStackTrace(); 
		 } 
	 finally { 
		 //session.close(); 
		 } 
	 } 
 }
