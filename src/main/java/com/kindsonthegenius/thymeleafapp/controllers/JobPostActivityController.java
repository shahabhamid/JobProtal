package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostActivityRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jobPost")
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService usersService;

	@RequestMapping("/")
	public List<JobPostActivity> getAll(Model model) {
		List<JobPostActivity> users = usersService.getAll();
		model.addAttribute("jobPost",users);
		for(JobPostActivity u : users){
			System.out.println(u.toString());
		}

		return users;
	}

}
