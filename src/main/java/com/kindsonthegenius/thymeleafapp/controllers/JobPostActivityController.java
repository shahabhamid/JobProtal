package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.Utilities.FileUploadUtil;
import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/job-post")
public class JobPostActivityController {

	@Autowired
	private JobPostActivityService jobPostActivityService;

	@Autowired
	UsersRepository usersRepository;

	@RequestMapping("/")
	public String displayJobs(Model model) {
		List<JobPostActivity> jobPost = jobPostActivityService.getAll();
		model.addAttribute("jobPost",jobPost);

		return "job-post";
	}

	@RequestMapping("/add")
	public String addJobs(Model model) {
		model.addAttribute("jobPostActivity", new JobPostActivity());


		return "add-jobs";
	}
	@PostMapping("/addNew")
	public String addNew(JobPostActivity jobPostActivity, @RequestParam("image") MultipartFile multipartFile , Model model) throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user = usersRepository.findByEmail(currentUserName);
			jobPostActivity.setPosted_by_id(user);
		}
		jobPostActivity.setPosted_date(new Date());
		model.addAttribute("jobPostActivity",jobPostActivity);
		String fileName = StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())));
		jobPostActivity.getJob_company_id().setLogo(fileName);
		JobPostActivity saved = jobPostActivityService.addNew(jobPostActivity);
		String uploadDir = "company-photos/" + saved.getJob_company_id().getId();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "redirect:/job-post/";

	}

}
