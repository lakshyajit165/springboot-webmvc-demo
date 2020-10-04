package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;

@Controller
@RequestMapping(value = "/")
public class UserController {	
	private static final int COOKIE_EXPIRY_IN_SECONDS = 24*60*60; // 1 day
	private static final String dummyUser = "Dummy";
	
	@GetMapping("/home")
	public String register(Model model) {
	    model.addAttribute("message", "Spring Boot MVC Example");
	    return "home";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerUser(Model model) { 
	    // Add new user to model to be bound with view (JSP)
	    model.addAttribute(new User());
	    return "registerUser";
	}
	
	@RequestMapping(value = "/showUser", method = RequestMethod.POST)
	public String showUser(@ModelAttribute("user") User user, Model model, HttpServletResponse response) {
		// extract user details and verify provided credentials
		if(user.getFirstName().equals(dummyUser)) {
			// user login success
			Cookie cookie = new Cookie("token", "dummy-token");
			cookie.setMaxAge(COOKIE_EXPIRY_IN_SECONDS);
			cookie.setSecure(false);
			cookie.setHttpOnly(true);
			
			response.addCookie(cookie);
		    model.addAttribute("User", user);
		    return "showUser";
		} 
		// login failure
		model.addAttribute("message", "Invalid user!");
	    return "error";
	}
}
