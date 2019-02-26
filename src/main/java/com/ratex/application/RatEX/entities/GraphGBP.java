package com.ratex.application.RatEX.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//Specifying its an entity
@Entity
//Entity name
@Table(name = "graph_GBP")
//Class bean will be managed 
@Component
//Name of my class
public class GraphGBP {

	// Specifying id is a primary key
	@Id
	// Performing encapsulation
	@Column(name = "graph_usd_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	// It is going to join with the user_id attribute in the
	// User entity
	@JoinColumn(name = "user_id", nullable = false)
	private User user_id;
	private boolean ABSA;
	private boolean Bidvest;
	private boolean FNB;
	private boolean Nedbank;
	private boolean Standard;
	private boolean show_graph;

	// default constructor
	public GraphGBP() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public GraphGBP(User user_id, boolean aBSA, boolean bidvest, boolean fNB, boolean nedbank, boolean standard,
			boolean show_graph) {
		super();
		this.user_id = user_id;
		ABSA = aBSA;
		Bidvest = bidvest;
		FNB = fNB;
		Nedbank = nedbank;
		Standard = standard;
		this.show_graph = show_graph;
	}

	// setters and getters
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public boolean isABSA() {
		return ABSA;
	}

	public void setABSA(boolean aBSA) {
		ABSA = aBSA;
	}

	public boolean isBidvest() {
		return Bidvest;
	}

	public void setBidvest(boolean bidvest) {
		Bidvest = bidvest;
	}

	public boolean isFNB() {
		return FNB;
	}

	public void setFNB(boolean fNB) {
		FNB = fNB;
	}

	public boolean isNedbank() {
		return Nedbank;
	}

	public void setNedbank(boolean nedbank) {
		Nedbank = nedbank;
	}

	public boolean isStandard() {
		return Standard;
	}

	public void setStandard(boolean standard) {
		Standard = standard;
	}

	public boolean isShow_graph() {
		return show_graph;
	}

	public void setShow_graph(boolean show_graph) {
		this.show_graph = show_graph;
	}

	// String representation of GraphGBP object
	@Override
	public String toString() {
		return "GraphGBP [id=" + id + ", user_id=" + user_id + ", ABSA=" + ABSA + ", Bidvest=" + Bidvest + ", FNB="
				+ FNB + ", Nedbank=" + Nedbank + ", Standard=" + Standard + ", show_graph=" + show_graph + "]";
	}

}
