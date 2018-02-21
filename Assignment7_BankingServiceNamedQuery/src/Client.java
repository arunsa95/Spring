import java.util.List;

import hibernate.service.AccountService;
import hibernate.util.HibernateUtil;
import hibernate.vo.Account;
import hibernate.vo.Transaction;

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
	 
		
		Account account=new Account();
		ac.depositAmount(1234, 1111);
		ac.withdrawAmount(1235, 999);
		
		System.out.println("Current Balance of account id 1234 is: "+ac.getAccount(1234).getBalance());
		System.out.println("Current Balance of account id 1235 is: "+ac.getAccount(1235).getBalance());
		account=ac.getAccount(1235);
		
		System.out.println("Geting transactions from account id 1234............");
		List<Transaction> list = ac.getTransaction(1234L);
		for(Transaction trans : list){
			System.out.println(trans);
		}
		//ac.deleteAccount(1235L);
		HibernateUtil.getEm().close();
		
	}

}
