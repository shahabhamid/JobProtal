package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.Utilities.FileUploadUtil;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.Skills;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
		List<Skills> skills = new ArrayList<>();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			Users user = usersRepository.findByEmail(authentication.getName());

			Optional<JobSeekerProfile> recruiterProfiles = profileRepo.getOne(user.getUser_id());
			if (recruiterProfiles.isPresent()) {
				profile = recruiterProfiles.get();
				if(profile.getSkillsList().isEmpty()){
					skills.add(new Skills());
					profile.setSkillsList(skills);
				}
			}
			model.addAttribute("skillsList",skills);
			model.addAttribute("profile", profile);
		}

		return "job-seeker-profile";
	}


	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<JobSeekerProfile> getOne(Integer Id) {
		return profileRepo.getOne(Id);
	}

	@PostMapping("/addNew")
	public String addNew(@Valid JobSeekerProfile profile, @RequestParam("image") MultipartFile image, @RequestParam("pdf") MultipartFile pdf , Model model)  {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user = usersRepository.findByEmail(currentUserName);
			profile.setUser_id(user);
			profile.setUser_account_id(user.getUser_id());
		}
		List<Skills> skillsList = new ArrayList<>();
		model.addAttribute("profile",profile);
		model.addAttribute("skillsList",skillsList);

		for(Skills skills:profile.getSkillsList()){
			skills.setJobSeekerProfile(profile);
		}

		String imageName="";
		String resumeName = "";
		if(!Objects.equals(image.getOriginalFilename(), "")){
			imageName = StringUtils.cleanPath((Objects.requireNonNull(image.getOriginalFilename())));
			profile.setProfile_photo(imageName);
		}
		if(!Objects.equals(image.getOriginalFilename(), "")){
			resumeName = StringUtils.cleanPath((Objects.requireNonNull(pdf.getOriginalFilename())));
			profile.setResume(resumeName);
		}

		JobSeekerProfile jobSeekerProfile = profileRepo.addNew(profile);

		try {
			String uploadDir = "user-photos/" + jobSeekerProfile.getUser_account_id();
			if(!Objects.equals(image.getOriginalFilename(), "")) FileUploadUtil.saveFile(uploadDir, imageName, image);
			if(!Objects.equals(image.getOriginalFilename(), "")) FileUploadUtil.saveFile(uploadDir, resumeName, pdf);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return "redirect:/dashboard/";
	}
}
