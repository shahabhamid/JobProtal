package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobCompany;
import com.kindsonthegenius.thymeleafapp.models.JobLocation;
import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job-post")
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService jobPostActivityService;

	@RequestMapping("/")
	public String displayJobs(Model model) {

		return "job-post";
	}
	@RequestMapping("/add")
	public String addJobs(JobPostActivity jobPostActivity,Model model) {

		model.addAttribute("jobPostActivity", jobPostActivity);
		return "add-jobs";
	}
	@PostMapping("/addNew")
	public String addNew(JobPostActivity jobPostActivity,Model model) {
		model.addAttribute("jobPostActivity",jobPostActivity);
		System.out.println(jobPostActivity);

		jobPostActivityService.addNew(jobPostActivity);

		return "redirect:/recruiter-profile/";

	}

}
