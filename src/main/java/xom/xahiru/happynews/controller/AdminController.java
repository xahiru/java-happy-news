package xom.xahiru.happynews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xom.xahiru.happynews.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String users(Model model) {

		model.addAttribute("users", userService.getAllUsers());

		return "users";
	}

	@RequestMapping("/{id}")
	public String users(Model model, @PathVariable int id) {

		model.addAttribute("user", userService.fingUserWithBlogs(id));

		return "user-detail";
	}
	

	@RequestMapping(value = "/remove/{id}")

	public String removeUser(@PathVariable int id) {
		
		userService.delete(id);

		return "redirect:/happynews/users.html";

	}
	
}
