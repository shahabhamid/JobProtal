package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"userId", "job"})
})
public class JobSeekerSave implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "user_account_id")
    private JobSeekerProfile userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job",referencedColumnName = "job_post_id")
    private JobPostActivity job;

    public JobSeekerSave() {

    }

    public JobSeekerSave(Integer user_account, JobSeekerProfile user_id, JobPostActivity job_post_id, Date apply_date, String cover_letter) {
        this.id = user_account;
        this.userId = user_id;
        this.job = job_post_id;
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
                "\n, user_id=" + userId.toString() +
                "\n, job_post_id=" + job.toString() +
                '}';
    }
}
