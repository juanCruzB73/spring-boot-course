package com.springbootrest.springbootrest.controller;

import com.springbootrest.springbootrest.model.JobPost;
import com.springbootrest.springbootrest.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("jobposts/{id}")
    @ResponseBody
    public JobPost getJobById(@PathVariable("id") int id){
        return jobService.getJobById(id);
    }

    @PostMapping("jobposts")
    public JobPost addJob(@RequestBody JobPost job){
        jobService.addJob(job);
        return jobService.getJobById(job.getPostId());
    }

    @PutMapping("jobposts/{id}")
    public JobPost editJob(@RequestBody JobPost jobPost){

        jobService.editJobs(jobPost);

        return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("jobposts/{id}")
    public String deleteJob(@PathVariable int id){
        jobService.deleteJobs(id);
        return "deleated";
    }
}