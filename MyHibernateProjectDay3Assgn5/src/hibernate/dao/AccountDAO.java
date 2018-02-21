package hibernate.dao;

import hibernate.vo.Account;

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
		try {
			em.getTransaction().begin();

			em.persist(account);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// em.close();
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

		em.getTransaction().begin();
		Account account = (Account) em.find(Account.class, accountId);
		em.getTransaction().commit();
		return account;
	}

	public void updateBal(Account account) {

		em.getTransaction().begin();
		// Account account = (Account) em.find(Account.class, accountId);
		em.merge(account);
		em.getTransaction().commit();

	}

	public void updateBalance(long accountId, double newbalance) {

		em.getTransaction().begin();
		Account account = (Account) em.find(Account.class, accountId);
		account.setBalance(newbalance);
		em.getTransaction().commit();

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
