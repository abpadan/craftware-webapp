package com.abpadan.webapp.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abpadan.webapp.domain.Completed;
import com.abpadan.webapp.domain.MaintenanceActivity;
import com.abpadan.webapp.domain.MaintenanceSession;
import com.abpadan.webapp.domain.Mechanic;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.service.MaintenanceActivityService;
import com.abpadan.webapp.service.MaintenanceSessionService;
import com.abpadan.webapp.service.MechanicService;
import com.abpadan.webapp.service.UserService;
import com.abpadan.webapp.service.VehicleService;

@Controller
@RequestMapping("/maintenancesessions")
public class MaintenanceSessionController {

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private MechanicService mechanicService;
	
	@Autowired
	private MaintenanceSessionService maintenanceSessionService;
	
	@Autowired
	private MaintenanceActivityService maintenanceActivityService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listMaintenanceSessions(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		model.addAttribute("maintenancesessions", maintenanceSessionService.getMaintenaceSessionsByUser(user));
		return "maintenancesessions/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMaintenanceSession(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		List<Mechanic> mechanics = mechanicService.getMechanicsByUser(user);
		List<Completed> completed = Arrays.asList(Completed.values());
		List<MaintenanceActivity> maintenanceActivities = maintenanceActivityService.getMaintenanceActivitiesByUser(user);
    	model.addAttribute("completed", completed);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("mechanics", mechanics);
		model.addAttribute("maintenanceactivities", maintenanceActivities);
		return "maintenancesessions/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate,
			@RequestParam("mileage") String mileage, @RequestParam("completed") Completed completed,
			@RequestParam("activityname") MaintenanceActivity maintenanceActivity,
			@RequestParam("activitynote") String activityNote, @RequestParam("vehicle") Vehicle vehicle,
			@RequestParam("mechanic") Mechanic mechanic, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		MaintenanceSession maintenanceSession = new MaintenanceSession();
		maintenanceSession.setStartDate(Date.valueOf(LocalDate.parse(startDate)));
		maintenanceSession.setEndDate(Date.valueOf(LocalDate.parse(endDate)));
		maintenanceSession.setMileage(BigInteger.valueOf(Integer.valueOf(mileage)));
		maintenanceSession.setCompleted(completed);
		maintenanceSession.setMaintenanceActivity(maintenanceActivity);
		maintenanceSession.setActivityNote(activityNote);
		maintenanceSession.setVehicle(vehicle);
		maintenanceSession.setMechanic(mechanic);
		vehicle.setVehicleMaintenanceSessionCount(vehicle);
		maintenanceSession.setUser(user);
		maintenanceSessionService.saveMaintenanceSession(maintenanceSession);
		vehicleService.saveVehicle(vehicle);
		return new ModelAndView("redirect:/maintenancesessions");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id, Principal principal) {
		maintenanceSessionService.deleteMaintenanceSession(id);
		return new ModelAndView("redirect:/maintenancesessions");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate,
			@RequestParam("mileage") String mileage, @RequestParam("completed") Completed completed,
			@RequestParam("activityname") MaintenanceActivity maintenanceActivity,
			@RequestParam("activitynote") String activityNote, @RequestParam("vehicle") Vehicle vehicle,
			@RequestParam("mechanic") Mechanic mechanic, Principal principal, @RequestParam("id") long id) {
		MaintenanceSession maintenanceSession = maintenanceSessionService.getOne(id);
		maintenanceSession.setStartDate(Date.valueOf(LocalDate.parse(startDate)));
		maintenanceSession.setEndDate(Date.valueOf(LocalDate.parse(endDate)));
		maintenanceSession.setMileage(BigInteger.valueOf(Integer.valueOf(mileage)));
		maintenanceSession.setCompleted(completed);
		maintenanceSession.setMaintenanceActivity(maintenanceActivity);
		maintenanceSession.setActivityNote(activityNote);
		maintenanceSession.setVehicle(vehicle);
		maintenanceSession.setMechanic(mechanic);
		maintenanceSessionService.saveMaintenanceSession(maintenanceSession);
		return new ModelAndView("redirect:/maintenancesessions");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model, Principal principal) {
		MaintenanceSession maintenanceSession = maintenanceSessionService.getOne(id);
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		List<Mechanic> mechanics = mechanicService.getMechanicsByUser(user);
		List<Completed> completed = Arrays.asList(Completed.values());
		List<MaintenanceActivity> maintenanceActivities = maintenanceActivityService.getMaintenanceActivitiesByUser(user);
		model.addAttribute("maintenancesession", maintenanceSession);
		model.addAttribute("maintenanceactivities", maintenanceActivities);
		model.addAttribute("completed", completed);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("mechanics", mechanics);
		return "/maintenancesessions/edit";
	}
	
	@RequestMapping(value = "/new/report", method = RequestMethod.GET)
	public String newVehicleInspectionReport(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		List<Mechanic> mechanics = mechanicService.getMechanicsByUser(user);
		List<MaintenanceActivity> maintenanceActivities = maintenanceActivityService.getMaintenanceActivitiesByUser(user);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("mechanics", mechanics);
		model.addAttribute("maintenanceactivities", maintenanceActivities);
		return "maintenancesessions/new-report";
	}
	
	@RequestMapping(value = "/report/create", method = RequestMethod.POST)
	public String createVehicleRegistrationReport(@RequestParam("startdate") String startDate,
			@RequestParam("enddate") String endDate, @RequestParam("vehicle") Vehicle vehicle,
			@RequestParam("mechanic") Mechanic mechanic,
			@RequestParam("maintenanceactivities") MaintenanceActivity maintenanceActivity, Model model,
			Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		long userID = user.getId();
		long vehicleID = vehicle.getId();
		long mechanicID = mechanic.getId();
		long maintenanceActivityID = maintenanceActivity.getId();
		List<MaintenanceSession> maintenanceSessions = maintenanceSessionService.getMaintenanceSessionsByUserAndVehicleAndMechanicAndMaintenanceActivityAndBetweenDates(Date.valueOf(LocalDate.parse(startDate)), Date.valueOf(LocalDate.parse(endDate)), userID,vehicleID, mechanicID, maintenanceActivityID);
		model.addAttribute("maintenancesessions", maintenanceSessions);
		return "maintenancesessions/report-list";
	}

}
