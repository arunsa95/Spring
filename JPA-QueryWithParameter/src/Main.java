import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] a) throws Exception {
  //  JPAUtil util = new JPAUtil();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
    EntityManager em = emf.createEntityManager();
    ProfessorService service = new ProfessorService(em);

    em.getTransaction().begin();

    Professor emp1 = service.createProfessor(1, "Vivek", 100);
    Professor emp2 = service.createProfessor(2, "Raghvan", 100);

    Integer id = 0;

    
    Collection<Professor> lst= service.findAllProfessors();
    
    for (Professor acc : lst ) {
    	System.out.println(acc.getName());
    	
    }
    
    
    Professor p1=service.findProfessor("Vivek");
    System.out.println("Salary of Vivek is" + p1.getSalary());
    
    
    /*
   
    Collection expired = em.createQuery("SELECT u FROM Professor u WHERE u.id > ?1").setParameter(1,
        id).getResultList();
    for (Iterator i = expired.iterator(); i.hasNext();) {
      Professor u = (Professor) i.next();
      System.out.println("Expiring password for " + u.getName());
    }

    for (Object o : em.createQuery("SELECT u FROM Professor u").getResultList()) {
      System.out.println(o);
    }

    util.checkData("select * from Professor");
    
      * 
     */

    em.getTransaction().commit();
    em.close();
    emf.close();
  }
}