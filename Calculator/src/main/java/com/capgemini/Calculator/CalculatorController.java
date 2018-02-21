package com.capgemini.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CalculatorController {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String homepage()
	{
		return "home";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String calculate(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{	
		String uri = "http://localhost:8078/add/"+fno+"/"+sno;
		
		
		int result = restTemplate.getForObject(uri, Integer.class);
		int res = fno + sno;
		model.put("res", res);
		
		return "home";
		
	}
	@RequestMapping(value="/sub",method=RequestMethod.POST)
	public String calculateSub(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno - sno;
		model.put("res", res);
		return "home";
		
	}
	@RequestMapping(value="/div",method=RequestMethod.POST)
	public String calculateDiv(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno / sno;
		model.put("res", res);
		return "home";
		
	}
	@RequestMapping(value="/mul",method=RequestMethod.POST)
	public String calculateMul(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno * sno;
		model.put("res", res);
		return "home";
		
	}
	
}
