/**
 * 
 */
package cg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aruravic
 *
 */
@Controller
public class MyController {
	@RequestMapping("/user")
	public String setuser(@RequestParam("id") String id,
			@RequestParam("name") String name, Model model) {
		User user = new User(id, name);
		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping("/user1")
	public String setuser1(@ModelAttribute User user, Model model) {
		System.out.println("user " + user);
		// User user = new User(id, name);
		model.addAttribute("user", user);
		return "user";
	}

}
