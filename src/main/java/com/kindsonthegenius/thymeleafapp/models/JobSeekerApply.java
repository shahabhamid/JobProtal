package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"userId", "job"})
})
public class JobSeekerApply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "user_account_id")
    private JobSeekerProfile userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job",referencedColumnName = "job_post_id")
    private JobPostActivity job;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date apply_date;
    private String cover_letter;

    public JobSeekerApply() {

    }

    public JobSeekerApply(Integer user_account, JobSeekerProfile user_id, JobPostActivity job_post_id, Date apply_date, String cover_letter) {
        this.id = user_account;
        this.userId = user_id;
        this.job = job_post_id;
        this.apply_date = apply_date;
        this.cover_letter = cover_letter;
    }



    public JobSeekerProfile getUser_id() {
        return userId;
    }

    public void setUser_id(JobSeekerProfile user_id) {
        this.userId = user_id;
    }

    public JobPostActivity getJob() {
        return job;
    }

    public void setJob(JobPostActivity job) {
        this.job = job;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JobSeekerApply{" +
                "user_account=" + id +
                ", user_id=" + userId +
                ", job_post_id=" + job +
                ", apply_date=" + apply_date +
                ", apply_response='" + cover_letter + '\'' +
                '}';
    }
}
