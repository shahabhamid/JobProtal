package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class JobLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String city;
    private String state;
    private String country;
    private Integer zip;
    public JobLocation() {

    }

    public JobLocation(Integer id, String city, String state, String country, Integer zip) {
        Id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "JobLocation{" +
                "Id=" + Id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip=" + zip +
                '}';
    }
}
