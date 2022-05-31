package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerApply;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerApplyRepository;
import com.kindsonthegenius.thymeleafapp.services.JobPostActivityService;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/jobSeekerApply")
public class JobSeekerApplyController {

    @Autowired
    private JobSeekerApplyRepository jobSeekerApplyRepository;

    @Autowired
    private JobSeekerApplyService jobSeekerApplyService ;
    @Autowired
    private JobPostActivityService jobPostActivityService ;

    @RequestMapping("/{id}")
    public String Display(@PathVariable(value = "id") int id,Model model) {
        Optional<JobPostActivity> jobDetails = jobPostActivityService.getOne(id);
        model.addAttribute("jobDetails", jobDetails.get());
        return "job-details";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerApply> getOne(Integer Id) {
        return jobSeekerApplyService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobSeekerApply jobSeekerApply) throws Exception {
        jobSeekerApplyService.addNew(jobSeekerApply);
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
