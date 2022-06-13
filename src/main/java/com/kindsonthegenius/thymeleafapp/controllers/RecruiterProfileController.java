package com.kindsonthegenius.thymeleafapp.controllers;

import com.kindsonthegenius.thymeleafapp.Utilities.FileUploadUtil;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {


    @Autowired
    private RecruiterProfileService recruiterProfileService;

    @Autowired
    private UsersRepository usersRepository;

    public void setRecruiterProfileService(RecruiterProfileService recruiterProfileService) {
        this.recruiterProfileService = recruiterProfileService;
    }

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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
    public String addNew(RecruiterProfile recruiterProfile, @RequestParam("image") MultipartFile multipartFile , Model model) throws  IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users user = usersRepository.findByEmail(currentUserName);
            recruiterProfile.setUser_id(user);
            recruiterProfile.setUser_account_id(user.getUser_id());
        }

        model.addAttribute("profile",recruiterProfile);
        String fileName="";
        if(!multipartFile.getOriginalFilename().equals("")){
            fileName = StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())));
            recruiterProfile.setProfile_photo(fileName);
        }


        RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

        String uploadDir = "user-photos/" + savedUser.getUser_account_id();
        try{
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }catch (Exception ex){ex.printStackTrace();}


        return "redirect:/dashboard/";
    }
    
}
