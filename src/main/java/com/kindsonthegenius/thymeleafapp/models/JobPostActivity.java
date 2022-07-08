package com.kindsonthegenius.thymeleafapp.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class JobPostActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer job_post_id;

    @ManyToOne
    @JoinColumn(name = "posted_by_id",referencedColumnName = "user_id")
    private Users posted_by_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_location_id",referencedColumnName = "Id")
    private JobLocation job_location_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_company_id",referencedColumnName = "Id")
    private JobCompany job_company_id;

    @Transient
    private Boolean is_active;
    @Transient
    private Boolean is_saved;


    @Length(max = 90000)
    private String description_of_job;
    private String job_type;
    private String salary;
    private String remote;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date posted_date;
    private String job_title;

    public JobPostActivity() {

    }
    public JobPostActivity(Integer id, String job_title,JobLocation job_location_id, JobCompany job_company_id) {
        job_post_id = id;
        this.job_title = job_title;
        this.job_company_id = job_company_id;
        this.job_location_id = job_location_id;
    }

    public JobPostActivity(Integer id, Users posted_by_id, JobLocation job_location_id, Boolean is_active, String description_of_job, String job_type, String salary, String remote, Date posted_date, String job_title) {
        job_post_id = id;
        this.posted_by_id = posted_by_id;
        this.job_location_id = job_location_id;
        this.is_active = is_active;
        this.description_of_job = description_of_job;
        this.job_type = job_type;
        this.salary = salary;
        this.remote = remote;
        this.posted_date = posted_date;
        this.job_title = job_title;
    }

    @Override
    public String toString() {
        return "JobPostActivity{" +
                "Id=" + job_post_id +
                ",\n posted_by_id=" + posted_by_id +
                ",\n job_location_id=" + job_location_id.toString() +
                ",\n job_company_id=" + job_company_id.toString() +
                ",\n is_active=" + is_active +
                ",\n description_of_job='" + description_of_job + '\'' +
                ",\n job_type='" + job_type + '\'' +
                ",\n salary='" + salary + '\'' +
                ",\n remote='" + remote + '\'' +
                ",\n posted_date=" + posted_date +
                ",\n job_title='" + job_title + '\'' +
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
        return job_post_id;
    }

    public void setId(Integer id) {
        job_post_id = id;
    }

    public Users getPosted_by_id() {
        return posted_by_id;
    }

    public void setPosted_by_id(Users posted_by_id) {
        this.posted_by_id = posted_by_id;
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
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    public JobCompany getJob_company_id() {
        return job_company_id;
    }

    public void setJob_company_id(JobCompany job_company_id) {
        this.job_company_id = job_company_id;
    }

    public Integer getJob_post_id() {
        return job_post_id;
    }

    public void setJob_post_id(Integer job_post_id) {
        this.job_post_id = job_post_id;
    }

    public Boolean getIs_saved() {
        return is_saved;
    }

    public void setIs_saved(Boolean is_saved) {
        this.is_saved = is_saved;
    }
}
