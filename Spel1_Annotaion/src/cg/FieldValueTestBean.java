/**
 * 
 */
package cg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author aruravic
 *
 */
@Component
public class FieldValueTestBean {
	//@Value("#{systemProperties['user.region']}")
	@Value("#{systemProperties['user.region'] ?: 'None'}")

	private String defaultLocale;

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

}
