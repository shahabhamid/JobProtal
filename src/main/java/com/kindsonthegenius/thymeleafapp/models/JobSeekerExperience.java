package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity

public class JobSeekerExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer job_seeker_experience_id;
    private Boolean is_current_job;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date start_date;
    private Date end_date;

    private String job_title;
    private String company_name;
    private String job_location_city;
    private String job_location_state;
    private String job_location_country;
    private String description_of_job;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id",referencedColumnName = "user_account_id")
    private JobSeekerProfile jobSeekerProfile;
    public JobSeekerExperience() {

    }

    public JobSeekerExperience(Integer job_seeker_experience_id, Boolean is_current_job, Date start_date, Date end_date, String job_title, String company_name, String job_location_city, String job_location_state, String job_location_country, String description_of_job, JobSeekerProfile jobSeekerProfile) {
        this.job_seeker_experience_id = job_seeker_experience_id;
        this.is_current_job = is_current_job;
        this.start_date = start_date;
        this.end_date = end_date;
        this.job_title = job_title;
        this.company_name = company_name;
        this.job_location_city = job_location_city;
        this.job_location_state = job_location_state;
        this.job_location_country = job_location_country;
        this.description_of_job = description_of_job;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Integer getJob_seeker_experience_id() {
        return job_seeker_experience_id;
    }

    public void setJob_seeker_experience_id(Integer job_seeker_experience_id) {
        this.job_seeker_experience_id = job_seeker_experience_id;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Boolean getIs_current_job() {
        return is_current_job;
    }

    public void setIs_current_job(Boolean is_current_job) {
        this.is_current_job = is_current_job;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_location_city() {
        return job_location_city;
    }

    public void setJob_location_city(String job_location_city) {
        this.job_location_city = job_location_city;
    }

    public String getJob_location_state() {
        return job_location_state;
    }

    public void setJob_location_state(String job_location_state) {
        this.job_location_state = job_location_state;
    }

    public String getJob_location_country() {
        return job_location_country;
    }

    public void setJob_location_country(String job_location_country) {
        this.job_location_country = job_location_country;
    }

    public String getDescription_of_job() {
        return description_of_job;
    }

    public void setDescription_of_job(String description_of_job) {
        this.description_of_job = description_of_job;
    }

    @Override
    public String toString() {
        return "JobSeekerExperience{" +
                "job_seeker_experience_id=" + job_seeker_experience_id +
                ", is_current_job=" + is_current_job +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", job_title='" + job_title + '\'' +
                ", company_name='" + company_name + '\'' +
                ", job_location_city='" + job_location_city + '\'' +
                ", job_location_state='" + job_location_state + '\'' +
                ", job_location_country='" + job_location_country + '\'' +
                ", description_of_job='" + description_of_job + '\'' +
                ", jobSeekerProfile=" + jobSeekerProfile +
                '}';
    }
}
