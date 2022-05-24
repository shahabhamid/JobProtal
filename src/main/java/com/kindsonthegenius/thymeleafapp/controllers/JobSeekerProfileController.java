package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.SkillSetsMaster;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.SkillSetsMasterRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jobSeekerProfile")
public class JobSeekerProfileController {


	@Autowired
	private JobSeekerProfileService profileRepo;

	@Autowired
	private SkillSetsMasterRepository skillSetsMaster;
	

	@RequestMapping("/")
	public String getAll(Model model) {
		List<JobSeekerProfile> jobSeekerProfile = profileRepo.getAll();
		model.addAttribute("jobSeekerProfile", jobSeekerProfile);
		return "jobSeekerProfile";
	}

	@GetMapping("/new")
	public String add(Model model){
		List<SkillSetsMaster> allSkills =(List<SkillSetsMaster> ) skillSetsMaster.findAll();
		model.addAttribute("profile",new JobSeekerProfile());
		model.addAttribute("allSkills",allSkills);
		return "jobSeekerProfile";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<JobSeekerProfile> getOne(Integer Id) {
		return profileRepo.getOne(Id);
	}

	@PostMapping("/jobSeekerProfile/save")
	public String addNew(@Valid @RequestBody JobSeekerProfile profile) throws Exception {
		System.out.println(profile.toString());
		profileRepo.addNew(profile);
		return "redirect:/jobSeekerProfile/new";
	}

}
