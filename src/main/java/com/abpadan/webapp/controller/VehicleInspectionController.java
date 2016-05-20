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

import com.abpadan.webapp.domain.InspectionResult;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.domain.VehicleInspection;
import com.abpadan.webapp.service.UserService;
import com.abpadan.webapp.service.VehicleInspectionService;
import com.abpadan.webapp.service.VehicleService;

@Controller
@RequestMapping("/vehicleinspections")
public class VehicleInspectionController {

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleInspectionService vehicleInspectionService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listVehicleInspections(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		model.addAttribute("vehicleinspections", vehicleInspectionService.getVehicleInspectionsByUser(user));
		return "vehicleinspections/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicleInspection(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<InspectionResult> inspectionResults = Arrays.asList(InspectionResult.values());
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("inspectionresults", inspectionResults);
		model.addAttribute("vehicles", vehicles);
		return "vehicleinspections/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("inspectiondocumentnumber") String inspectionDocumentNumber,
			@RequestParam("inspectionresult") InspectionResult inspectionResult,
			@RequestParam("inspectionmileage") String inspectionMileage,
			@RequestParam("inspectiondate") String inspectionDate,
			@RequestParam("inspectionexpirationdate") String inspectionExpirationDate,
			@RequestParam("vehicle") Vehicle vehicle, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		VehicleInspection vehicleInspection = new VehicleInspection();
		vehicleInspection.setInspectionDocumentNumber(inspectionDocumentNumber);
		vehicleInspection.setInspectionResult(inspectionResult);
		vehicleInspection.setInspectionMileage(BigInteger.valueOf(Integer.valueOf(inspectionMileage)));
		vehicleInspection.setInspectionDate(Date.valueOf(LocalDate.parse(inspectionDate)));
		vehicleInspection.setInspectionExpirationDate(Date.valueOf(LocalDate.parse(inspectionExpirationDate)));
		vehicleInspection.setVehicle(vehicle);
		vehicleInspection.setUser(user);
		vehicleInspectionService.saveVehicleInspection(vehicleInspection);
		return new ModelAndView("redirect:/vehicleinspections");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id, Principal principal) {
		vehicleInspectionService.deleteVehicleInspection(id);
		return new ModelAndView("redirect:/vehicleinspections");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("inspectiondocumentnumber") String inspectionDocumentNumber,
			@RequestParam("inspectionresult") InspectionResult inspectionResult,
			@RequestParam("inspectionmileage") String inspectionMileage,
			@RequestParam("inspectiondate") String inspectionDate,
			@RequestParam("inspectionexpirationdate") String inspectionExpirationDate,
			@RequestParam("vehicle") Vehicle vehicle, @RequestParam("id") long id) {
		VehicleInspection vehicleInspection = vehicleInspectionService.getOne(id);
		vehicleInspection.setInspectionDocumentNumber(inspectionDocumentNumber);
		vehicleInspection.setInspectionResult(inspectionResult);
		vehicleInspection.setInspectionMileage(BigInteger.valueOf(Integer.valueOf(inspectionMileage)));
		vehicleInspection.setInspectionDate(Date.valueOf(LocalDate.parse(inspectionDate)));
		vehicleInspection.setInspectionExpirationDate(Date.valueOf(LocalDate.parse(inspectionExpirationDate)));
		vehicleInspection.setVehicle(vehicle);
		vehicleInspectionService.saveVehicleInspection(vehicleInspection);
		return new ModelAndView("redirect:/vehicleinspections");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model, Principal principal) {
		VehicleInspection vehicleInspection = vehicleInspectionService.getOne(id);
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		List<InspectionResult> inspectionResults = Arrays.asList(InspectionResult.values());
		model.addAttribute("inspectionresults", inspectionResults);
		model.addAttribute("vehicleinspection", vehicleInspection);
		model.addAttribute("vehicles", vehicles);
		return "/vehicleinspections/edit";
	}
	
	@RequestMapping(value = "/new/report", method = RequestMethod.GET)
	public String newVehicleInspectionReport(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("vehicles", vehicles);
		return "vehicleinspections/new-report";
	}
	
	@RequestMapping(value = "/report/create", method = RequestMethod.POST)
	public String createVehicleRegistrationReport(@RequestParam("inspectionstartdate") String inspectionStartDate,
			@RequestParam("inspectionenddate") String inspectionEndDate,
			@RequestParam("inspectionexpirationstartdate") String inspectionExpirationStartDate,
			@RequestParam("inspectionexpirationenddate") String inspectionExpirationEndDate,
			@RequestParam("vehicle") Vehicle vehicle, Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		long userID = user.getId();
		long vehicleID = vehicle.getId();
		List<VehicleInspection> vehicleInspections= vehicleInspectionService.getVehicleInspectionsByUserAndBetweenDates(Date.valueOf(LocalDate.parse(inspectionStartDate)), Date.valueOf(LocalDate.parse(inspectionEndDate)), Date.valueOf(LocalDate.parse(inspectionExpirationStartDate)), Date.valueOf(LocalDate.parse(inspectionExpirationEndDate)), userID, vehicleID);
		model.addAttribute("vehicleinspections", vehicleInspections);
		return "vehicleinspections/report-list";
	}

}
