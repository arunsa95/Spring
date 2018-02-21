/**
 * 
 */
package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.beans.Client;
import com.cg.exception.BankException;
import com.cg.service.ICustomerService;

/**
 * @author aruravic
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping("/homePageForm")
	public ModelAndView showAddComplaintForm() {
		ModelAndView mv = new ModelAndView("homePage");
		Client client = new Client();

		mv.addObject("homepage", client);
		return mv;

	}

	@RequestMapping("/homePage")
	public ModelAndView showAddComplaint(
			@ModelAttribute("homepage") @Valid Client client,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();

		if (!result.hasErrors()) {

			Client tBean = customerService.addComplaintDetails(client);

			mv.addObject("tBean", tBean.getComplaintId());
			mv.setViewName("success");

		} else {
			mv.setViewName("homePage");
			mv.addObject("homepage", client);
		}

		return mv;

	}

	@RequestMapping("/showRetrieveComplaintForm")
	public ModelAndView showRetrieveComplaintForm() {

		Client client = new Client();
		ModelAndView mv = new ModelAndView("RetrieveComplaint");
		mv.addObject("showstatus", client);
		mv.addObject("isFirst", "true");

		return mv;

	}

	@RequestMapping("/RetrieveComplaint")
	public ModelAndView retrieveComplaint(
			@ModelAttribute("showstatus") @Valid Client client,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();

		Client tBean = new Client();
		tBean = customerService.getComplaintDetails(client.getComplaintId());

		if (tBean != null) {
			mv.setViewName("RetrieveComplaint");
			mv.addObject("tBean", tBean);
		} else {

			mv.setViewName("error");
			mv.addObject("msg",
					"Complaint with Complaint Id:" + client.getComplaintId()
							+ "Not found");
		}

		return mv;

	}

	@ExceptionHandler(BankException.class)
	public ModelAndView throwError(BankException e) {
		return new ModelAndView("error", "msg", e.getMessage());
	}

}
