import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyBidirectionalMappingInJPA {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Department department1 = new Department();
		department1.setName("Q/A");

		Department department2 = new Department();
		department2.setName("HR");
		
		Employee employee1 = new Employee();
		employee1.setName("Jack");
		employee1.setSurname("Thomson");
		employee1.setTitle("QA Engineer");
		employee1.setCreated(new Date());
		employee1.setDepartment(department1);

		Employee employee2 = new Employee();
		employee2.setName("Mary");
		employee2.setSurname("Nickolson");
		employee2.setTitle("QA Engineer");
		employee2.setCreated(new Date());
		employee2.setDepartment(department2);
		
		em.persist(department1);
		em.persist(department2);
		em.persist(employee1);
		em.persist(employee2);
		
		long employeeId1 = employee1.getId();
		long employeeId2 = employee2.getId();
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		Employee dbEmployee1 =em.find(Employee.class, employeeId1);
		System.out.println("dbEmployee " + dbEmployee1);
		
		Employee dbEmployee2 =em.find(Employee.class, employeeId2);
		System.out.println("dbEmployee " + dbEmployee2);
		
		em.getTransaction().commit();
		
		em.close();
	    emf.close();

	}

}