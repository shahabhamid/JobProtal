package com.kindsonthegenius.thymeleafapp.controllers;
import com.kindsonthegenius.thymeleafapp.models.SkillSetsMaster;
import com.kindsonthegenius.thymeleafapp.repositories.SkillSetsMasterRepository;
import com.kindsonthegenius.thymeleafapp.services.SkillSetsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/skillSetsMasters")

public class SkillSetsMasterController {

    @Autowired
    private SkillSetsMasterRepository skillSetsMasterRepository;

    @Autowired
    private SkillSetsMasterService skillSetsMasterService ;

    @RequestMapping("/")
    public List<SkillSetsMaster> getAll(Model model) {
        List<SkillSetsMaster> skillSetsMasters = skillSetsMasterService.getAll();
        model.addAttribute("skillSetsMasters", skillSetsMasters);
        return skillSetsMasters;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<SkillSetsMaster> getOne(Integer Id) {
        return skillSetsMasterService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(SkillSetsMaster skillSetsMaster) throws Exception {
        skillSetsMasterService.addNew(skillSetsMaster);
        return "redirect:/skillSetsMaster/";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(SkillSetsMaster skillSetsMaster) {
        skillSetsMasterService.update(skillSetsMaster);
        return "redirect:/skillSetsMaster/";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        skillSetsMasterService.delete(Id);
        return "redirect:/skillSetsMaster/";
    }
}
