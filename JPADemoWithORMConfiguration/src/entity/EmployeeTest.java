package entity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {

    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
        
        createEmployee(1, "Anil", 10000);
        createEmployee(2, "Sunil", 20000);
        createEmployee(3, "Rajesh", 30000);
   
         
      
        for (Object o : em.createQuery("SELECT e FROM Employee e").getResultList()) {
          
        	Employee e= (Employee)o;
        	System.out.println(e.getEmpName() + "" +e.getEmpSalary());
          }
    }

    private static void createEmployee(int id, String name, int salary) {
        em.getTransaction().begin();
        Employee emp = new Employee(id, name, salary);
        em.merge(emp);
        em.getTransaction().commit();
    }
}
