import hibernate.service.AccountService;
import hibernate.util.HibernateUtil;
import hibernate.vo.Account;

import java.util.List;

import hibernate.vo.Transaction;

public class Client {

	public static void main(String arg[]) {

		AccountService ac = new AccountService();
		AccountService t = new AccountService();
		
		
		Transaction t1 = new Transaction();
		t1.setTransactionId(123);
		t1.setTransactionType("withdrawal");
		t.saveOrUpdateTransaction(t1);
		
		
		Account ac1 = new Account();
		ac1.setAccountId(1234);
		ac1.setAccountType("Saving");
		ac1.setBalance(8000);
		ac.saveOrUpdateAccount(ac1);

		Account ac2 = ac.getAccount(1234);
		System.out.println("Balance =S" + ac2.getBalance());

		/*
		 * ac.deleteAccount(1234);
		 */
		//ac.updateBalance(1234, 2000);
		/*
		 * ac.deleteAccount((Account)ac.getAccount(1));
		 */

		/* using filter to fetch data */
		List<Account> alist = ac.getAcctsWithBalance(4000);
		for (Account account : alist) {
			System.out.println(account.getAccountId());
			System.out.println(account.getBalance());
		}

		HibernateUtil.getSessionFactory().close();

	}

}
