package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class JobPostSkillSetMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skill_set_id;
    private Integer job_post_id;
    private String skill_level;


    public JobPostSkillSetMapping() {

    }

    public JobPostSkillSetMapping(Integer skill_set_id, Integer job_post_id, String skill_level) {
        this.skill_set_id = skill_set_id;
        this.job_post_id = job_post_id;
        this.skill_level = skill_level;
    }

    public Integer getSkill_set_id() {
        return skill_set_id;
    }

    public void setSkill_set_id(Integer skill_set_id) {
        this.skill_set_id = skill_set_id;
    }

    public Integer getJob_post_id() {
        return job_post_id;
    }

    public void setJob_post_id(Integer job_post_id) {
        this.job_post_id = job_post_id;
    }

    public String getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(String skill_level) {
        this.skill_level = skill_level;
    }
}

