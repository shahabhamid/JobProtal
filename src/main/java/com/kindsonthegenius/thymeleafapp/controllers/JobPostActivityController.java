package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import com.kindsonthegenius.thymeleafapp.services.RecruiterProfileService;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	public String displayAllJobs(Model model) {
		List<JobPostActivity> jobPost = jobPostActivityService.getAll();
		model.addAttribute("jobPost",jobPost);
		model.addAttribute("user",usersService.getCurrentUserProfile());

		return "dashboard";
	}
	@RequestMapping("dashboard/search/")
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

		LocalDate Date=null;

		if(days30) Date = LocalDate.now().minusDays(30);
		else if(days7) Date = LocalDate.now().minusDays(7);
		else if(today) Date = LocalDate.now();
		else Date = LocalDate.MIN;

		if(partTime == null && fullTime == null && freelance == null){
			partTime = "Part-Time";
			fullTime = "Full-Time";
			freelance = "Freelance";
		}
		if(remoteOnly == null && officeOnly == null && partialRemote == null){
			remoteOnly = "Remote-Only";
			officeOnly = "Office-Only";
			partialRemote = "Partial-Remote";
		}

		List<JobPostActivity> jobPost = jobPostActivityService.getAll(
				job,
				location,
				Arrays.asList(partTime,fullTime,freelance),
				Arrays.asList(remoteOnly,officeOnly,partialRemote),
				Date
				);

		model.addAttribute("jobPost",jobPost);
		model.addAttribute("user",usersService.getCurrentUserProfile());
		return "dashboard";
	}

	@RequestMapping("dashboard/add")
	public String addJobs(Model model) {
		model.addAttribute("jobPostActivity", new JobPostActivity());
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

}
