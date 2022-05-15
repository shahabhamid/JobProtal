package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class JobSeekerSkillSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_account_id;
    private Integer skill_set_id;
    private String skill_proficiency;

    public JobSeekerSkillSet() {

    }
    public Integer getUser_account_id() {
        return user_account_id;
    }
    public JobSeekerSkillSet(Integer id, Integer skillSetId, String skillProficiency) {
        user_account_id = id;
        skill_set_id = skillSetId;
        skill_proficiency = skillProficiency;
    }



    public void setUser_account_id(Integer user_account_id) {
        this.user_account_id = user_account_id;
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
}
