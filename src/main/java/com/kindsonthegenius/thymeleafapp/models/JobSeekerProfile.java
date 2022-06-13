package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class JobSeekerProfile implements Serializable {
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
    private String workAuthorization;
    private String employmentType;
    private String resume;
    private String profile_photo;

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    @OneToMany
    private List<Skills> skills;
    public String getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public JobSeekerProfile() {

    }

    public JobSeekerProfile(Users user_id) {
        this.user_id = user_id;
    }

    public void setuser_account_id(Integer user_account_id) {
        user_account_id = user_account_id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        last_name = last_name;
    }

    public void setcurrent_salary(Integer current_salary) {
        current_salary = current_salary;
    }

    public void setsalary_type(String salary_type) {
        salary_type = salary_type;
    }

    public void setcurrency(String currency) {
        currency = currency;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }


    @Transient
    public String getPhotosImagePath() {
        if (profile_photo == null || user_account_id == null) return null;

        return "/user-photos/" + user_account_id + "/" + profile_photo;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "user_account_id=" + user_account_id +
                ", user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", workAuthorization='" + workAuthorization + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", resume='" + resume + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", skills=" + skills.toString() +
                '}';
    }
}
