package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/job-post")
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService usersService;

	@RequestMapping("/")
	public String getAll(Model model) {
		List<JobPostActivity> jobPost = usersService.getAll();
		model.addAttribute("jobPost",jobPost);
		for(JobPostActivity j : jobPost){
			System.out.println(j.toString());
		}
		return "job-post";
	}

}
