package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {



	@Autowired
	private UsersService usersService;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("user",new Users());
		return "register";
	}

	@PostMapping("/register")
	public String userRegistration(Users user,Model model){
		model.addAttribute("user",user);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		System.out.println(user.getPassword());
		System.out.println(encodedPassword);
		user.setPassword(encodedPassword);

		try {
			usersService.addNew(1,user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "users";
	}


}
