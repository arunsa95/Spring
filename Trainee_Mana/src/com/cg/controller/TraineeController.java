package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.beans.Login;
import com.cg.beans.Trainee;
import com.cg.exception.TraineeException;
import com.cg.service.ITraineeService;

/**
 * @author aruravic
 *
 */
@Controller
public class TraineeController {

	@Autowired
	private ITraineeService traineeService;

	public ITraineeService getTraineeService() {
		return traineeService;
	}

	public void setTraineeService(ITraineeService traineeService) {
		this.traineeService = traineeService;
	}

	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "operation";
	}

	// LOGIN Operation

	@RequestMapping("/showLoginPage")
	public ModelAndView showLoginPage() {

		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new Login());
		return mv;
	}

	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("login") @Valid Login login,
			BindingResult result) throws TraineeException {
		ModelAndView mv = null;

		if (!result.hasErrors()) {
			boolean flag = traineeService.checkLogin(login);

			if (flag == true)
				mv = new ModelAndView("operation");

		} else {
			mv = new ModelAndView("login");
			mv.addObject("login", login);
		}

		return mv;

	}

	// ADD Trainee Operation

	@RequestMapping("/showAddTraineeForm")
	public ModelAndView showAddTrainee() {
		ModelAndView mv = new ModelAndView("AddTrainee");
		Trainee trainee = new Trainee();
		// Location location = new Location();
		// List<Location> locationList = traineeService.getLocationList();
		// mv.addObject("locationList", locationList);
		mv.addObject("add", trainee);
		return mv;

	}

	@RequestMapping("/AddTrainee")
	public ModelAndView addTrainee(
			@ModelAttribute("add") @Valid Trainee trainee, BindingResult result) {

		ModelAndView mv = new ModelAndView();
		if (!result.hasErrors()) {
			trainee = traineeService.addTrainee(trainee);

			mv = new ModelAndView("operation");

		} else {
			mv.setViewName("AddTrainee");
			// List<Location> locationList = traineeService.getLocationList();
			// mv.addObject("locationList", locationList);
			mv.addObject("add", trainee);
		}

		return mv;
	}

	// Delete Trainee Operation

	@RequestMapping("/showDeleteTraineeForm")
	public ModelAndView showDeleteTrainee() {

		Trainee trainee = new Trainee();

		ModelAndView mv = new ModelAndView("DeleteTrainee");
		mv.addObject("trainee", trainee);
		mv.addObject("isFirst", true);
		return mv;

	}

	@RequestMapping("/DelTrainee")
	public ModelAndView delTrainee(@ModelAttribute("trainee") Trainee trainee) {
		ModelAndView mv = new ModelAndView();

		Trainee bean = new Trainee();
		bean = traineeService.getTraineeDetails(trainee.getTraineeId());

		// mv.setViewName("oDeleteTrainee");

		if (bean != null) {
			mv.setViewName("DeleteTrainee");
			mv.addObject("bean", bean);
			mv.addObject("isFirst", false);
		} else {
			mv.setViewName("error");
			mv.addObject("msg",
					"Trainee with Trainee Id:" + trainee.getTraineeId()
							+ "Not found");
		}

		return mv;

	}

	@RequestMapping("/oDeleteTrainee")
	public ModelAndView deleteTrainee(@ModelAttribute("bean") Trainee trainee) {

		ModelAndView mv = new ModelAndView("operation");
		// System.out.println(trainee);

		traineeService.deleteTraineeDetails(trainee.getTraineeId());

		return mv;

	}

	// Modify Trainee Operation
	@RequestMapping("/showModifyTraineeForm")
	public ModelAndView showModifyTrainee() {

		Trainee trainee = new Trainee();

		ModelAndView mv = new ModelAndView("ModifyTrainee");
		mv.addObject("trainee", trainee);
		mv.addObject("isFirst", true);
		return mv;

	}

	@RequestMapping("/ModifyTrainee")
	public ModelAndView modifyTrainee(@ModelAttribute("trainee") Trainee trainee) {

		ModelAndView mv = new ModelAndView();
		Trainee bean = new Trainee();
		bean = traineeService.getTraineeDetails(trainee.getTraineeId());
		if (bean != null) {
			mv.setViewName("ModifyTrainee");
			mv.addObject("bean", bean);
			mv.addObject("isFirst", false);
		} else {
			mv.setViewName("error");
			mv.addObject("msg",
					"Trainee with Trainee Id:" + trainee.getTraineeId()
							+ "Not found");
		}

		return mv;

	}

	@RequestMapping(value = "/oModifyTrainee")
	public ModelAndView modify(@ModelAttribute("bean") Trainee trainee) {

		ModelAndView mv = new ModelAndView("operation");
		// System.out.println(trainee);
		traineeService.modifyTraineeDetails(trainee);

		return mv;

	}

	// Retrieve Trainee Operation

	@RequestMapping("/showRetrieveTraineeForm")
	public ModelAndView showRetrieveTrainee() {

		Trainee trainee = new Trainee();
		ModelAndView mv = new ModelAndView("RetrieveTrainee");
		mv.addObject("retrieve", trainee);
		mv.addObject("isFirst", "true");

		return mv;

	}

	@RequestMapping("/RetrieveTrainee")
	public ModelAndView retrieveTrainee(
			@ModelAttribute("retrieve") @Valid Trainee trainee,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();

		Trainee tBean = new Trainee();
		tBean = traineeService.getTraineeDetails(trainee.getTraineeId());

		if (tBean != null) {
			mv.setViewName("RetrieveTrainee");
			mv.addObject("tBean", tBean);
		} else {

			mv.setViewName("error");
			mv.addObject("msg",
					"Trainee with Trainee Id:" + trainee.getTraineeId()
							+ "Not found");
		}

		return mv;

	}

	@RequestMapping("/showRetrieveAllTraineeForm")
	public ModelAndView retrieveAllTrainee() {

		ModelAndView mv = new ModelAndView();
		List<Trainee> list = traineeService.getAllTraineeDetails();
		if (list.isEmpty()) {
			String msg = "There are no Trainee";
			mv.setViewName("error");
			mv.addObject("msg", msg);
		} else {
			mv.setViewName("RetrieveAll");
			// Add the attribute to the model
			mv.addObject("list", list);
		}
		return mv;

	}

	@ExceptionHandler(TraineeException.class)
	public ModelAndView throwError(TraineeException e) {
		return new ModelAndView("loginError", "msg", e.getMessage());
	}

}
