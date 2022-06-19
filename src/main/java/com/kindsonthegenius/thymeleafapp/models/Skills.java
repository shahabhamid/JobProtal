package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;

@Entity
public class Skills {
    /*Not Done separate skills and skill set mapping because there is no option of adding or editing skills*/
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    private String experienceLevel;
    private String yearsOfExperience;

    @ManyToOne( cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "user_account_id")
    private JobSeekerProfile jobSeekerProfile;

    public Skills() {
    }

    public Skills(Integer id, String name, String experienceLevel, String yearsOfExperience) {
        Id = id;
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.yearsOfExperience = yearsOfExperience;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", experienceLevel='" + experienceLevel + '\'' +
                ", yearsOfExperience='" + yearsOfExperience + '\'' +
                ", jobSeekerProfile=" + jobSeekerProfile +
                '}';
    }
}

