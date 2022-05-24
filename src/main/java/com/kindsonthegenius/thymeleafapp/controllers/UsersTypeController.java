package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.models.UsersType;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usersType")
public class UsersTypeController {


	@Autowired
	private UsersTypeRepository userTypeRepository;
/*

	@GetMapping("")
	static List <UsersType> getInstructors() {
		List<UsersType> users = usersService.getAll();
		return "users";return userTypeRepository.findAll();
	}

	@GetMapping("/instructors/{id}")
	static ResponseEntity < Instructor > getInstructorById(
			@PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
		Instructor user = userTypeRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/instructors")
	static Instructor createUser(@Valid @RequestBody Instructor instructor) {
		return userTypeRepository.save(instructor);
	}

	@PutMapping("/instructors/{id}")
	static ResponseEntity < Instructor > updateUser(
			@PathVariable(value = "id") Long instructorId,
			@Valid @RequestBody Instructor userDetails) throws ResourceNotFoundException {
		Instructor user = userTypeRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		final Instructor updatedUser = userTypeRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/instructors/{id}")
	static Map < String, Boolean > deleteUser(
			@PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
		Instructor instructor = userTypeRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

		userTypeRepository.delete(instructor);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	*//*

	@RequestMapping("/")
	static String getAll(Model model) {
		List<Users> users = usersService.getAll();
		model.addAttribute("users", users);

		for(Users u : users){
			System.out.println(u.toString());
		}
		return "users";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	static Optional<Users> getOne(Integer Id) {
		return usersService.getOne(Id);
	}
	
	@PostMapping("/addNew")
	static String addNew(Users user) {
		usersTypeService.addNew(user);
		return "redirect:/users/";
	}

	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	static String update(Users user) {
		usersService.update(user);
		return "redirect:/users/";
	}

	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	static String delete(Integer Id) {
		usersService.delete(Id);
		return "redirect:/users/";
	}*/
}
