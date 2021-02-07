/**
 * 
 */
package cg;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author aruravic
 *
 */
@Aspect
public class LoggingAspect {

	@Before("execution(public * get*() )")
	// @Before("within( com.cg.LoggingAspect.getTitle*)")
	public void advice() {
		System.out.println("Before called ");

	}

	

}
