package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class JobPostActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posted_by_id",referencedColumnName = "user_id")
    private Users posted_by_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_location_id",referencedColumnName = "Id")
    private JobLocation job_location_id;
    private Boolean is_active;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date created_date;
    private String description_of_job;

    private String job_type;
    private String remote;
    private Date posted_date;

    private String job_title;

    public JobPostActivity() {

    }

    public JobPostActivity(Integer id, Users posted_by_id, JobLocation job_location_id, Boolean is_active, Date created_date, String description_of_job, String job_type, String remote, Date posted_date, String job_title) {
        Id = id;
        this.posted_by_id = posted_by_id;
        this.job_location_id = job_location_id;
        this.is_active = is_active;
        this.created_date = created_date;
        this.description_of_job = description_of_job;
        this.job_type = job_type;
        this.remote = remote;
        this.posted_date = posted_date;
        this.job_title = job_title;
    }

    @Override
    public String toString() {
        return "JobPostActivity{" +
                "Id=" + Id +
                ", posted_by_id=" + posted_by_id +
                ", job_location_id=" + job_location_id.toString() +
                ", is_active=" + is_active +
                ", created_date=" + created_date +
                ", description_of_job='" + description_of_job + '\'' +
                ", job_type='" + job_type + '\'' +
                ", remote='" + remote + '\'' +
                ", posted_date=" + posted_date +
                ", job_title='" + job_title + '\'' +
                '}';
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public Date getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(Date posted_date) {
        this.posted_date = posted_date;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Users getPosted_by_id() {
        return posted_by_id;
    }

    public void setPosted_by_id(Users posted_by_id) {
        this.posted_by_id = posted_by_id;
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

    public JobLocation getJob_location_id() {
        return job_location_id;
    }

    public void setJob_location_id(JobLocation job_location_id) {
        this.job_location_id = job_location_id;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

}
