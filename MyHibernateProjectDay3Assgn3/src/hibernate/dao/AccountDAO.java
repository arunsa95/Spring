package hibernate.dao;

import hibernate.util.HibernateUtil;
import hibernate.vo.Account;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Data Access Object for Account
 */
public class AccountDAO {

	/**
	 * Create a new account or update an existing one
	 * 
	 * @param account
	 *            account to be persisted
	 */
	
	
	
		SessionFactory factory = new AnnotationConfiguration().configure().
		// addPackage("com.xyz") //add package if used.
				addAnnotatedClass(Account.class).buildSessionFactory();
	 

	public void saveOrUpdateAccount(Account account) {
		// Session session = factory.openSession();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			 //session.saveOrUpdate(account);
			session.save(account);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			//session.close();
		}
	}

	/**
	 * Retrieve an account from the data store
	 * 
	 * @param accountId
	 *            identifier of the account to be retrieved
	 * @return account represented by the identifier provided
	 */
	public Account getAccount(long accountId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = (Account) session.get(Account.class, accountId);
		session.getTransaction().commit();
		return account;
	}

	public void updateBalance(long accountId, double newbalance) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = (Account) session.get(Account.class, accountId);
		account.setBalance(newbalance);
		session.getTransaction().commit();

	}

	/**
	 * Delete account from data store
	 * 
	 * @param account
	 *            account to be deleted
	 */
	public void deleteAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(account);
		session.getTransaction().commit();
	}

	public void deleteAccount(long accountId) {
		Account ac3 = getAccount(accountId);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if (ac3 != null) {
			session.beginTransaction();
			session.delete(ac3);
			session.getTransaction().commit();
		}
	}

}
