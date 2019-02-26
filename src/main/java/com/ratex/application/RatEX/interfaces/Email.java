package com.ratex.application.RatEX.interfaces;

//interface Email
public interface Email {
	// method to send forgot email
	public void send(String from, String password, String to, String sub, String msg);
	// method to send report table
	public void send_report(String from, String password, String to, String sub, String msg);
	// method to send report graph
	public void send_graph(String from, String password, String to, String sub, String msg);
	

}
