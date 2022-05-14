package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class UsersType {

	@Id
	private Integer userTypeId;
	private String userTypeName;

	public UsersType(Integer userTypeId, String userTypeName) {
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
	}

	public UsersType() {
	}

	public Integer getUserTypeId() {
		return this.userTypeId;
	}
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName() {
		return this.userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
}
