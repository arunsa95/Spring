/**
 * 
 */
package cg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author aruravic
 *
 */
public class BeanInitializationLogger implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("After Initializing Bean" +beanName+"");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Before Initializing Bean"+beanName+"");
		return bean;
	}

}
