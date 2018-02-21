package decoupled;

public class HelloWorldMessageProvider implements MessageProvider {
	String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
