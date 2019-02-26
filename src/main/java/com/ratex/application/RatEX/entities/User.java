package com.ratex.application.RatEX.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "Users")
@Component
public class User extends Person {

	// Performing encapsulation
	// User attributes
	// Specifying id is a primary key
	@Id
	// Performing encapsulation
	// Person attributes
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long user_id;
	@Column(unique = true)
	private String email;
	private String password;
	private String user_image;

	// Put default timestamp
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;

	// Default constructor

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public User(String first_name, String last_name, String gender, Date dOB, String email, String password,
			String user_image) {
		super(first_name, last_name, gender, dOB);
		this.email = email;
		this.password = password;
		this.user_image = user_image;
	}

	public User(long user_id, String email, String password) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
	}

	// Setters and getters
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
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

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	// String representation of User object
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", user_image=" + user_image
				+ ", created_date=" + created_date + "]";
	}

}
