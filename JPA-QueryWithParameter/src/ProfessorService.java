import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProfessorService {
  protected EntityManager em;

  public ProfessorService(EntityManager em) {
    this.em = em;
  }

  public Professor createProfessor(int id, String name, long salary) {
    Professor emp = new Professor(id);
    emp.setName(name);
    emp.setSalary(salary);
    em.persist(emp);
    return emp;
  }

  public void removeProfessor(int id) {
    Professor emp = findProfessor(id);
    if (emp != null) {
      em.remove(emp);
    }
  }

  public Professor raiseProfessorSalary(int id, long raise) {
    Professor emp = em.find(Professor.class, id);
    if (emp != null) {
      emp.setSalary(emp.getSalary() + raise);
    }
    return emp;
  }

  public Professor findProfessor(int id) {
    return em.find(Professor.class, id);
  }

  public Collection<Professor> findAllProfessors() {
    Query query = em.createQuery("SELECT e FROM Professor e");
    return (Collection<Professor>) query.getResultList();
  }
  
  public Professor findProfessor(String empName) {
	    try {
	         Professor p1=(Professor) em.createNamedQuery("findprofessorbyname").setParameter("name",empName).getSingleResult();
	         return p1;
	    } catch (NoResultException e) {
	      return null;
	    }
	  }
  
  
}
