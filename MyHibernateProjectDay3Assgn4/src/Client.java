import hibernate.service.AccountService;
import hibernate.vo.Account;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String arg[]) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("AccountService");

		AccountService ac = new AccountService();
		Account ac1 = new Account();
		ac1.setAccountId(1234);
		ac1.setAccountType("Saving");
		// ac1.(Date)setCreationDate(LocalDate.now());
		ac1.setBalance(30000);
		ac.saveOrUpdateAccount(ac1);

		// Account ac2 = ac.getAccount(1235);
		// SSystem.out.println("Balance =" + ac2.getBalance());

		// ac.deleteAccount(1234);

		// ac.updateBalance(1234, 50000);

		// ac.deleteAccount((Account)ac.getAccount(1234));
		emf.close();
	}

}
