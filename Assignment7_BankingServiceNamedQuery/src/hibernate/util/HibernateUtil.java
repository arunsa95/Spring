package hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * Hibernate Utility used to configure Hibernate's Session Factory and retrieve
 * it.
 */
public class HibernateUtil {

	private static EntityManager em;

	static {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankingService");
	        em = emf.createEntityManager();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			// ---- ---- --- --- --- ---------- -- -- ----- -- ---------
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEm() {
		return em;
	}


}