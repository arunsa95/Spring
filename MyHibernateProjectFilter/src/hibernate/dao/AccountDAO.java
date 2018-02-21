package hibernate.dao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import hibernate.vo.Account;

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
	public void saveOrUpdateAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(account);
		//session.save(account);
		session.getTransaction().commit();
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

	public void updateBalance(long accountId,double newbalance )
	{
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
		Account ac3=getAccount(accountId);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(ac3 !=null) {
		session.beginTransaction();
		session.delete(ac3);
		session.getTransaction().commit();
		}
	}
	
	public List<Account> getAccountfilter(double amt){
		List<Account> list = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
			Filter filter = session.enableFilter("balanceFilter");
			filter.setParameter("amount", amt);
 
			list = session.createCriteria(Account.class).list();
			 session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			 
		}
		return list;
 
	}
	
}
