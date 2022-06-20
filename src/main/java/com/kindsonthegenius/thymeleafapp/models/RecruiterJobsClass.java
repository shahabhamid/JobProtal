package com.kindsonthegenius.thymeleafapp.models;

public class RecruiterJobsClass {
    private Long totalCandidates;
    private Integer job_post_id;
    private String job_title;
    private JobLocation job_location_id;
    private JobCompany job_company_id;

    public RecruiterJobsClass(Long totalCandidates, Integer job_post_id, String job_title, JobLocation job_location_id, JobCompany job_company_id) {
        this.totalCandidates = totalCandidates;
        this.job_post_id = job_post_id;
        this.job_title = job_title;
        this.job_location_id = job_location_id;
        this.job_company_id = job_company_id;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public Integer getJob_post_id() {
        return job_post_id;
    }

    public void setJob_post_id(Integer job_post_id) {
        this.job_post_id = job_post_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public JobLocation getJob_location_id() {
        return job_location_id;
    }

    public void setJob_location_id(JobLocation job_location_id) {
        this.job_location_id = job_location_id;
    }

    public JobCompany getJob_company_id() {
        return job_company_id;
    }

    public void setJob_company_id(JobCompany job_company_id) {
        this.job_company_id = job_company_id;
    }
}
