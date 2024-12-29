package com.springbootrest.springbootrest.service;

import com.springbootrest.springbootrest.model.JobPost;
import com.springbootrest.springbootrest.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost){
        jobRepository.save(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return jobRepository.findAll();
    }

    public JobPost getJobById(int id) {
        return  jobRepository.findById(id).orElse(new JobPost()) ;
    }

    public JobPost editJobs(JobPost jobPost) {
        return jobRepository.save(jobPost);

    }

    public void deleteJobs(int id) {
        jobRepository.deleteById(id);
    }

    public void load() {
        JobPost jobPost = new JobPost();
        JobPost jobPost1 = new JobPost();

        jobPost.setPostId(1);
        jobPost.setPostProfile("braaaa");
        jobPost.setPostDesc("React dev");
        jobPost.setReqExperience(1);
        jobPost.setPostTechStack(List.of("TypesScript","JavaScript","Redux"));

        jobPost1.setPostId(2);
        jobPost1.setPostProfile("brOOOO");
        jobPost1.setPostDesc("java dev");
        jobPost1.setReqExperience(1);
        jobPost1.setPostTechStack(List.of("Java","Spring","SpringBoot"));

        List<JobPost> jobs = new ArrayList<>();

        jobs.add(jobPost);
        jobs.add(jobPost1);

        jobRepository.saveAll(jobs);

    }


    public List<JobPost> search(String keyword) {
        return jobRepository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
