package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@Autowired
	private UsersRepository usersRepository;

	@RequestMapping("/")
	public String JobSeekerProfile(Model model) {

		JobSeekerProfile profile = new JobSeekerProfile();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			System.out.println(currentUserName);
			Users user = usersRepository.findByEmail(currentUserName);

			Optional<JobSeekerProfile> recruiterProfiles = profileRepo.getOne(user.getUser_id());
			if (recruiterProfiles.isPresent()) {
				profile = recruiterProfiles.get();
				System.out.println(recruiterProfiles.get());
			}
			model.addAttribute("profile", profile);
		}

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
		profileRepo.addNew(profile);
		return "redirect:/job-seeker-profile/new";
	}

}
