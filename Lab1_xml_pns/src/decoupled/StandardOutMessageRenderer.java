package decoupled;

import java.util.ArrayList;
import java.util.List;

//@Service
public class StandardOutMessageRenderer implements MessageRenderer {

	// @Resource(name = "myList")
	List<String> items = new ArrayList<>();

	public StandardOutMessageRenderer() {
		System.out.println("renderer default constructor");
	}

	public List<String> getItems() {
		return items;
	}

	public StandardOutMessageRenderer(MessageProvider messageProvider) {
		System.out.println("renderer param constructor");
		this.messageProvider = messageProvider;
	}

	/**
	 * Instead of the @Autowired, @Qualifier("fileprovider") you can also use
	 * the @Resource(name="messageProvider") to achieve the same result. The @Resource
	 * is one of the annotations in the JSR-250 standard that defines a common
	 * set of Java annotations for use on both JSE and JEE platforms. Different
	 * from @Autowired, the @Resource annotation supports the name parameter for
	 * more fine-grained DI requirements.
	 */

	private MessageProvider messageProvider = null;

	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:"
							+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	// @Resource(name="provider")
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public MessageProvider getMessageProvider() {
		System.out.println("get message renderer");
		return this.messageProvider;
	}

}
