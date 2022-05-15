package com.kindsonthegenius.thymeleafapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class JobSeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_account_id;
    private String first_name;
    private String last_name;
    private Integer current_salary;
    private String salary_type;
    private String currency;

    public JobSeekerProfile() {

    }

    public Integer getuser_account_id() {
        return user_account_id;
    }

    public JobSeekerProfile(Integer id, String Firstname, String Lastname, Integer Currentsalary, String Salarytype, String currencys) {
        user_account_id = id;
        first_name = Firstname;
        last_name = Lastname;
        current_salary = Currentsalary;
        salary_type = Salarytype;
        currency = currencys;
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
}
