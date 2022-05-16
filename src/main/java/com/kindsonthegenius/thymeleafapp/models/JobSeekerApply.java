package com.kindsonthegenius.thymeleafapp.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class JobSeekerApply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_account_id;
    private Integer job_post_id;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date apply_date;
    private String apply_response;

    public JobSeekerApply() {

    }

    public JobSeekerApply(Integer user_account_id, Integer job_post_id, Date apply_date, String apply_response) {
        this.user_account_id = user_account_id;
        this.job_post_id = job_post_id;
        this.apply_date = apply_date;
        this.apply_response = apply_response;
    }

    public Integer getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(Integer user_account_id) {
        this.user_account_id = user_account_id;
    }

    public Integer getJob_post_id() {
        return job_post_id;
    }

    public void setJob_post_id(Integer job_post_id) {
        this.job_post_id = job_post_id;
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public String getApply_response() {
        return apply_response;
    }

    public void setApply_response(String apply_response) {
        this.apply_response = apply_response;
    }
}
