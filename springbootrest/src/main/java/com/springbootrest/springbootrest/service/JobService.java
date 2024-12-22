package com.springbootrest.springbootrest.service;

import com.springbootrest.springbootrest.model.JobPost;
import com.springbootrest.springbootrest.repository.JobRepository;
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
