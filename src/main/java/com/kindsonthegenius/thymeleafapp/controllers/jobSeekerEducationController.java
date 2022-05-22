package com.kindsonthegenius.thymeleafapp.controllers;


import com.kindsonthegenius.thymeleafapp.models.JobSeekerEducation;


import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerEducationRepository;


import com.kindsonthegenius.thymeleafapp.services.JobSeekerEducationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobSeekerEducation")

public class jobSeekerEducationController {

    @Autowired
    private JobSeekerEducationRepository jobSeekerEducationRepository;

    @Autowired
    private JobSeekerEducationService jobSeekerEducationService ;

    @RequestMapping("/")
    public List<JobSeekerEducation> getAll(Model model) {
        List<JobSeekerEducation> jobSeekerEducation = jobSeekerEducationService.getAll();
        model.addAttribute("jobSeekerEducation", jobSeekerEducation);
        return jobSeekerEducation;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerEducation> getOne(Integer Id) {
        return jobSeekerEducationService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobSeekerEducation jobSeekerEducation) throws Exception {
        jobSeekerEducationService.addNew(jobSeekerEducation);
        return "redirect:/jobSeekerEducation/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobSeekerEducation jobSeekerEducation) {
        jobSeekerEducationService.update(jobSeekerEducation);
        return "redirect:/jobSeekerEducation/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobSeekerEducationService.delete(Id);
        return "redirect:/jobSeekerEducation/";
    }

}
