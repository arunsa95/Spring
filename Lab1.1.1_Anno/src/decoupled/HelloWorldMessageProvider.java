package decoupled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
	@Value("sorry ")
	String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
