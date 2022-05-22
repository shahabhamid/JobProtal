package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerExperience;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerExperienceRepository;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobSeekerExperience")
public class jobSeekerExperienceController {

    @Autowired
    private JobSeekerExperienceRepository jobSeekerExperienceRepository;

    @Autowired
    private JobSeekerExperienceService jobSeekerExperienceService ;

    @RequestMapping("/")
    public List<JobSeekerExperience> getAll(Model model) {
        List<JobSeekerExperience> jobSeekerExperience = jobSeekerExperienceService.getAll();
        model.addAttribute("jobSeekerExperience", jobSeekerExperience);
        return jobSeekerExperience;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerExperience> getOne(Integer Id) {
        return jobSeekerExperienceService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobSeekerExperience jobSeekerExperience) throws Exception {
        jobSeekerExperienceService.addNew(jobSeekerExperience);
        return "redirect:/jobSeekerExperience/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobSeekerExperience jobSeekerExperience) {
        jobSeekerExperienceService.update(jobSeekerExperience);
        return "redirect:/jobSeekerExperience/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobSeekerExperienceService.delete(Id);
        return "redirect:/jobSeekerExperience/";
    }

}
