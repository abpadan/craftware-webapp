package com.abpadan.webapp.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleRegistration;
import com.abpadan.webapp.service.UserService;
import com.abpadan.webapp.service.VehicleRegistrationService;
import com.abpadan.webapp.service.VehicleService;

@Controller
@RequestMapping("/vehicleregistrations")
public class VehicleRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listVehicleRegistrations(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		model.addAttribute("vehicleregistrations", vehicleRegistrationService.getVehicleRegistrationsByUser(user));
		return "vehicleregistrations/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicleRegistration(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("vehicles", vehicles);
		return "vehicleregistrations/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("registrationdate") String registrationDate,
			@RequestParam("registrationexpirationDate") String registrationExpirationDate,
			@RequestParam("registrationmileage") String registrationMileage,
			@RequestParam("registrationdocumentnumber") String registrationDocumentNumber,
			@RequestParam("vehicle") Vehicle vehicle, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		VehicleRegistration vehicleRegistration = new VehicleRegistration();
		vehicleRegistration.setRegistrationDate(Date.valueOf(LocalDate.parse(registrationDate)));
		vehicleRegistration.setRegistrationExpirationDate(Date.valueOf(LocalDate.parse(registrationExpirationDate)));
		vehicleRegistration.setRegistrationMileage(BigInteger.valueOf(Integer.valueOf(registrationMileage)));
		vehicleRegistration.setRegistrationDocumentNumber(registrationDocumentNumber);
		vehicleRegistration.setVehicle(vehicle);
		vehicleRegistration.setUser(user);
		vehicleRegistrationService.saveVehicleRegistration(vehicleRegistration);
		return new ModelAndView("redirect:/vehicleregistrations");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id, Principal principal) {
		vehicleRegistrationService.deleteVehicleRegistration(id);
		return new ModelAndView("redirect:/vehicleregistrations");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("registrationdate") String registrationDate,
			@RequestParam("registrationexpirationdate") String registrationExpirationDate,
			@RequestParam("registrationmileage") String registrationMileage,
			@RequestParam("registrationdocumentnumber") String registrationDocumentNumber,
			@RequestParam("vehicle") Vehicle vehicle, @RequestParam("id") long id) {
		VehicleRegistration vehicleRegistration = vehicleRegistrationService.getOne(id);
		vehicleRegistration.setRegistrationDate(Date.valueOf(LocalDate.parse(registrationDate)));
		vehicleRegistration.setRegistrationExpirationDate(Date.valueOf(LocalDate.parse(registrationExpirationDate)));
		vehicleRegistration.setRegistrationMileage(BigInteger.valueOf(Integer.valueOf(registrationMileage)));
		vehicleRegistration.setRegistrationDocumentNumber(registrationDocumentNumber);
		vehicleRegistration.setVehicle(vehicle);
		vehicleRegistrationService.saveVehicleRegistration(vehicleRegistration);
		return new ModelAndView("redirect:/vehicleregistrations");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model, Principal principal) {
		VehicleRegistration vehicleRegistration = vehicleRegistrationService.getOne(id);
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("vehicleregistration", vehicleRegistration);
		model.addAttribute("vehicles", vehicles);
		return "/vehicleregistrations/edit";
	}
	
	@RequestMapping(value = "/new/report", method = RequestMethod.GET)
	public String newVehicleRegistrationReport(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("vehicles", vehicles);
		return "vehicleregistrations/new-report";
	}
	
	@RequestMapping(value = "/report/create", method = RequestMethod.POST)
	public String createVehicleRegistrationReport(@RequestParam("registrationstartdate") String registrationStartDate,
			@RequestParam("registrationenddate") String registrationEndDate,
			@RequestParam("registrationexpirationstartdate") String registrationExpirationStartDate,
			@RequestParam("registrationexpirationenddate") String registrationExpirationEndDate,
			@RequestParam("vehicle") Vehicle vehicle, Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		long userID = user.getId();
		long vehicleID = vehicle.getId();
		List<VehicleRegistration> vehicleRegistrations = vehicleRegistrationService.getVehicleRegistrationsByUserAndBetweenDates(Date.valueOf(LocalDate.parse(registrationStartDate)), Date.valueOf(LocalDate.parse(registrationEndDate)), Date.valueOf(LocalDate.parse(registrationExpirationStartDate)), Date.valueOf(LocalDate.parse(registrationExpirationEndDate)), userID, vehicleID);
		model.addAttribute("vehicleregistrations", vehicleRegistrations);
		return "vehicleregistrations/report-list";
	}

}
