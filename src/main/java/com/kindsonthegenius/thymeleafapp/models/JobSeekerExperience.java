package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class JobSeekerExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_account_id;
    private String is_current_job;

    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date start_date;
    private Date end_date;

    private String job_title;
    private String company_name;
    private String job_location_city;
    private String job_location_state;
    private String job_location_country;
    private String description_of_job;

    public JobSeekerExperience() {

    }
    public JobSeekerExperience(Integer id, String currentJob, Date startingDate, Date endingDate,String jobTitle, String companyName, String jobCity, String jobState, String jobCountry, String jobDescription) {
        user_account_id = id;
        is_current_job = currentJob;
        start_date = startingDate;
        end_date = endingDate;
        job_title = jobTitle;
        company_name = companyName;
        job_location_city = jobCity;
        job_location_state = jobState;
        job_location_country = jobCountry;
        description_of_job = jobDescription;
    }

    public Integer getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(Integer user_account_id) {
        this.user_account_id = user_account_id;
    }

    public String getIs_current_job() {
        return is_current_job;
    }

    public void setIs_current_job(String is_current_job) {
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
}
