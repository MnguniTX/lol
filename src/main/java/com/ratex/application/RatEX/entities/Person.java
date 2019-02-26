package com.ratex.application.RatEX.entities;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//should not be an entity in the database
@MappedSuperclass
//class person
public class Person {

	// class attributes
	private String first_name;
	private String last_name;
	private String gender;
	@Temporal(TemporalType.DATE)
	private Date DOB;

	// default constructor
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public Person(String first_name, String last_name, String gender, Date dOB) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		DOB = dOB;
	}

	// Setters and getters

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Override
	// String representation of Person object
	public String toString() {
		return "Person [first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", DOB=" + DOB
				+ "]";
	}

}
