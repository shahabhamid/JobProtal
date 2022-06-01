package com.kindsonthegenius.thymeleafapp.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class JobSeekerApply implements Serializable {
    @Id
    private Integer user_account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id",referencedColumnName = "user_account_id")
    @MapsId
    private JobSeekerProfile user_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_post_id",referencedColumnName = "Id")
    private JobPostActivity job_post_id;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date apply_date;
    private String cover_letter;

    public JobSeekerApply() {

    }

    public JobSeekerApply(Integer user_account, JobSeekerProfile user_id, JobPostActivity job_post_id, Date apply_date, String cover_letter) {
        this.user_account = user_account;
        this.user_id = user_id;
        this.job_post_id = job_post_id;
        this.apply_date = apply_date;
        this.cover_letter = cover_letter;
    }

    public Integer getUser_account_id() {
        return user_account;
    }

    public void setUser_account_id(Integer user_account) {
        this.user_account = user_account;
    }

    public JobSeekerProfile getUser_id() {
        return user_id;
    }

    public void setUser_id(JobSeekerProfile user_id) {
        this.user_id = user_id;
    }

    public JobPostActivity getJob_post_id() {
        return job_post_id;
    }

    public void setJob_post_id(JobPostActivity job_post_id) {
        this.job_post_id = job_post_id;
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public String getCover_letter() {
        return cover_letter;
    }

    public void setCover_letter(String cover_letter) {
        this.cover_letter = cover_letter;
    }

    @Override
    public String toString() {
        return "JobSeekerApply{" +
                "user_account=" + user_account +
                ", user_id=" + user_id +
                ", job_post_id=" + job_post_id +
                ", apply_date=" + apply_date +
                ", apply_response='" + cover_letter + '\'' +
                '}';
    }
}
