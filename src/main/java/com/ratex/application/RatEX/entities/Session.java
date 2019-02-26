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
@Table(name = "Session")
@Component
public class Session {

	// // Specifying id is a primary key
	@Id
	// Performing encapsulation
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long session_id;
	@OneToOne
	// It is going to join with the email attribute in the
	// User entity
	@JoinColumn(name = "user_id", nullable = false)
	private User user_id;
	private boolean session_state;

	// default constructor
	public Session() {
		super();
	}

	// parameterized constructor
	public Session(User user_id, boolean session_state) {
		super();
		this.user_id = user_id;
		this.session_state = session_state;
	}

	// setters and getters
	public long getSession_id() {
		return session_id;
	}

	public void setSession_id(long session_id) {
		this.session_id = session_id;
	}

	public boolean isSession_state() {
		return session_state;
	}

	public void setSession_state(boolean session_state) {
		this.session_state = session_state;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Session [session_state=" + session_state + "]";
	}

}
