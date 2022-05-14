package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Users> users = usersService.getAll();
		model.addAttribute("users", users);
		
		//String username = "Kindson";
		//model.addAttribute("username", username);
		
		return "users";
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Users> getOne(Integer Id) {
		return usersService.getOne(Id);
	}
	
	@PostMapping("/addNew")
	public String addNew(Users user) {
		usersService.addNew(user);
		return "redirect:/users/getAll";
	}

	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Users user) {
		usersService.update(user);
		return "redirect:/users/getAll";		
	}

	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		usersService.delete(Id);
		return "redirect:/users/getAll";		
	}
}
