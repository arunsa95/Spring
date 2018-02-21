package decoupled;

import org.springframework.stereotype.Component;

import decoupled.MessageProvider;

//@Component("fileprovider")

public class FileMessageProvider implements MessageProvider{

	public String getMessage() {
		// TODO Auto-generated method stub
		//filei/i0
		return "from file";
	}

}
