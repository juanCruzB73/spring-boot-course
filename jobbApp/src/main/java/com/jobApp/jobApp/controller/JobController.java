package com.jobApp.jobApp.controller;

import com.jobApp.jobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost, Model model) {
        System.out.println("JobPost received: " + jobPost);
        model.addAttribute("jobPost", jobPost); // Add jobPost object to the model
        return "succes";
    }
}
