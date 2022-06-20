package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.models.UsersType;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import com.kindsonthegenius.thymeleafapp.services.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {



	@Autowired
	private UsersService usersService;
	@Autowired
	private UsersTypeService usersTypeService;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register(Model model){
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes",usersTypes);
		model.addAttribute("user",new Users());

		return "register";
	}

	@PostMapping("/register/new")
	public String userRegistration(@Valid Users user){

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		try {
			usersService.addNew(user);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect:/dashboard/";
	}


}
