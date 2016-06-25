package com.abpadan.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abpadan.webapp.domain.Role;
import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.service.RoleService;
import com.abpadan.webapp.service.UserService;

@Controller
@RequestMapping("/createuser")
public class CreateUserController {
	
	private static Logger logger = LoggerFactory.getLogger(CreateUserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String createUser(Model model) {
		model.addAttribute("roles", roleService.getAllRoles());
		return "createuser/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newUser(@Valid User newUser, BindingResult bindingResult, Model model,
			@RequestParam("username") String username, @RequestParam("role") String userRole,
			@RequestParam("password") String password, String confirmPassword) {
		List<User> users = userService.getAllUsers();
		boolean valid = true; 
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				model.addAttribute("roles", roleService.getAllRoles());
				logger.error("User with " + username + " already exists! Please specify a different username");
				valid = false;
				return "createuser/new";
			}
		}

		if (valid) {
			User user = new User();
			Role role = roleService.getRoleByName(userRole);
			user.setUsername(username);
			user.setRole(role);
			user.setPassword(new BCryptPasswordEncoder().encode(password));
			userService.saveUser(user);
		}
		
		return "redirect:/users";
	}

}
