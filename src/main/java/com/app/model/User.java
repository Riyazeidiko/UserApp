package com.app.model;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User_tab")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int userid;
	private String userName;
	private String password;
	private String role;
	private String description;
	private char userActive;
	private Date createdDate;
	private Date updatedDate;
	public User() {
		super();
	}
	public User(String userName, String password, String role, String description, char userActive, Date createdDate,
			Date updatedDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.description = description;
		this.userActive = userActive;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getUserActive() {
		return userActive;
	}
	public void setUserActive(char userActive) {
		this.userActive = userActive;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", description=" + description + ", userActive=" + userActive + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
}
