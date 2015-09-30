package xom.xahiru.happynews.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.service.BlogService;
import xom.xahiru.happynews.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
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
		
		return "redirect:/happynews/register.html?success=true";
	
		//return safeRedirect("user-register.html?success=true");
	}
	
//	public static RedirectView safeRedirect(String url) {
//	    RedirectView rv = new RedirectView(url);
//	    rv.setExposeModelAttributes(false);
//	    return rv;
//	}
	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		
		String name = principal.getName();
		
		model.addAttribute("user",userService.fingUserWithBlogs(name));
		
		
		
		 return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST )

	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
		
		String name = principal.getName();
		
		blogService.save(blog, name);
		
		return "redirect:/happynews/account.html";
	
	}
	
	@RequestMapping(value="/blog/remove/{id}" )

	public String removeBlog(@PathVariable int id){

		
		blogService.delete(blogService.findOne(id));
		
		return "redirect:/happynews/account.html";
	
	}
	
	
	@RequestMapping(value="/user/remove/{id}" )

	public String removeUser(@PathVariable int id){
//		public String removeBlog(@ModelAttribute("blog") Blog blog, Principal principal){
				
		//String name = principal.getName();
		
		userService.delete(id);
		
		return "redirect:/happynews/users.html";
	
	}
	
	
}
