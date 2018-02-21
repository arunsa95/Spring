/**
 * 
 */
package xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author aruravic
 *
 */
@Component("myBean")
public class LifecycleBean2 {
	@PostConstruct
	public void setup() {
		System.out.println("setup loaded");
	}
	@PreDestroy
	public void cleanup() {
		System.out.println("cleanup loaded");
	}

}
