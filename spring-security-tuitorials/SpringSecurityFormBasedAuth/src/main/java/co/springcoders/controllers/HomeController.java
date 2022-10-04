package co.springcoders.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping
	public String homePage() {
		return "/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/loginFailed")
	@ResponseBody
	public String loginFailed() {
		return "Incorrect Credentials";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "This is authorized content for admin users";
	}
}
