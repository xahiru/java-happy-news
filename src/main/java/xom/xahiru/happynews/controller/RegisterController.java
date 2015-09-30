package xom.xahiru.happynews.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	
	@RequestMapping
	public String registerUser() {

		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegisterUser(@Valid @ModelAttribute("user") User user,BindingResult result) {

		if (result.hasErrors()) {

			return "user-register";
		}
		userService.save(user);

		return "redirect:/happynews/register.html?success=true";

		// return safeRedirect("user-register.html?success=true");
	}

	// public static RedirectView safeRedirect(String url) {
	// RedirectView rv = new RedirectView(url);
	// rv.setExposeModelAttributes(false);
	// return rv;
	// }


}
