package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "users")

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer user_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_type_id",referencedColumnName = "user_type_id")
	private UsersType user_type_id;
	private String email;
	private String password;
	private String date_of_birth;
	private String gender;
	private String is_active;
	private String contact_number;

	public Users(Integer user_id, UsersType user_type_id, String email, String password, String date_of_birth, String gender, String is_active, String contact_number, Blob user_image, Date registration_date) {
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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
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

	private Blob user_image;

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

	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registration_date;

	public Users() {
	}

}
