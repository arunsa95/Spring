/**
 * 
 */
package com.cg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aruravic
 *
 */
@Controller
@RequestMapping(value = "/")
public class MyController {

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public String greet(Model model) {

		model.addAttribute("message", "jksefkjshfk");

		return "home";
	}

	@RequestMapping("/param")
	public String printHello5(Map<String, String> model,
			@RequestParam("message") String message) {
		model.put("message", "From map with param message " + message);
		return "index";
	}

}
