package hibernate.service;


import java.util.List;

import hibernate.dao.AccountDAO;
import hibernate.vo.Account;
import hibernate.vo.Transaction;

/**
 * Service layer for Account
 */
public class AccountService {
	AccountDAO accountDAO = new AccountDAO();

	/**
	 * Create a new account or update an existing one
	 * 
	 * @param account
	 *            account to be persisted
	 */
	public void saveOrUpdateAccount(Account account) {
		accountDAO.saveOrUpdateAccount(account);
	}

	public void saveOrUpdateTransaction(Transaction transaction) {
		accountDAO.saveOrUpdateTransaction(transaction);
	}
	
	/**
	 * Retrieve an account
	 * 
	 * @param accountId
	 *            identifier of the account to be retrieved
	 * @return account represented by the identifier provided
	 */
	public Account getAccount(long accountId) {
		return accountDAO.getAccount(accountId);
	}

	
	public void updateBalance(long accountId,double newbalance )
	{
		accountDAO.updateBalance(accountId, newbalance);
	}
	
	public void deleteAccount(long accountId) {
		accountDAO.deleteAccount(accountId);
	}
	
	/**
	 * Delete account
	 * 
	 * @param account
	 *            account to be deleted
	 */
	public void deleteAccount(Account account) {
		accountDAO.deleteAccount(account);
	}
	
	public List<Account> getAcctsWithBalance(double amt) {
		List<Account> actlist= accountDAO.getAccountfilter(amt);
	    return actlist;
	}
}
