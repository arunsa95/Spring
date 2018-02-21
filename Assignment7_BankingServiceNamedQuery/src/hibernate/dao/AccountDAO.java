package hibernate.dao;

import hibernate.util.HibernateUtil;
import hibernate.vo.Account;
import hibernate.vo.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;


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
		HibernateUtil.getEm().getTransaction().begin();
		try{

			HibernateUtil.getEm().persist(account);
			HibernateUtil.getEm().getTransaction().commit();
		}catch(HibernateException e)
		{
			if(HibernateUtil.getEm().getTransaction().isActive())
			{
				HibernateUtil.getEm().getTransaction().rollback();
			}

		}finally
		{
			//HibernateUtil.getEm().close();
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
		HibernateUtil.getEm().getTransaction().begin();
		Account account=new Account();
		try {
			account=HibernateUtil.getEm().find(Account.class, accountId);
			HibernateUtil.getEm().getTransaction().commit();
		} catch(HibernateException e)
		{
			if(HibernateUtil.getEm().getTransaction().isActive())
			{
				HibernateUtil.getEm().getTransaction().rollback();
			}

		}finally
		{
			//HibernateUtil.getEm().close();
		}
		return account;

	}

	public void updateBalance(long accountId,double newbalance )
	{
		HibernateUtil.getEm().getTransaction().begin();
		Account account=new Account();
		try {
			account=HibernateUtil.getEm().find(Account.class, accountId);
			account.setBalance(newbalance);
			HibernateUtil.getEm().getTransaction().commit();
		} catch(HibernateException e)
		{
			if(HibernateUtil.getEm().getTransaction().isActive())
			{
				HibernateUtil.getEm().getTransaction().rollback();
			}

		}finally
		{
			//HibernateUtil.getEm().close();
		}

	}

	public void depositAmount(long accountId,double amount )
	{
		HibernateUtil.getEm().getTransaction().begin();
		Account account=new Account();
		try {
			account=HibernateUtil.getEm().find(Account.class, accountId);
			account.setBalance(account.getBalance()+amount);
			Transaction transaction=new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("DEPOSIT");
			transaction.setAmount(amount);
			HibernateUtil.getEm().persist(transaction);
			HibernateUtil.getEm().getTransaction().commit();
		} catch (HibernateException e) {
			if(HibernateUtil.getEm().getTransaction().isActive())
			{
				HibernateUtil.getEm().getTransaction().rollback();
			}
		}
	}

	public void withdrawAmount(long accountId,double amount )
	{
		HibernateUtil.getEm().getTransaction().begin();
		Account account=new Account();
		try {
			account=HibernateUtil.getEm().find(Account.class, accountId);
			account.setBalance(account.getBalance()+amount);
			Transaction transaction=new Transaction();
			transaction.setAccount(account);
			transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
			transaction.setTransactionType("DEPOSIT");
			transaction.setAmount(amount);
			HibernateUtil.getEm().persist(transaction);
			HibernateUtil.getEm().getTransaction().commit();
		} catch (HibernateException e) {
			if(HibernateUtil.getEm().getTransaction().isActive())
			{
				HibernateUtil.getEm().getTransaction().rollback();
			}
		}

	}


	/**
	 * Delete account from data store
	 * 
	 * @param account
	 *            account to be deleted
	 */
	public void deleteAccount(Long accountId) {
		HibernateUtil.getEm().getTransaction().begin();
		Account account = HibernateUtil.getEm().find(Account.class, accountId);
		HibernateUtil.getEm().remove(account);
		HibernateUtil.getEm().getTransaction().commit();
	}
	public List<Transaction> getTransaction(Long accountId){
		List<Transaction> transList = new ArrayList<Transaction>();
		EntityManager em = HibernateUtil.getEm();
		em.getTransaction().begin();
		try {
			transList = em.createNamedQuery("findTransactions").setParameter("account", accountId).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		em.getTransaction().commit();
		return transList;
	}



}
