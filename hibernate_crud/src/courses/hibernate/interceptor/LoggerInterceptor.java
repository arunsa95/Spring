/**
 * 
 */
package courses.hibernate.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class LoggerInterceptor extends EmptyInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8085585998319812015L;

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		System.out.println("Saving the persistent Object " + entity.getClass()
				+ " with Id " + id);
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
}
