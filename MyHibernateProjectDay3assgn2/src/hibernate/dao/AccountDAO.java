package hibernate.dao;

import hibernate.interceptor.MyInterceptor;
import hibernate.util.HibernateUtil;
import hibernate.vo.Account;
import hibernate.vo.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(account);
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			session.saveOrUpdate(transaction);
			// session.save(account);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
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
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Account account = new Account();
		try {
			session.beginTransaction();
			account = (Account) session.get(Account.class, accountId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
		return account;

	}

	public void updateBalance(long accountId, double newbalance) {
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Account account = (Account) session.get(Account.class, accountId);
			account.setBalance(newbalance);
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void depositAmount(long accountId, double amount) {
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Account account = (Account) session.get(Account.class, accountId);
			account.setBalance(account.getBalance() + amount);
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("DEPOSIT");
			transaction.setAmount(amount);
			session.save(transaction);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void withdrawAmount(long accountId, double amount) {
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Account account = (Account) session.get(Account.class, accountId);
			account.setBalance(account.getBalance() - amount);
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("WITHDRAW");
			transaction.setAmount(amount);
			session.save(transaction);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	public List<Account> minBalance(double amt) {
		MyInterceptor myInterceptor = new MyInterceptor();
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Account> accountList = null;
		try {

			Filter filter = session.enableFilter("balanceFilter");
			filter.setParameter("balanceParam", amt);
			session.beginTransaction();
			accountList = session.createQuery("From Account").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			org.hibernate.Transaction transaction = session.getTransaction();
			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
		return accountList;
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
