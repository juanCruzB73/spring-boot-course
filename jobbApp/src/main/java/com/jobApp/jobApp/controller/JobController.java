package com.jobApp.jobApp.controller;

import com.jobApp.jobApp.model.JobPost;
import com.jobApp.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

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
        model.addAttribute("jobPost", jobPost);
        jobService.addJob(jobPost);
        return "succes";
    }
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model){
        List<JobPost>jobPosts=jobService.getAllJobs();
        System.out.println("JobPost received: " + jobPosts);
        model.addAttribute("jobPosts", jobPosts);

        return "viewalljobs";
    }
}