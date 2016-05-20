package com.abpadan.webapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abpadan.webapp.domain.User;
import com.abpadan.webapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUsersPage(Model model, Principal principal) {
    	String username = principal.getName();
    	User user = userService.getUserByUsername(username);
    	List<User> users = userService.getAllUsers();
		model.addAttribute("users", userService.setUserDeleteFlag(user, users));
        return "/users/list";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable long id, Model model) {
    	User user = userService.getOne(id);
    	model.addAttribute("user", user);
        return "/users/edit";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("username") String username) {
        User user = userService.getOne(id);
        user.setUsername(username);
        userService.saveUser(user);
        return new ModelAndView("redirect:/users");
    }
    
}
