package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_type")

public class UsersType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_type_id")
	private Integer user_type_id;
	private String user_type_name;
	@OneToMany(targetEntity = Users.class,mappedBy = "user_type_id", cascade = {
			CascadeType.ALL
	})
	private List<Users> users;

	public UsersType() {
	}

	@Override
	public String toString() {
		return "UsersType{" +
				"user_type_id=" + user_type_id +
				", user_type_name='" + user_type_name + '\'' +
				'}';
	}

	public UsersType(Integer user_type_id, String user_type_name) {
		this.user_type_id = user_type_id;
		this.user_type_name = user_type_name;
	}

	public Integer getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(Integer user_type_id) {
		this.user_type_id = user_type_id;
	}

	public String getUser_type_name() {
		return user_type_name;
	}

	public void setUser_type_name(String user_type_name) {
		this.user_type_name = user_type_name;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
}
