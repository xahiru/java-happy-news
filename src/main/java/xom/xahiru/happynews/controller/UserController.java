package xom.xahiru.happynews.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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


	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	


	@RequestMapping("/account")
	public String account(Model model, Principal principal) {

		String name = principal.getName();

		model.addAttribute("user", userService.fingUserWithBlogs(name));

		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model ,@Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal) {
		if (result.hasErrors()) {

			return account(model,principal);
		}

		String name = principal.getName();

		blogService.save(blog, name);

		return "redirect:/happynews/account.html";

	}

	@RequestMapping(value = "/blog/remove/{id}")

	public String removeBlog(@PathVariable int id) {

		blogService.delete(blogService.findOne(id));

		return "redirect:/happynews/account.html";

	}


}
