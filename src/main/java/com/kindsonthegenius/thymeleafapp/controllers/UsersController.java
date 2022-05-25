package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {



	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@RequestParam(name = "role",required = false) String role, Model model){
		model.addAttribute("role",role);
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
		user.setPassword(encodedPassword);

		try {
			usersService.addNew(1,user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "users";
	}


	@RequestMapping("/users/")
	public List<Users> getAll(Model model) {
		List<Users> users = usersService.getAll();
		model.addAttribute("users", users);

		for(Users u : users){
			System.out.println(u.toString());
		}
		return users;
	}

	@RequestMapping("/users/getOne")
	@ResponseBody
	public Optional<Users> getOne(Integer Id) {
		return usersService.getOne(Id);
	}

	@PostMapping("/addNew/{userTypeId}/users")
	public String addNew(@PathVariable(value = "userTypeId") int userTypeId,@Valid @RequestBody Users user) throws Exception {
		System.out.println(user.toString());
		usersService.addNew(userTypeId,user);
		return "redirect:/users/";
	}

	@RequestMapping(value="/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Users user) {
		usersService.update(user);
		return "redirect:/users/";
	}

	@RequestMapping(value="/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		usersService.delete(Id);
		return "redirect:/users/";
	}

}
