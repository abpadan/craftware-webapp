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

import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.service.MaintenanceActivityService;
import com.abpadan.webapp.service.UserService;

@Controller
@RequestMapping("/maintenanceactivities")
public class MaintenanceActivityController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private MaintenanceActivityService maintenanceActivityService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listActivities(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<MaintenanceActivity> maintenanceActivities = maintenanceActivityService.getMaintenanceActivitiesByUser(user);
		model.addAttribute("maintenanceactivities", maintenanceActivityService.setMaintenanceActivityDeleteFlag(user, maintenanceActivities));
		return "maintenanceactivities/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newActivity() {
		return "maintenanceactivities/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("activityname") String activityName, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		MaintenanceActivity maintenanceActivity = new MaintenanceActivity();
		maintenanceActivity.setActivityName(activityName);
		maintenanceActivity.setDeleteFlag(true);
		maintenanceActivity.setUser(user);
		maintenanceActivityService.saveMaintenanceActivity(maintenanceActivity);
		return new ModelAndView("redirect:/maintenanceactivities");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id, Principal principal) {
		maintenanceActivityService.deleteMaintenanceActivity(id);
		return new ModelAndView("redirect:/maintenanceactivities");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("activityname") String activityName, @RequestParam("id") long id) {
		MaintenanceActivity maintenanceActivity = maintenanceActivityService.getOne(id);
		maintenanceActivity.setActivityName(activityName);
		maintenanceActivityService.saveMaintenanceActivity(maintenanceActivity);
		return new ModelAndView("redirect:/maintenanceactivities");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		MaintenanceActivity maintenanceActivity = maintenanceActivityService.getOne(id);
		model.addAttribute("maintenaceactivity", maintenanceActivity);
		return "/maintenanceactivities/edit";
	}

}
