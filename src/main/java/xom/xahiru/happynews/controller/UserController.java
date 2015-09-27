package xom.xahiru.happynews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xom.xahiru.happynews.entity.User;
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
	
}
