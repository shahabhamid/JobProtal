package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.*;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerApplyRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerApplyService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerProfileService;
import com.kindsonthegenius.thymeleafapp.services.RecruiterProfileService;
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
    private JobSeekerApplyRepository jobSeekerApplyRepository;
    @Autowired
    private JobSeekerApplyService jobSeekerApplyService ;
    @Autowired
    private JobPostActivityService jobPostActivityService ;
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JobSeekerProfileService jobSeekerProfileService;
    @Autowired
    RecruiterProfileService recruiterProfileService;

    @RequestMapping("job-details-apply/{id}")
    public String Display(@PathVariable(value = "id") int id,Model model) {
        Optional<JobPostActivity> jobDetails = jobPostActivityService.getOne(id);
        JobSeekerApply jobSeekerApply = new JobSeekerApply();
        model.addAttribute("jobDetails", jobDetails.get());
        model.addAttribute("applyJob", jobSeekerApply);
        RecruiterProfile user = recruiterProfileService.getCurrentRecruiterProfile();
        if(user!=null){
            model.addAttribute("user",user);
            System.out.println(user);
        }
        return "job-details";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerApply> getOne(Integer Id) {
        return jobSeekerApplyService.getOne(Id);
    }

    @PostMapping("job-details/apply/{id}")
    public String apply(@PathVariable("id") int id,JobSeekerApply jobSeekerApply) throws Exception {
        System.out.println(id);
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
            System.out.println(jobSeekerApply.toString());
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
