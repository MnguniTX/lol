package com.ratex.application.RatEX.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Notifications")
@Component
public class Notifications {

	// // Specifying id is a primary key
	@Id
	// Performing encapsulation
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long notification_id;
	@OneToOne
	// It is going to join with the user_id attribute in the
	// User entity
	@JoinColumn(name = "user_id", nullable = false)
	private User user_id;
	private boolean USD;
	private boolean GBP;
	private boolean EUR;
	private boolean JPY;

	// default constructor
	public Notifications() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notifications(User user_id, boolean uSD, boolean gBP, boolean eUR, boolean jPY) {
		super();
		this.user_id = user_id;
		USD = uSD;
		GBP = gBP;
		EUR = eUR;
		JPY = jPY;
	}

	public long getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(long notification_id) {
		this.notification_id = notification_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public boolean isUSD() {
		return USD;
	}

	public void setUSD(boolean uSD) {
		USD = uSD;
	}

	public boolean isGBP() {
		return GBP;
	}

	public void setGBP(boolean gBP) {
		GBP = gBP;
	}

	public boolean isEUR() {
		return EUR;
	}

	public void setEUR(boolean eUR) {
		EUR = eUR;
	}

	public boolean isJPY() {
		return JPY;
	}

	public void setJPY(boolean jPY) {
		JPY = jPY;
	}

	@Override
	public String toString() {
		return "Notifications [notification_id=" + notification_id + ", user_id=" + user_id + ", USD=" + USD + ", GBP="
				+ GBP + ", EUR=" + EUR + ", JPY=" + JPY + "]";
	}

}
