import hibernate.service.AccountService;
import hibernate.vo.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	

	public static void main(String arg[]) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Account5");
		

		AccountService ac = new AccountService();
		Account ac1 = new Account();
		ac1.setAccountId(1234);
		ac1.setAccountType("Saving");
		ac1.setBalance(30000);
		ac.saveOrUpdateAccount(ac1);

		Account ac2 = ac.getAccount(1234);
		System.out.println("Balance =" + ac2.getBalance());

		
		  //ac.deleteAccount(1234);
		 
		 //ac.updateBalance(1234, 50000);
		
		  //ac.deleteAccount((Account)ac.getAccount(1234));
		 

	}

}
