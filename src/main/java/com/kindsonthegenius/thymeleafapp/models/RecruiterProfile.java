package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity

public class RecruiterProfile implements Serializable {
    @Id
    private Integer user_account_id;
    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users user_id;
    private String first_name;
    private String last_name;
    private String city;
    private String state;
    private String country;
    private String company;
    private Blob profile_photo;

    public RecruiterProfile() {

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public RecruiterProfile(Integer user_account_id, Users user_id, String first_name, String last_name, String city, String state, String country, String company, Blob profile_photo) {
        this.user_account_id = user_account_id;
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.company = company;
        this.profile_photo = profile_photo;
    }

    @Override
    public String toString() {
        return "RecruiterProfile{" +
                "user_account_id=" + user_account_id +
                ", user_id=" + user_id.toString() +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", profile_photo=" + profile_photo +
                '}';
    }

    public Integer getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(Integer user_account_id) {
        this.user_account_id = user_account_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Blob getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(Blob profile_photo) {
        this.profile_photo = profile_photo;
    }
}
