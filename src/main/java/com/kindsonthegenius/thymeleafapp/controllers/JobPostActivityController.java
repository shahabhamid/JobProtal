package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobCompany;
import com.kindsonthegenius.thymeleafapp.models.JobLocation;
import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job-post")
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService usersService;

	@RequestMapping("/")
	public String displayJobs(Model model) {

		return "job-post";
	}
	@RequestMapping("/add")
	public String addJobs(Model model) {
		model.addAttribute("post", new JobPostActivity());
		return "add-jobs";
	}

	@PostMapping("/addNew")
	public String addNew(JobPostActivity jobPostActivity, JobLocation location, JobCompany company, Model model) {


		model.addAttribute("jobPostActivity",jobPostActivity);
		model.addAttribute("location",location);
		model.addAttribute("company",company);

		System.out.println(location.toString());
		System.out.println(company.toString());
		System.out.println(jobPostActivity.toString());

		return "redirect:/recruiter-profile/";

	}

}
