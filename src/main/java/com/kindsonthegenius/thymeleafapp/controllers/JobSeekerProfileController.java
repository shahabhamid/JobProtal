package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/job-seeker-profile")
public class JobSeekerProfileController {


	@Autowired
	private JobSeekerProfileService profileRepo;

	

	@RequestMapping("/")
	public String getAll(Model model) {
	//	List<JobSeekerProfile> jobSeekerProfile = profileRepo.getAll();
	//	model.addAttribute("jobSeekerProfile", jobSeekerProfile.get(0));
		return "job-seeker-profile";
	}

	@GetMapping("/new")
	public String add(Model model){


		model.addAttribute("profile",new JobSeekerProfile());
		return "job-seeker-profile";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<JobSeekerProfile> getOne(Integer Id) {
		return profileRepo.getOne(Id);
	}

	@PostMapping("/save")
	public String addNew(@Valid @RequestBody JobSeekerProfile profile)  {
		System.out.println(profile.toString());
		profileRepo.addNew(profile);
		return "redirect:/job-seeker-profile/new";
	}

}
