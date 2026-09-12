package com.example.job_portal;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class JobController {
   private final JobService jobService;

public JobController(JobService jobService){
    this.jobService=jobService;
}


    @GetMapping("/all_jobs")
    public List<Job> getJobs(){
        return  jobService.getJobs();
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
      Job job1= jobService.addJobs(job);
      return ResponseEntity.status(HttpStatus.CREATED).body(job1);

    }
    @GetMapping("/all_jobs/{id}")
    public ResponseEntity<Job> getById(@PathVariable int id){
        
       Job job=jobService.getById(id);
       if (job!=null){
        return ResponseEntity.ok(job);
       }
       else {
        return ResponseEntity.notFound().build();
       }
    }

    @PutMapping("/jobs/{id}")
    public void update(@PathVariable int id,@RequestBody Job job){
       jobService.updateJob(id, job);  
    }

    @DeleteMapping("/jobs/{id}")
    public void delete(@PathVariable int id){
        jobService.deleteJob(id);
    }
}
