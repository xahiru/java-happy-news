package xom.xahiru.happynews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xom.xahiru.happynews.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		
		model.addAttribute("users", userService.getAllUsers());
		 
		 return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String users(Model model, @PathVariable int id){
		
		model.addAttribute("user", userService.getOneUser(id));
		 
		 return "user-detail";
	}
	
}
