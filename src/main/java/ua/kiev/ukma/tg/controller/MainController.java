package ua.kiev.ukma.tg.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kiev.ukma.tg.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@GetMapping("login")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			model.addAttribute("error", "Invalid username or password!");
		}
		if (logout != null) {
			model.addAttribute("logout", "You've been logged out successfully.");
		}
		return "login";
	}

	@GetMapping({ "", "home" })
	public String homePage() {
		return "home";
	}
	
	@GetMapping("profile")
	public String profilePage(Principal user, Model model) {
		model.addAttribute("user", userService.getById(userService.getUserAuth(user.getName()).getId()));
		return "profile";
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}
	
	@RequestMapping("/404")
	public String notFound() {
		return "404";
	}	
}