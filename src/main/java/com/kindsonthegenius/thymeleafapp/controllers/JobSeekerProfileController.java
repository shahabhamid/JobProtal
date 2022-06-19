package com.kindsonthegenius.thymeleafapp.controllers;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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
		//		if(profile.getSkills().isEmpty()){
		//			List<Skills> skills = new ArrayList<>();
		//			skills.add(new Skills());
		//			profile.setSkills(skills);
		//		}
				System.out.println(recruiterProfiles.get());
			}
			List<Skills> skillsList = new ArrayList<>();
			model.addAttribute("skills",skillsList);
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

	@PostMapping("/addNew")
	public String addNew(@Valid JobSeekerProfile profile, @RequestParam("image") MultipartFile multipartFile , Model model)  {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user = usersRepository.findByEmail(currentUserName);
			profile.setUser_id(user);
			profile.setUser_account_id(user.getUser_id());
		}
		List<Skills> skillsList = new ArrayList<>();
		model.addAttribute("profile",profile);
		model.addAttribute("skills",skillsList);

		System.out.println(profile.getCity());
		System.out.println(profile.getCountry());
		System.out.println(profile.getEmploymentType());
		for(Skills s :skillsList){
			System.out.println(s.toString());
		}
	//	profileRepo.addNew(profile);
		//String fileName = StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())));


		return "redirect:/job-seeker-profile/new";
	}
/*

	@PostMapping("/addNew")
	public String addNew(RecruiterProfile recruiterProfile, @RequestParam("image") MultipartFile multipartFile , Model model) throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user = usersRepository.findByEmail(currentUserName);
			recruiterProfile.setUser_id(user);
			recruiterProfile.setUser_account_id(user.getUser_id());
		}

		model.addAttribute("profile",recruiterProfile);
		String fileName = StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())));
		recruiterProfile.setProfile_photo(fileName);

		RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

		String uploadDir = "user-photos/" + savedUser.getUser_account_id();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return "redirect:/recruiter-profile/";
	}
*/

}
