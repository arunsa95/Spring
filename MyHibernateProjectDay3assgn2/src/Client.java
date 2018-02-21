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
		
		Account ac2 = new Account();
		ac2.setAccountId(1235);
		ac2.setAccountType("Saving");
		ac2.setBalance(20000);
		ac.saveOrUpdateAccount(ac2);
	 
		/*
		 Account ac3=ac.getAccount(1234);
		 System.out.println("Balance =" + ac2.getBalance()); 
		 
		 List<Account> accountList = ac.minBalance(9999);
		 for(Account act:accountList){
			 System.out.println(act);
		 }
		 ac.deleteAccount(1234);
	 	ac.updateBalance(1234, 50000);
		ac.deleteAccount((Account)ac.getAccount(1));
		*/
		Account account=new Account();
		ac.depositAmount(1234, 1000);
		ac.withdrawAmount(1235, 900);
		
		System.out.println("Current Balance of account id 1234 is: "+ac.getAccount(1234).getBalance());
		System.out.println("Current Balance of account id 1235 is: "+ac.getAccount(1235).getBalance());
		HibernateUtil.getSessionFactory().close();
		
	}

}
