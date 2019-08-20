package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;
import com.codingdojo.authentication.validators.UserValidator;


@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
// Render Login Registration Page
	
	@GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "users/registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "users/loginPage.jsp";
    }
    
// Add User To DB

    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "users/registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
    
// Login User

    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "Invalid login. Try again.");
    		return "users/loginPage.jsp";
    	}
    }
    
// Render Home

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
    	return "users/homePage.jsp";
    }
    
    
// Logout

    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
    	return "redirect:/login";
    }
	
	
}