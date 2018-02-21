package hibernate.dao;

import hibernate.vo.Account;
import hibernate.vo.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	private static EntityManager em;
	{
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Account5");
		em = emf.createEntityManager();
	}

	public void saveOrUpdateAccount(Account account) {
		Transaction transaction = new Transaction();

		try {
			em.getTransaction().begin();
			em.persist(account);

			transaction.setAccount(account);
			em.persist(transaction);
			// session.save(account);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
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

		Account account = new Account();
		try {
			em.getTransaction().begin();
			account = (Account) em.find(Account.class, accountId);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return account;

	}

	public void updateBalance(long accountId, double newbalance) {
		Account account = new Account();

		try {
			em.getTransaction().begin();
			account = em.find(Account.class, accountId);
			account.setBalance(newbalance);
			em.getTransaction().commit();
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	public void depositAmount(long accountId, double amount) {
		Account account = new Account();
		Transaction transaction = new Transaction();
		try {
			em.getTransaction().begin();
			account = (Account) em.find(Account.class, accountId);
			account.setBalance(account.getBalance() + amount);

			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("DEPOSIT");
			transaction.setAmount(amount);
			em.persist(transaction);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	public void withdrawAmount(long accountId, double amount) {
		Account account = new Account();
		Transaction transaction = new Transaction();

		try {
			em.getTransaction().begin();
			account = (Account) em.find(Account.class, accountId);
			account.setBalance(account.getBalance() - amount);

			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("WITHDRAW");
			transaction.setAmount(amount);
			em.persist(transaction);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	public List<Account> minBalance(double amt) {

		List<Account> accountList = null;
		try {

			/*
			 * Filter filter =
			 * 
			 * ((Session) em).enableFilter("balanceFilter");
			 * filter.setParameter("balanceParam", amt);
			 */
			em.getTransaction().begin();
			accountList = em.createQuery("From Account").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
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

		em.getTransaction().begin();
		em.remove(account);

		em.getTransaction().commit();
	}

	public void deleteAccount(long accountId) {
		Account ac3 = getAccount(accountId);

		if (ac3 != null) {
			em.getTransaction().begin();
			em.remove(ac3);
			em.getTransaction().commit();
		}
	}

}
