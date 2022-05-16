package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class JobPostActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private Integer posted_by_id;
    private Integer job_type_id;
    private Integer organization_id;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date created_date;
    private String description_of_job;
    private Integer job_location_id;
    private Boolean is_active;

    public JobPostActivity() {

    }
    public JobPostActivity(Integer id, Integer posted_by_id, Integer job_type_id, Integer organization_id, Date created_date, String description_of_job, Integer job_location_id, Boolean is_active) {
        Id = id;
        this.posted_by_id = posted_by_id;
        this.job_type_id = job_type_id;
        this.organization_id = organization_id;
        this.created_date = created_date;
        this.description_of_job = description_of_job;
        this.job_location_id = job_location_id;
        this.is_active = is_active;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getPosted_by_id() {
        return posted_by_id;
    }

    public void setPosted_by_id(Integer posted_by_id) {
        this.posted_by_id = posted_by_id;
    }

    public Integer getJob_type_id() {
        return job_type_id;
    }

    public void setJob_type_id(Integer job_type_id) {
        this.job_type_id = job_type_id;
    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getDescription_of_job() {
        return description_of_job;
    }

    public void setDescription_of_job(String description_of_job) {
        this.description_of_job = description_of_job;
    }

    public Integer getJob_location_id() {
        return job_location_id;
    }

    public void setJob_location_id(Integer job_location_id) {
        this.job_location_id = job_location_id;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
