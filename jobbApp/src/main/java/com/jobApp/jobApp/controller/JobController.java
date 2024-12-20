package com.jobApp.jobApp.controller;

import com.jobApp.jobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class JobController {

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(Model model) {
        model.addAttribute("jobPost", new JobPost());
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost, Model model) {
        System.out.println("JobPost received: " + jobPost);
        model.addAttribute("jobPost", jobPost);
        return "succes";
    }
}