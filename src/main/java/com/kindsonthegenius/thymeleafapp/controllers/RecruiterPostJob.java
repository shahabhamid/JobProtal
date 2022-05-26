package com.kindsonthegenius.thymeleafapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/add-jobs")
public class RecruiterPostJob {

    @RequestMapping("/")
    public String getAll(Model model) {
        return "add-jobs";
    }

}
