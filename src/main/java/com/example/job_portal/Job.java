package com.example.job_portal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String title;
    private String location;
    private int salary;
    private String company;

public Job(){}

public Job(Integer id,String title,String location,int salary,String company){
     this.title=title;
     this.id=id;
     this.location=location;
     this.salary=salary;
     this.company=company;

}
   // Getter and Setter methods for all properties
  public Integer getId(){
    return id;
  }
  public String getTitle(){
    return title;
  }
  public String getLocation(){
    return location;
  }
  public int getSalary(){
    return salary;
  }
  public void setId(Integer id){
    this.id=id;
  }
  public void setTitle(String title){
    this.title=title;
  }
  public void setLocation(String location){
    this.location=location;
  }
  public void setSalary(int salary){
    this.salary=salary;
  }
  public String getCompany(){
    return company;
  }
  public void setCompany(String company){
    this.company=company;
  }
}
