package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

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
    private Blob resume;
    private Blob profile_photo;
    private Integer current_salary;
    private String salary_type;
    private String currency;


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

    public Integer getcurrent_salary() {
        return current_salary;
    }

    public void setcurrent_salary(Integer current_salary) {
        current_salary = current_salary;
    }

    public String getsalary_type() {
        return salary_type;
    }

    public void setsalary_type(String salary_type) {
        salary_type = salary_type;
    }

    public String getcurrency() {
        return currency;
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

    public Blob getResume() {
        return resume;
    }

    public void setResume(Blob resume) {
        this.resume = resume;
    }

    public Blob getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(Blob profile_photo) {
        this.profile_photo = profile_photo;
    }

    public Integer getCurrent_salary() {
        return current_salary;
    }

    public void setCurrent_salary(Integer current_salary) {
        this.current_salary = current_salary;
    }

    public String getSalary_type() {
        return salary_type;
    }

    public void setSalary_type(String salary_type) {
        this.salary_type = salary_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "user_account_id=" + user_account_id +
                ", user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", current_salary=" + current_salary +
                ", salary_type='" + salary_type + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
