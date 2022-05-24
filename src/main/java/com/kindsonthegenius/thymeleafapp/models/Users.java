package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Blob;
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
	@Size(min = 8)
	private String password;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date date_of_birth;
	private String gender;
	private Boolean is_active;
	private String contact_number;
	private Blob user_image;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registration_date;

	public Users(Integer user_id, UsersType user_type_id, String email, String password, Date date_of_birth, String gender, Boolean is_active, String contact_number, Blob user_image, Date registration_date) {
		this.user_id = user_id;
		this.user_type_id = user_type_id;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.is_active = is_active;
		this.contact_number = contact_number;
		this.user_image = user_image;
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

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public Blob getUser_image() {
		return user_image;
	}

	public void setUser_image(Blob user_image) {
		this.user_image = user_image;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}


	@Override
	public String toString() {
		return "Users{" +
				"user_id=" + user_id +
				", user_type_id=" + user_type_id.toString() +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", date_of_birth='" + date_of_birth + '\'' +
				", gender='" + gender + '\'' +
				", is_active='" + is_active + '\'' +
				", contact_number='" + contact_number + '\'' +
				", user_image=" + user_image +
				", registration_date=" + registration_date +
				'}';
	}



	public Users() {
	}

}
