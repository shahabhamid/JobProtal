package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.*;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerApplyRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@Controller
public class JobSeekerApplyController {

    @Autowired
    JobSeekerApplyRepository jobSeekerApplyRepository;
    @Autowired
    JobSeekerApplyService jobSeekerApplyService ;
    @Autowired
    JobPostActivityService jobPostActivityService ;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    JobSeekerProfileService jobSeekerProfileService;
    @Autowired
    UsersService usersService;

    @RequestMapping("job-details-apply/{id}")
    public String Display(@PathVariable(value = "id") int id,Model model) {
        Optional<JobPostActivity> jobDetails = jobPostActivityService.getOne(id);
        JobSeekerApply jobSeekerApply = new JobSeekerApply();
        model.addAttribute("jobDetails", jobDetails.get());
        model.addAttribute("applyJob", jobSeekerApply);
        model.addAttribute("user",usersService.getCurrentUserProfile());
        return "job-details";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerApply> getOne(Integer Id) {
        return jobSeekerApplyService.getOne(Id);
    }

    @PostMapping("job-details/apply/{id}")
    public String apply(@PathVariable("id") int id,JobSeekerApply jobSeekerApply) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users user = usersRepository.findByEmail(currentUserName);
            Optional<JobSeekerProfile> one = jobSeekerProfileService.getOne(user.getUser_id());

            Optional<JobPostActivity> jobPostActivity = jobPostActivityService.getOne(id);
            if(one.isPresent() && jobPostActivity.isPresent()){
                jobSeekerApply.setUser_id(one.get());
                jobSeekerApply.setJob_post_id(jobPostActivity.get());
                jobSeekerApply.setApply_date(new Date());
            }else {
               throw new Exception("User Not Present");
            }
            jobSeekerApplyService.addNew(jobSeekerApply);
        }

        return "redirect:/jobSeekerApply/";

    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobSeekerApply jobSeekerApply) {
        jobSeekerApplyService.update(jobSeekerApply);
        return "redirect:/jobSeekerApply/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobSeekerApplyService.delete(Id);
        return "redirect:/jobSeekerApply/";
    }

}
