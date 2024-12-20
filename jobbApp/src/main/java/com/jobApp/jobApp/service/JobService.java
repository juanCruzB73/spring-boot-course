package com.jobApp.jobApp.service;

import com.jobApp.jobApp.model.JobPost;
import com.jobApp.jobApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost){
        jobRepository.addJob(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return jobRepository.getAllJobs();
    }

}
