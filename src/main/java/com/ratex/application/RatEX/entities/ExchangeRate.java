package com.ratex.application.RatEX.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "exchange_rate")
//Class bean will be managed 
@Component
//Name of my class
public class ExchangeRate {

	// Specifying id is a primary key
	@Id
	// Performing encapsulation
	@Column(name = "exchange_rate_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Unidirectional relationship with the Bank entity
	@ManyToOne(optional = false)
	// It is going to join with the bank_id attribute in the
	// Bank entity
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank_id;

	// Unidirectional relationship with the Currency entity
	@ManyToOne(optional = false)
	// It is going to join with the currency_id attribute in the
	// Currency entity
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency currency_id;

	// Put default date
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date created_date;

	// Put default time
	@UpdateTimestamp
	@Temporal(TemporalType.TIME)
	private Date created_time;

	private double buy_rate;

	// Default constructor
	public ExchangeRate() {

	}

	// Parameterized constructor
	public ExchangeRate(Bank bank_id, Currency currency_id, double buy_rate) {
		super();
		this.bank_id = bank_id;
		this.currency_id = currency_id;
		this.buy_rate = buy_rate;
	}

	// Parameterized constructor
	public ExchangeRate(Bank bank_id, Currency currency_id, Date created_date, double buy_rate) {
		super();
		this.bank_id = bank_id;
		this.currency_id = currency_id;
		this.created_date = created_date;
		this.buy_rate = buy_rate;
	}

	// Parameterized constructor
	public ExchangeRate(Bank bank_id, Currency currency_id, Date created_date, Date created_time, double buy_rate) {
		super();
		this.bank_id = bank_id;
		this.currency_id = currency_id;
		this.created_date = created_date;
		this.created_time = created_time;
		this.buy_rate = buy_rate;
	}

	// Setters and Getter
	public Bank getBank_id() {
		return bank_id;
	}

	public void setBank_id(Bank bank_id) {
		this.bank_id = bank_id;
	}

	public Currency getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(Currency currency_id) {
		this.currency_id = currency_id;
	}

	public Date getCreated_Date() {
		return created_date;
	}

	public void setDate(Date Created_date) {
		this.created_date = Created_date;
	}

	public double getBuy_rate() {
		return buy_rate;
	}

	public void setBuy_rate(double buy_rate) {
		this.buy_rate = buy_rate;
	}

	public Long getExchange_rate_id() {
		return id;
	}

	public void setExchange_rate_id(Long exchange_rate_id) {
		this.id = exchange_rate_id;
	}

	public Date getCreated_Time() {
		return created_time;
	}

	public void setCreated_Time(Date created_time) {
		this.created_time = created_time;
	}

	@Override
	// String representation of ExchangeRate object
	public String toString() {
		return "ExchangeRate [exchange_rate_id=" + id + ", bank_id=" + bank_id + ", currency_id=" + currency_id
				+ ", Created_date=" + created_date + ", Created_time=" + created_time + ", buy_rate=" + buy_rate + "]";
	}

}
