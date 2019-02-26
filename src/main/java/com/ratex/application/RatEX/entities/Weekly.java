package com.ratex.application.RatEX.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "Weekly")
@Component
public class Weekly {
	
	// Performing encapsulation
		// Weekly attributes
		// Specifying id is a primary key
		@Id
		// Performing encapsulation
		@GeneratedValue(strategy = GenerationType.TABLE)
		private long id;
		private String bank;
		private String currency;
		private String day;
		@OneToOne
		// It is going to join with the user_id attribute in the
		// User entity
		@JoinColumn(name = "user_id", nullable = false)
		private User user_id;
		
		//Default constructor
		public Weekly() {
			super();
			// TODO Auto-generated constructor stub
		}

		//Parameterized constructor
		public Weekly( String bank, String currency, String day, User user_id) {
			super();
			
			this.bank = bank;
			this.currency = currency;
			this.day = day;
			this.user_id = user_id;
		}

		//Setters and getters
		
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		

		public User getUser_id() {
			return user_id;
		}

		public void setUser_id(User user_id) {
			this.user_id = user_id;
		}
		//String representation on the Weekly object
		@Override
		public String toString() {
			return "Weekly [id=" + id + ", bank=" + bank + ", currency=" + currency + ", day=" + day + ", user_id="
					+ user_id + "]";
		}
		
		
		
		
		
		
		
		
		
		

}
