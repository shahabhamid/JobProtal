package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;

@Entity


public class JobSeekerSkillSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skill_set_id;
    private String skill_proficiency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id",referencedColumnName = "user_account_id")
    private JobSeekerProfile jobSeekerProfile;
    public JobSeekerSkillSet() {

    }

    public JobSeekerSkillSet(Integer skill_set_id, String skill_proficiency, JobSeekerProfile jobSeekerProfile) {
        this.skill_set_id = skill_set_id;
        this.skill_proficiency = skill_proficiency;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Integer getSkill_set_id() {
        return skill_set_id;
    }

    public void setSkill_set_id(Integer skill_set_id) {
        this.skill_set_id = skill_set_id;
    }

    public String getSkill_proficiency() {
        return skill_proficiency;
    }

    public void setSkill_proficiency(String skill_proficiency) {
        this.skill_proficiency = skill_proficiency;
    }

    @Override
    public String toString() {
        return "JobSeekerSkillSet{" +
                "skill_set_id=" + skill_set_id +
                ", skill_proficiency='" + skill_proficiency + '\'' +
                ", jobSeekerProfile=" + jobSeekerProfile.toString() +
                '}';
    }
}
