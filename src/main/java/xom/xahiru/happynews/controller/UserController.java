package xom.xahiru.happynews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model){
		
		model.addAttribute("users", userService.getAllUsers());
		 
		 return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String users(Model model, @PathVariable int id){
		
		model.addAttribute("user", userService.fingUserWithBlogs(id));
		
		 
		 return "user-detail";
	}
	
	@RequestMapping("/register")
	public String registerUser(){
	
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST )
	public String doRegisterUser(@ModelAttribute("user") User user){
		
		userService.save(user);
	
		return "user-register";
	}
	
}
