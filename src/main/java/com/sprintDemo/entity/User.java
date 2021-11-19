package com.sprintDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends CustmorUser{
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	// need to unique and should not allow null value. store email in userName
	@Column(unique = true, nullable = false)
	private String userName;
	// you as developer define password complexity
	private String password;
	
	
	public User() {	
	}
	
	public User(long i, String userName, String password) {
		super();
		this.userId = i;
		this.userName = userName;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}


