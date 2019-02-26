package com.ratex.application.RatEX.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "bank")
//Class bean will be managed 
@Component

//Name of my class
public class Bank {

	// Specifying bank_id is a primary key
	@Id
	// Performing encapsulation
	// Bank attributes
	private int bank_id;
	private String bank_name;

	// Default constructor
	public Bank() {

	}

	// Parameterized constructor
	public Bank(int bank_id) {
		super();
		this.bank_id = bank_id;
	}

	// Parameterized constructor
	public Bank(int bank_id, String bank_name) {
		this.bank_id = bank_id;
		this.bank_name = bank_name;
	}

	// Setters and getters
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public int getBank_id() {
		return this.bank_id;
	}

	public String getBank_name() {
		return this.bank_name;
	}

	@Override
	// String representation of Bank object
	public String toString() {
		return "Bank ID: " + getBank_id() + "\nBank Name: " + getBank_name() + "\n\n";
	}
}
