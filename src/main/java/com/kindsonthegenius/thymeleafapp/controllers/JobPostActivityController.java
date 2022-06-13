package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.Utilities.FileUploadUtil;
import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import com.kindsonthegenius.thymeleafapp.services.RecruiterProfileService;
import com.kindsonthegenius.thymeleafapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
	@RequestMapping("dashboard/add")
	public String addJobs(Model model) {
		model.addAttribute("jobPostActivity", new JobPostActivity());

		return "add-jobs";
	}
	@PostMapping("dashboard/addNew")
	public String addNew(JobPostActivity jobPostActivity, @RequestParam("image") MultipartFile multipartFile , Model model) throws IOException {

		Users user = usersService.getCurrentUser();
		if(user!=null){
			jobPostActivity.setPosted_by_id(user);
		}

		jobPostActivity.setPosted_date(new Date());
		model.addAttribute("jobPostActivity",jobPostActivity);
		String fileName = StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())));
		jobPostActivity.getJob_company_id().setLogo(fileName);
		JobPostActivity saved = jobPostActivityService.addNew(jobPostActivity);
		String uploadDir = "company-photos/" + saved.getJob_company_id().getId();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "redirect:/dashboard/";

	}

}
