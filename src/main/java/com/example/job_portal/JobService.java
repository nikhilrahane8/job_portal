package com.example.job_portal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class JobService {
    private final JobRepository jobRepository;


    public JobService(JobRepository jobRepository){
         this.jobRepository = jobRepository;
       
    }
    public List<Job> getJobs(){
        return jobRepository.findAll();
    }
    public Job addJobs(Job job){
         return jobRepository.save(job);
    }
    public Job getById(int id){
       
        return jobRepository.findById(id).orElse(null);
    }
    public void updateJob(int id, Job updatedJob) {
          Job job = jobRepository.findById(id).orElse(null);
    
        if (job!=null){
            job.setTitle(updatedJob.getTitle());
            job.setLocation(updatedJob.getLocation());
            job.setSalary(updatedJob.getSalary());
            job.setCompany(updatedJob.getCompany());
        }
       jobRepository.save(job);
}
public void deleteJob(int id){
    jobRepository.deleteById(id);
    
}

}
