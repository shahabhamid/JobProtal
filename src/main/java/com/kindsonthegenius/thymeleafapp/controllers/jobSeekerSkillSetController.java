package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerSkillSet;

import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerSkillSetRepository;

import com.kindsonthegenius.thymeleafapp.services.JobSeekerSkillSetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobSeekerSkillSet")

public class jobSeekerSkillSetController {

    @Autowired
    private JobSeekerSkillSetRepository jobSeekerSkillSetRepository;

    @Autowired
    private JobSeekerSkillSetService jobSeekerSkillSetService ;

    @RequestMapping("/")
    public List<JobSeekerSkillSet> getAll(Model model) {
        List<JobSeekerSkillSet> jobSeekerSkillSets = jobSeekerSkillSetService.getAll();
        model.addAttribute("jobSeekerSkillSets", jobSeekerSkillSets);
        return jobSeekerSkillSets;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobSeekerSkillSet> getOne(Integer Id) {
        return jobSeekerSkillSetService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobSeekerSkillSet jobSeekerSkillSets) throws Exception {
        jobSeekerSkillSetService.addNew(jobSeekerSkillSets);
        return "redirect:/jobSeekerSkillSets/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobSeekerSkillSet jobSeekerSkillSets) {
        jobSeekerSkillSetService.update(jobSeekerSkillSets);
        return "redirect:/jobSeekerSkillSets/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobSeekerSkillSetService.delete(Id);
        return "redirect:/jobSeekerSkillSets/";
    }

}
