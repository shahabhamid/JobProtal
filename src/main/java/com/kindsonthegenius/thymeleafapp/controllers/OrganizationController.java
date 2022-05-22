package com.kindsonthegenius.thymeleafapp.controllers;


import com.kindsonthegenius.thymeleafapp.models.Organization;

import com.kindsonthegenius.thymeleafapp.repositories.OrganizationRepository;

import com.kindsonthegenius.thymeleafapp.services.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/organization")

public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationService organizationService ;

    @RequestMapping("/")
    public List<Organization> getAll(Model model) {
        List<Organization> organization = organizationService.getAll();
        model.addAttribute("organization", organization);
        return organization;
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Organization> getOne(Integer Id) {
        return organizationService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(Organization organization) throws Exception {
        organizationService.addNew(organization);
        return "redirect:/organization/";
    }
    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Organization organization) {
        organizationService.update(organization);
        return "redirect:/organization/";
    }
    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        organizationService.delete(Id);
        return "redirect:/organization/";
    }

}
