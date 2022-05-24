package com.kindsonthegenius.thymeleafapp.controllers;
import com.kindsonthegenius.thymeleafapp.models.JobTypeMaster;
import com.kindsonthegenius.thymeleafapp.repositories.JobTypeMasterRepository;
import com.kindsonthegenius.thymeleafapp.services.JobTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/jobTypeMaster")

public class jobTypeMasterController {

    @Autowired
    private JobTypeMasterRepository jobTypeMasterRepository;

    @Autowired
    private JobTypeMasterService jobTypeMasterService ;

    @RequestMapping("/")
    public List<JobTypeMaster> getAll(Model model) {
        List<JobTypeMaster> jobTypeMaster = jobTypeMasterService.getAll();
        model.addAttribute("jobTypeMaster", jobTypeMaster);
        return jobTypeMaster;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<JobTypeMaster> getOne(Integer Id) {
        return jobTypeMasterService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(JobTypeMaster jobTypeMaster) throws Exception {
        jobTypeMasterService.addNew(jobTypeMaster);
        return "redirect:/jobTypeMaster/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTypeMaster jobTypeMaster) {
        jobTypeMasterService.update(jobTypeMaster);
        return "redirect:/jobTypeMaster/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        jobTypeMasterService.delete(Id);
        return "redirect:/jobTypeMaster/";
    }

}
