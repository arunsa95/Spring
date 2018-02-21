package courses.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import courses.hibernate.interceptor.LoggerInterceptor;

/**
 * Hibernate Utility used to configure Hibernate's Session Factory and retrieve
 * it.
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			// ------ --- -------------- ---- -----------------
			sessionFactory = new Configuration().setInterceptor(new LoggerInterceptor())
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			// ---- ---- --- --- --- ---------- -- -- ----- -- ---------
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get the configured session factory
	 * 
	 * @return session factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}