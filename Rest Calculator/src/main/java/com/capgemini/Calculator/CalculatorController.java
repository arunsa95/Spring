package com.capgemini.Calculator;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@RequestMapping("/")
	public String homepage()
	{
		return "home";
	}
	@RequestMapping(value="/add/{fno}/{sno}")
	public int calculate(@PathVariable int fno,@PathVariable int sno,ModelMap model)
	{
		int res = fno + sno;
		model.put("res", res);
		
		return res;

	}
	@RequestMapping(value="/sub/{fno}/{sno}")
	public String calculateSub(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno - sno;
		model.put("res", res);
		return "home";
		
	}
	@RequestMapping(value="/div/{fno}/{sno}")
	public String calculateDiv(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno / sno;
		model.put("res", res);
		return "home";
		
	}
	@RequestMapping(value="/mul/{fno}/{sno}")
	public String calculateMul(@RequestParam int fno,@RequestParam int sno,ModelMap model)
	{
		int res = fno * sno;
		model.put("res", res);
		return "home";
		
	}
	
}
