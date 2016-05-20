package com.abpadan.webapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.service.MechanicService;
import com.abpadan.webapp.service.UserService;

@Controller
@RequestMapping("/mechanics")
public class MechanicController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private MechanicService mechanicService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listMechanics(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Mechanic> mechanics = mechanicService.getMechanicsByUser(user);
		model.addAttribute("mechanics", mechanicService.setMechanicDeleteFlag(user, mechanics));
		return "mechanics/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMechanic() {
		return "mechanics/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("email") String email, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("phonenumber") String phoneNumber,
			Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		Mechanic mechanic = new Mechanic();
		mechanic.setEmail(email);
		mechanic.setFirstName(firstName);
		mechanic.setLastName(lastName);
		mechanic.setPhoneNumber(phoneNumber);
		mechanic.setDeleteFlag(true);
		mechanic.setUser(user);
		mechanicService.saveMechanic(mechanic);
		return new ModelAndView("redirect:/mechanics");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		mechanicService.deleteMechanic(id);
		return new ModelAndView("redirect:/mechanics");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("email") String email, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("phonenumber") String phoneNumber, @RequestParam("id") long id) {
		Mechanic mechanic = mechanicService.getOne(id);
		mechanic.setEmail(email);
		mechanic.setFirstName(firstName);
		mechanic.setLastName(lastName);
		mechanic.setPhoneNumber(phoneNumber);
		mechanicService.saveMechanic(mechanic);
		return new ModelAndView("redirect:/mechanics");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		Mechanic mechanic = mechanicService.getOne(id);
		model.addAttribute("mechanic", mechanic);
		return "/mechanics/edit";
	}

}
