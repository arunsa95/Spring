/**
 * 
 */
package xml;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author aruravic
 *
 */
public class LifecycleBean2 implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterprop");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");

	}

}
