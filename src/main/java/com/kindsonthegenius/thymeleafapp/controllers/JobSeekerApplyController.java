package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.*;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class JobSeekerApplyController {

    @Autowired
    JobSeekerApplyService jobSeekerApplyService ;
    @Autowired
    JobSeekerSaveService jobSeekerSaveService ;
    @Autowired
    JobPostActivityService jobPostActivityService ;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    JobSeekerProfileService jobSeekerProfileService;
    @Autowired
    UsersService usersService;
    @Autowired
    private RecruiterProfileService recruiterProfile;
    @Autowired
    private JobSeekerProfileService seekerProfileService;

    @RequestMapping("job-details-apply/{id}")
    public String Display(@PathVariable(value = "id") int id,Model model) {
        Optional<JobPostActivity> jobDetails = jobPostActivityService.getOne(id);
        List<JobSeekerApply> jobSeekerApplyList = jobSeekerApplyService.getJobCandidates(jobDetails.get());
        List<JobSeekerSave> jobSeekerSaveList = jobSeekerSaveService.getJobCandidates(jobDetails.get());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken) ) {
            if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))){
                RecruiterProfile user = recruiterProfile.getCurrentRecruiterProfile();
                if(user!=null){
                    model.addAttribute("applyList",jobSeekerApplyList);
                }
            }else{
                JobSeekerProfile user = seekerProfileService.getCurrentSeekerProfile();
                if(user!=null){
                    boolean exists = false;
                    boolean saved = false;
                    for(JobSeekerApply jobSeekerApply: jobSeekerApplyList){
                        if(jobSeekerApply.getUser_id().getUser_account_id().equals(user.getUser_account_id())){
                            exists = true;
                            break;
                        }
                    }
                    for(JobSeekerSave jobSeekerSave: jobSeekerSaveList){
                        if(jobSeekerSave.getUser_id().getUser_account_id().equals(user.getUser_account_id())){
                            saved = true;
                            break;
                        }
                    }
                    model.addAttribute("alreadyApplied",exists);
                    model.addAttribute("alreadySaved",saved);
                }
            }
        }


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
                jobSeekerApply.setJob(jobPostActivity.get());
                jobSeekerApply.setApply_date(new Date());
            }else {
               throw new Exception("User Not Present");
            }
            jobSeekerApplyService.addNew(jobSeekerApply);
        }

        return "redirect:/dashboard/";

    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobSeekerApply jobSeekerApply) {
        jobSeekerApplyService.update(jobSeekerApply);
        return "redirect:/dashboard/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobSeekerApplyService.delete(Id);
        return "redirect:/dashboard/";
    }

}
