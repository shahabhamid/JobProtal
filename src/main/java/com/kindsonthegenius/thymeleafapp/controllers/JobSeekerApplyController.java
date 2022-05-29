package com.kindsonthegenius.thymeleafapp.controllers;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerApply;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerApplyRepository;
import com.kindsonthegenius.thymeleafapp.services.JobSeekerApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobSeekerApply")


public class JobSeekerApplyController {

    @Autowired
    private JobSeekerApplyRepository jobSeekerApplyRepository;

    @Autowired
    private JobSeekerApplyService jobSeekerApplyService ;

    @RequestMapping("/")
    public List<JobSeekerApply> getAll(Model model) {
        List<JobSeekerApply> jobSeekerApply = jobSeekerApplyService.getAll();
        model.addAttribute("jobSeekerApply", jobSeekerApply);
        return jobSeekerApply;
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
