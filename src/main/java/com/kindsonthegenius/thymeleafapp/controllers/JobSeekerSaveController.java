package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerSave;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class JobSeekerSaveController {

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


    @PostMapping("job-details/save/{id}")
    public String save(@PathVariable("id") int id, JobSeekerSave jobSeekerSave) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users user = usersRepository.findByEmail(currentUserName);
            Optional<JobSeekerProfile> one = jobSeekerProfileService.getOne(user.getUser_id());

            Optional<JobPostActivity> jobPostActivity = jobPostActivityService.getOne(id);
            if(one.isPresent() && jobPostActivity.isPresent()){
                jobSeekerSave.setUser_id(one.get());
                jobSeekerSave.setJob(jobPostActivity.get());
            }else {
                throw new Exception("User Not Present");
            }
            jobSeekerSaveService.addNew(jobSeekerSave);
        }

        return "redirect:/dashboard/";

    }

    @RequestMapping("saved-jobs/")
    public String savedJobs(Model model)
    {

        List<JobPostActivity> jobPost = new ArrayList<>();
        Object currentUserProfile = usersService.getCurrentUserProfile();

        List<JobSeekerSave> jobSeekerSaveList = jobSeekerSaveService.getCandidatesJobs((JobSeekerProfile) currentUserProfile);;
        for(JobSeekerSave save:jobSeekerSaveList){
            jobPost.add(save.getJob());
        }
        model.addAttribute("jobPost",jobPost);
        model.addAttribute("user",currentUserProfile);
        return "saved-jobs";
    }
}
