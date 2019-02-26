package com.ratex.application.RatEX.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "currency")
//Class bean will be managed 
@Component

//Name of my class
public class Currency {
	// Specifying currency_id is a primary key
	@Id
	// Performing encapsulation
	// Currency attributes
	private int currency_id;
	private String description;
	private String code;

	// Default constructor
	public Currency() {

	}

	// Parameterized constructor
	public Currency(int currency_id, String description, String code) {
		this.currency_id = currency_id;
		this.description = description;
		this.code = code;
	}

	// Setters and getters
	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCurrency_id() {
		return this.currency_id;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	@Override
	// String representation of Currency object
	public String toString() {
		return "Currency ID: " + getCurrency_id() + "\nDescription: " + getDescription() + "\nCode: " + getCode()
				+ "\n\n";
	}

}
