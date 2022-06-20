package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
public class JobCompany {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    private String logo;

    public JobCompany()
    {

    }
    public JobCompany(Integer id, String name, String logo) {
        Id = id;
        this.name = name;
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "JobCompany{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", logo=" + logo +
                '}';
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Transient
    public String getPhotosImagePath() {
        if (logo == null || Id == null) return null;

        return "/company-photos/" + Id + "/" + logo;
    }
}
