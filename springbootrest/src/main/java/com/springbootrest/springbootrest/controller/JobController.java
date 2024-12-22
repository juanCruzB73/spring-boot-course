package com.springbootrest.springbootrest.controller;

import com.springbootrest.springbootrest.model.JobPost;
import com.springbootrest.springbootrest.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("jobposts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
}