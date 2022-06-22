package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "users")

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer user_id;

	@OneToOne(mappedBy = "user_id")
	private JobSeekerProfile jobSeekerProfile;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_type_id",referencedColumnName = "user_type_id")
	private UsersType user_type_id;
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String password;
	private Boolean is_active;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registration_date;

	public Users() {
	}

	public Users(Integer user_id, UsersType user_type_id, String email, String password, Date registration_date) {
		this.user_id = user_id;
		this.user_type_id = user_type_id;
		this.email = email;
		this.password = password;
		this.is_active = is_active;
		this.registration_date = registration_date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public UsersType getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(UsersType user_type_id) {
		this.user_type_id = user_type_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}


	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public JobSeekerProfile getJobSeekerProfile() {
		return jobSeekerProfile;
	}

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		this.jobSeekerProfile = jobSeekerProfile;
	}

	@Override
	public String toString() {
		return "Users{" +
				"user_id=" + user_id +
				", user_type_id=" + user_type_id.toString() +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", is_active='" + is_active + '\'' +
				", registration_date=" + registration_date +
				'}';
	}
}
