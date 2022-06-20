package com.kindsonthegenius.thymeleafapp.models;

public interface RecruiterJobs {
    Long getTotalCandidates();
    public int getJob_post_id();
    public String getJob_title();

    public int getLocationId();
    public String getCity();
    public String getState();
    public String getCountry();
    public int getCompanyId();
    public String getName();

}
