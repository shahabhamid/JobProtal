package com.kindsonthegenius.thymeleafapp.controllers;


import com.kindsonthegenius.thymeleafapp.models.JobLocation;
import com.kindsonthegenius.thymeleafapp.repositories.JobLocationRepository;
import com.kindsonthegenius.thymeleafapp.services.JobLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobLocation")

public class jobLocationController {

    @Autowired
    private JobLocationRepository jobLocationRepository;

    @Autowired
    private JobLocationService jobLocationService ;

    @RequestMapping("/")
    public List<JobLocation> getAll(Model model) {
        List<JobLocation> jobLocation = jobLocationService.getAll();
        model.addAttribute("jobPostSkillSetMapping", jobLocation);
        return jobLocation;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobLocation> getOne(Integer Id) {
        return jobLocationService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobLocation jobLocation) throws Exception {
        jobLocationService.addNew(jobLocation);
        return "redirect:/jobLocation/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobLocation jobLocation) {
        jobLocationService.update(jobLocation);
        return "redirect:/jobLocation/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobLocationService.delete(Id);
        return "redirect:/jobLocation/";
    }
}
