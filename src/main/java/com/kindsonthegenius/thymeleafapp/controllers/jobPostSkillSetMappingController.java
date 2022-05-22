package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.JobPostSkillSetMapping;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostSkillSetMappingRepository;
import com.kindsonthegenius.thymeleafapp.services.JobPostSkillSetMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobPostSkillSetMapping")

public class jobPostSkillSetMappingController {

    @Autowired
    private JobPostSkillSetMappingRepository jobPostSkillSetMappingRepository;

    @Autowired
    private JobPostSkillSetMappingService jobPostSkillSetMappingService ;

    @RequestMapping("/")
    public List<JobPostSkillSetMapping> getAll(Model model) {
        List<JobPostSkillSetMapping> jobPostSkillSetMapping = jobPostSkillSetMappingService.getAll();
        model.addAttribute("jobPostSkillSetMapping", jobPostSkillSetMapping);
        return jobPostSkillSetMapping;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobPostSkillSetMapping> getOne(Integer Id) {
        return jobPostSkillSetMappingService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobPostSkillSetMapping jobPostSkillSetMapping) throws Exception {
        jobPostSkillSetMappingService.addNew(jobPostSkillSetMapping);
        return "redirect:/jobPostSkillSetMapping/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobPostSkillSetMapping jobPostSkillSetMapping) {
        jobPostSkillSetMappingService.update(jobPostSkillSetMapping);
        return "redirect:/jobPostSkillSetMapping/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobPostSkillSetMappingService.delete(Id);
        return "redirect:/jobPostSkillSetMapping/";
    }

}
