package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SkillSetsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String skill_set_name;

    public SkillSetsMaster() {

    }
    public Integer getId() {
        return Id;
    }

    public SkillSetsMaster(Integer id, String skillSetName) {
        Id = id;
        skill_set_name = skillSetName;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSkill_set_name() {
        return skill_set_name;
    }

    public void setSkill_set_name(String skill_set_name) {
        this.skill_set_name = skill_set_name;
    }

    @Override
    public String toString() {
        return "SkillSetsMaster{" +
                "Id=" + Id +
                ", skill_set_name='" + skill_set_name + '\'' +
                '}';
    }
}
