package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.models.RecruiterProfile;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.services.RecruiterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {


    @Autowired
    private RecruiterProfileService recruiterProfileService;

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/")
    public String recruiter_profile(Model model) {

        RecruiterProfile recruiterProfile = new RecruiterProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users user = usersRepository.findByEmail(currentUserName);

            Optional<RecruiterProfile> recruiterProfiles = recruiterProfileService.getOne(user.getUser_id());
            if(recruiterProfiles.isPresent()) {
                recruiterProfile = recruiterProfiles.get();
                System.out.println(recruiterProfiles.get().toString());

            }
            model.addAttribute("profile",recruiterProfile);

        }
        return "recruiter-profile";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<RecruiterProfile> getOne(Integer Id) {
        return recruiterProfileService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(RecruiterProfile recruiterProfile, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users user = usersRepository.findByEmail(currentUserName);
            recruiterProfile.setUser_id(user);
            recruiterProfile.setUser_account_id(user.getUser_id());
        }
        System.out.println(recruiterProfile.toString());
        model.addAttribute("profile",recruiterProfile);
        recruiterProfileService.addNew(recruiterProfile);

        return "redirect:/recruiter-profile/";
    }


    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(RecruiterProfile recruiterProfile) {
        recruiterProfileService.update(recruiterProfile);
        return "redirect:/students/getAll";
    }


    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        recruiterProfileService.delete(Id);
        return "redirect:/students/getAll";
    }







}
