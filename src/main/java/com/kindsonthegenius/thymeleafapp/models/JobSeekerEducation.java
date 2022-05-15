package com.kindsonthegenius.thymeleafapp.models;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class JobSeekerEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_account_id;
    private String certificate_degree_name;
    private String major;
    private String institute_university_name;

    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date starting_date;
    private Date completion_date;

    private double percentage;
    private double cgpa;

    public JobSeekerEducation() {

    }
    public Integer getUser_account_id() {
        return user_account_id;
    }

    public JobSeekerEducation(Integer id, String certificateDegreeName, String Major, String instituteUniversityName, Date startDate, Date endDate, Double percent, Double gpa) {
        user_account_id = id;
        certificate_degree_name = certificateDegreeName;
        major = Major;
        institute_university_name = instituteUniversityName;
        starting_date = startDate;
        completion_date = endDate;
        percentage = percent;
        cgpa = gpa;
    }



    public void setUser_account_id(Integer user_account_id) {
        this.user_account_id = user_account_id;
    }

    public String getCertificate_degree_name() {
        return certificate_degree_name;
    }

    public void setCertificate_degree_name(String certificate_degree_name) {
        this.certificate_degree_name = certificate_degree_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitute_university_name() {
        return institute_university_name;
    }

    public void setInstitute_university_name(String institute_university_name) {
        this.institute_university_name = institute_university_name;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
