import org.hibernate.Session;

import courses.hibernate.service.AccountService;
import courses.hibernate.util.HibernateUtil;
import courses.hibernate.vo.Account;

public class JavaMain {

	public static void main(String arg[]) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		AccountService ac = new AccountService();
		Account ac1 = new Account();
		ac1.setAccountId(1234);
		ac1.setAccountType("Saving");
		ac1.setBalance(30000);
		ac.saveOrUpdateAccount(ac1);

		// session.delete(ac1);

		session.getTransaction().commit();

		HibernateUtil.getSessionFactory().close();

	}

}
