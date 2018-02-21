package hibernate.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1442324836844201812L;

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub
		super.afterTransactionCompletion(tx);
		System.out.println("After Transaction Completion Method");
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub
		super.beforeTransactionCompletion(tx);
		System.out.println("Before Transaction Completion Method");
	}

	@Override
	public String getEntityName(Object object) {
		// TODO Auto-generated method stub
		System.out.println("Get Entity Name Method");
		return super.getEntityName(object);
		
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		super.onDelete(entity, id, state, propertyNames, types);
		System.out.println("On Delete Method");
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		System.out.println("On Save Method");
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	

}
