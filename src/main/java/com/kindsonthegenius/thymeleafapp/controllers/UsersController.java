package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {


	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private UsersTypeRepository userTypeRepository;

	@Autowired
	private UsersService usersService;

	@GetMapping("/userTypes/{userTypeId}/users")
	//public List < Users > getUsersByUserType(@PathVariable(value = "userTypeId") int userTypeId) {
	//	List<Users> users = usersService.getUsersByUserType(userTypeId);
	///	return users;
	//}
	@RequestMapping("/")
	public List<Users> getAll(Model model) {
		List<Users> users = usersService.getAll();
		model.addAttribute("users", users);

		for(Users u : users){
			System.out.println(u.toString());
		}
		return users;
	}

	@RequestMapping("/getOne")
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

	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Users user) {
		usersService.update(user);
		return "redirect:/users/";
	}

	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		usersService.delete(Id);
		return "redirect:/users/";
	}
}
