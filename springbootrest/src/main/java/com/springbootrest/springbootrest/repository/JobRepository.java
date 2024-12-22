package com.springbootrest.springbootrest.repository;

import com.springbootrest.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository {

    public List<JobPost>jobs=new ArrayList<>();

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }
}
