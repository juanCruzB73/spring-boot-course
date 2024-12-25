package com.springbootrest.springbootrest.repository;

import com.springbootrest.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


    /*public List<JobPost>jobs=new ArrayList<>();

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJobById(int id) {
        for(JobPost job : jobs){
            if(job.getPostId() == id){
                return job;
            }
        }
        return null;
    }

    public JobPost editJobs(JobPost jobPost) {
        for(JobPost job: jobs){
            if (job.getPostId() == jobPost.getPostId()){
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
                return job;
            }
        }
        return null;
    }

    public void deleteJobs(int id) {
        for(JobPost job : jobs){
            if(job.getPostId() == id){
                jobs.remove(job);
            }
        }
    }*/
}
