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

import com.abpadan.webapp.domain.Status;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.domain.Vehicle;
import com.abpadan.webapp.service.UserService;
import com.abpadan.webapp.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listVehicles(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		List<Vehicle> vehicles = vehicleService.getVehiclesByUser(user);
		model.addAttribute("vehicles", vehicleService.setVehicleDeleteFlag(user, vehicles));
		return "vehicles/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicle(Model model) {
    	List<Status> status = Arrays.asList(Status.values());
		model.addAttribute("status", status);
		return "vehicles/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("make") String make, @RequestParam("model") String model,
			@RequestParam("year") String year, @RequestParam("color") String color,
			@RequestParam("licenseplatenumber") String licensePlateNumber, @RequestParam("dotnumber") String DOTNumber,
			@RequestParam("purchasedate") String purchaseDate, @RequestParam("purchasemileage") String purchaseMileage,
			@RequestParam("status") Status status, Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUsername(username);
		Vehicle vehicle = new Vehicle();
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setYear(BigInteger.valueOf(Integer.valueOf(year)));
		vehicle.setColor(color);
		vehicle.setLicensePlateNumber(licensePlateNumber);
		vehicle.setDOTNumber(DOTNumber);
		vehicle.setPurchaseDate(Date.valueOf(LocalDate.parse(purchaseDate)));
		vehicle.setPurchaseMileage(BigInteger.valueOf(Integer.valueOf(purchaseMileage)));
		vehicle.setStatus(status);
		vehicle.setDeleteFlag(true);
		vehicle.setVehicleMaintenanceSessionCount(vehicle);
		vehicle.setUser(user);
		vehicleService.saveVehicle(vehicle);
		return new ModelAndView("redirect:/vehicles");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id, Principal principal) {
		vehicleService.deleteVehicle(id);
		return new ModelAndView("redirect:/vehicles");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("make") String make, @RequestParam("model") String model,
			@RequestParam("year") String year, @RequestParam("color") String color,
			@RequestParam("licenseplatenumber") String licensePlateNumber, @RequestParam("dotnumber") String DOTNumber,
			@RequestParam("purchasedate") String purchaseDate, @RequestParam("purchasemileage") String purchaseMileage,
			@RequestParam("status") Status status, @RequestParam("id") long id) {
		Vehicle vehicle = vehicleService.getOne(id);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setYear(BigInteger.valueOf(Integer.valueOf(year)));
		vehicle.setColor(color);
		vehicle.setLicensePlateNumber(licensePlateNumber);
		vehicle.setDOTNumber(DOTNumber);
		vehicle.setPurchaseDate(Date.valueOf(LocalDate.parse(purchaseDate)));
		vehicle.setPurchaseMileage(BigInteger.valueOf(Integer.valueOf(purchaseMileage)));
		vehicle.setStatus(status);
		vehicleService.saveVehicle(vehicle);
		return new ModelAndView("redirect:/vehicles");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		Vehicle vehicle = vehicleService.getOne(id);
		List<Status> status = Arrays.asList(Status.values());
		model.addAttribute("status", status);
		model.addAttribute("vehicle", vehicle);
		return "/vehicles/edit";
	}

}
