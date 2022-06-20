package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.*;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import com.kindsonthegenius.thymeleafapp.services.RecruiterProfileService;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;

@Controller
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService jobPostActivityService;
	@Autowired
	JobSeekerProfileService jobSeekerProfileService;
	@Autowired
	RecruiterProfileService recruiterProfileService;
	@Autowired
	UsersService usersService;


	@RequestMapping("dashboard/")
	public String searchedJobs(Model model,
							   @Param("job") String job,
							   @Param("location") String location,
							   @Param("partTime") String partTime,
							   @Param("fullTime") String fullTime,
							   @Param("freelance") String freelance,
							   @Param("remoteOnly") String remoteOnly,
							   @Param("officeOnly") String officeOnly,
							   @Param("partialRemote") String partialRemote,
							   @Param("today") boolean today,
							   @Param("days7") boolean days7,
							   @Param("days30") boolean days30)
	{

		model.addAttribute("partTime", Objects.equals(partTime,"Part-Time"));
		model.addAttribute("fullTime",Objects.equals(fullTime,"Full-Time"));
		model.addAttribute("freelance", Objects.equals(freelance, "Freelance"));

		model.addAttribute("remoteOnly", Objects.equals(remoteOnly,"Remote-Only"));
		model.addAttribute("officeOnly",Objects.equals(officeOnly,"Office-Only"));
		model.addAttribute("partialRemote", Objects.equals(partialRemote, "Partial-Remote"));

		model.addAttribute("today", today);
		model.addAttribute("days7",days7);
		model.addAttribute("days30", days30);

		model.addAttribute("job",job);
		model.addAttribute("location", location);

		LocalDate Date = null;
		List<JobPostActivity> jobPost = null;
		boolean dateSearch = true;
		boolean remote = true;
		boolean type = true;

		if(days30) Date = LocalDate.now().minusDays(30);
		else if(days7) Date = LocalDate.now().minusDays(7);
		else if(today) Date = LocalDate.now();
		else {
			Date = LocalDate.MIN;
			dateSearch=false;
		}

		if(partTime == null && fullTime == null && freelance == null){
			partTime = "Part-Time";
			fullTime = "Full-Time";
			freelance = "Freelance";
			remote = false;
		}
		if(remoteOnly == null && officeOnly == null && partialRemote == null){
			remoteOnly = "Remote-Only";
			officeOnly = "Office-Only";
			partialRemote = "Partial-Remote";
			type = false;
		}

		if(!dateSearch && !remote && !type && job==null && location ==null){
			jobPost = jobPostActivityService.getAll();

		}else{
			jobPost = jobPostActivityService.search(
					job,
					location,
					Arrays.asList(partTime,fullTime,freelance),
					Arrays.asList(remoteOnly,officeOnly,partialRemote),
					Date);
		}

		Object currentUserProfile = usersService.getCurrentUserProfile();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken) ) {
			if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))){
				List<RecruiterJobsClass> recruiterJobs = jobPostActivityService.getRecruiterJobs(((RecruiterProfile) currentUserProfile).getUser_account_id());
				model.addAttribute("jobPost",recruiterJobs);
			}
			else model.addAttribute("jobPost",jobPost);

		}
		model.addAttribute("user",currentUserProfile);
		return "dashboard";
	}

	@RequestMapping("dashboard/add")
	public String addJobs(Model model) {
		model.addAttribute("jobPostActivity", new JobPostActivity());
		model.addAttribute("user",usersService.getCurrentUserProfile());
		return "add-jobs";
	}
	@RequestMapping("dashboard/edit/{id}")
	public String editJob(@PathVariable("id") int id,Model model) {
		Optional<JobPostActivity> jobPostActivity = jobPostActivityService.getOne(id);

		model.addAttribute("jobPostActivity", jobPostActivity);
		model.addAttribute("user",usersService.getCurrentUserProfile());
		return "add-jobs";
	}
	@PostMapping("dashboard/addNew")
	public String addNew(JobPostActivity jobPostActivity, Model model) {

		Users user = usersService.getCurrentUser();
		if(user!=null){
			jobPostActivity.setPosted_by_id(user);
		}

		jobPostActivity.setPosted_date(new Date());
		model.addAttribute("jobPostActivity",jobPostActivity);
		JobPostActivity saved = jobPostActivityService.addNew(jobPostActivity);
		return "redirect:/dashboard/";
	}

	@PostMapping("dashboard/deleteJob/{id}")
	public String delete(@PathVariable("id") Integer Id) {
		jobPostActivityService.delete(Id);
		return "redirect:/dashboard/";
	}

}
