package com.kindsonthegenius.thymeleafapp.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity

public class JobSeekerEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer job_seeker_education_id;
    private String certificate_degree_name;
    private String major;
    private String institute_university_name;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date starting_date;
    private Date completion_date;
    private double percentage;
    private double cgpa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id",referencedColumnName = "user_account_id")
    private JobSeekerProfile jobSeekerProfile;
    public JobSeekerEducation() {

    }

    public JobSeekerEducation(Integer job_seeker_education_id, String certificate_degree_name, String major, String institute_university_name, Date starting_date, Date completion_date, double percentage, double cgpa, JobSeekerProfile jobSeekerProfile) {
        this.job_seeker_education_id = job_seeker_education_id;
        this.certificate_degree_name = certificate_degree_name;
        this.major = major;
        this.institute_university_name = institute_university_name;
        this.starting_date = starting_date;
        this.completion_date = completion_date;
        this.percentage = percentage;
        this.cgpa = cgpa;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Integer getJob_seeker_education_id() {
        return job_seeker_education_id;
    }

    public void setJob_seeker_education_id(Integer job_seeker_education_id) {
        this.job_seeker_education_id = job_seeker_education_id;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public String getCertificate_degree_name() {
        return certificate_degree_name;
    }

    public void setCertificate_degree_name(String certificate_degree_name) {
        this.certificate_degree_name = certificate_degree_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitute_university_name() {
        return institute_university_name;
    }

    public void setInstitute_university_name(String institute_university_name) {
        this.institute_university_name = institute_university_name;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
