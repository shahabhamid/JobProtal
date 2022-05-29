package com.kindsonthegenius.thymeleafapp.controllers;



import antlr.StringUtils;
import com.kindsonthegenius.thymeleafapp.models.Document;
import com.kindsonthegenius.thymeleafapp.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.*;
import java.io.IOException;


@Controller
@RequestMapping("/document")

public class documentController {
    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping("/")
    public String viewDocumentPage()
    {
        return "document";
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("document")MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        Document document = new Document();
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize((int) multipartFile.getSize());
        documentRepository.save(document);
        redirectAttributes.addFlashAttribute("message", "This file has been uploaded");
        return  "redirect:/";

    }

}
