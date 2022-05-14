package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Users {

	@Id
	private Integer userId;
	private Integer	userTypeId;
	private String email;
	private String password;
	private String dateOfBirth;
	private String gender;
	private String isActive;
	private String contactNumber;
	private Blob userImage;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registrationDate;

	public Users() {
	}

	public Users(Integer userId, Integer userTypeId, String email, String password, String dateOfBirth, String gender, String isActive, String contactNumber, Blob userImage, Date registrationDate) {
		this.userId = userId;
		this.userTypeId = userTypeId;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.isActive = isActive;
		this.contactNumber = contactNumber;
		this.userImage = userImage;
		this.registrationDate = registrationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Blob getUserImage() {
		return userImage;
	}

	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
