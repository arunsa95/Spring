import hibernate.service.AccountService;
import hibernate.util.HibernateUtil;
import hibernate.vo.Account;

public class Client {
	
	public static void main(String arg[])
	{
		
	
		AccountService ac = new AccountService();
		Account ac1 = new Account();
		ac1.setAccountId(1234);
		ac1.setAccountType("Saving");
		ac1.setBalance(30000);
		ac.saveOrUpdateAccount(ac1);
		
	 
		
		 Account ac2=ac.getAccount(1234);
		 System.out.println("Balance =" + ac2.getBalance()); 
		 
		/*
		 ac.deleteAccount(1234);
		 
		*/
		ac.updateBalance(1234, 50000);
		/*
		ac.deleteAccount((Account)ac.getAccount(1));
		*/
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
