package com.ratex.application.RatEX.apicontrollers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratex.application.RatEX.implementations.UserImp;

//RESTFul web service
@RestController
//Map web requests to spring controller methods
@RequestMapping("/User")
public class UserEntryPoint {

	// Wiring the bean
	@Autowired
	UserImp user_implementation;

	// register user details
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public void register(@RequestParam String name, @RequestParam String surname, @RequestParam String gender,
			@RequestParam Date dOB, @RequestParam String email, @RequestParam String password,
			@RequestParam String user_image) {
		user_implementation.register(name, surname, gender, dOB, email, password, user_image);
	}

	// login
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	public boolean login(@RequestParam String email, @RequestParam String password) {
		return user_implementation.login(email, password);
	}

	// update user details
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public boolean update(@RequestParam String sessionEmail, @RequestParam String name, @RequestParam String surname,
			@RequestParam String email, @RequestParam String password) {
		return user_implementation.update(sessionEmail, name, surname, email, password);
	}
	// update password
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update_password")
	public boolean update_password(@RequestParam String sessionEmail, @RequestParam String password, @RequestParam String newPassword)
	{
		return user_implementation.update_password(sessionEmail, password, newPassword);
	}

	// logout
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/logout")
	public boolean logout(@RequestParam String email) {
		return user_implementation.logout(email);
	}

	// session status
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_status")
	public boolean get_status(@RequestParam String email) {
		return user_implementation.get_status(email);
	}

	// return user object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getUser")
	public Object showUser(@RequestParam String email) {
		return user_implementation.showUser(email);
	}
	
	//method to get weekly object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_weekly")
	public Object weekly_object(@RequestParam String email)
	{
		return user_implementation.weekly_object(email);
	}

	// return notification object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_notifications")
	public Object notifications_object(@RequestParam String email) {
		return user_implementation.notifications_object(email);
	}

	// ************************Objects of the graph
	// settings****************************
	// return USD_graph object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_USD_graph")
	public Object USD_graph_object(@RequestParam String email) {
		return user_implementation.USD_graph_object(email);
	}

	// return GBP_graph object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_GBP_graph")
	public Object GBP_graph_object(@RequestParam String email) {
		return user_implementation.GBP_graph_object(email);
	}

	// return EUR_graph object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_EUR_graph")
	public Object EUR_graph_object(@RequestParam String email) {
		return user_implementation.EUR_graph_object(email);
	}

	// return JPY_graph object
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get_JPY_graph")
	public Object JPY_graph_object(@RequestParam String email) {
		return user_implementation.JPY_graph_object(email);
	}

	// ************************Objects of the graph
	// settings****************************

	// Recover password
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/find_password")
	public boolean forgot_password(@RequestParam String email) {
		return user_implementation.forgot_password(email);
	}
	
	//method to get report based on the date
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/report")
	public void get_report(@RequestParam String email,@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,@RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date,@RequestParam String bank,@RequestParam String require){
		user_implementation.get_report(email, start_date, end_date, bank, require);
	}
	
	//method to get report graph
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/graph")
	public void get_graph(@RequestParam String email,@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date, @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end_date, @RequestParam String bank, @RequestParam String require)
	{
		user_implementation.get_graph(email, start_date, end_date, bank, require);
	}

	// **************************Change Notification State*************************
	// change USD notification state
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_notification")
	public void USD_notification(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_notification(email, state);
	}

	// change GBP notification state
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_notification")
	public void GBP_notification(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_notification(email, state);
	}

	// change EUR notification state
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_notification")
	public void EUR_notification(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_notification(email, state);
	}

	// change JPY notification state
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_notification")
	public void JPY_notification(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_notification(email, state);
	}
	// **************************Change Notification State************************
	
	// **************************Change Weekly State******************************
	// method to change weekly bank
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/bank")
		public void bank(@RequestParam String email, @RequestParam String bank)
		{
		user_implementation.bank(email, bank);
		}
		
		// method to change weekly currency
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/currency")
		public void currency(@RequestParam String email, @RequestParam String currency)
		{
		user_implementation.currency(email, currency);
		}
		
		// method to change weekly day
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("day")
		public void day(@RequestParam String email, @RequestParam String day)
		{
		user_implementation.day(email, day);
		}
		
		
	
	// **************************Change Weekly State******************************

	// **************************Graph USD Settings*******************************
	// method to get USD ABSA graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_ABSA")
	public void USD_ABSA(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_ABSA(email, state);
	}

	// method to get USD Bidvest graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_Bidvest")
	public void USD_Bidvest(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_Bidvest(email, state);
	}

	// method to get USD FNB graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_FNB")
	public void USD_FNB(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_FNB(email, state);
	}

	// method to get USD Nedbank graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_Nedbank")
	public void USD_Nedbank(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_Nedbank(email, state);
	}

	// method to get USD Standard graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/USD_Standard")
	public void USD_Standard(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.USD_Standard(email, state);
	}

	// **************************Graph USD Settings*******************************

	// **************************Graph GBP Settings*******************************
	// method to get GBP ABSA graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_ABSA")
	public void GBP_ABSA(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_ABSA(email, state);
	}

	// method to get GBP Bidvest graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_Bidvest")
	public void GBP_Bidvest(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_Bidvest(email, state);
	}

	// method to get GBP FNB graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_FNB")
	public void GBP_FNB(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_FNB(email, state);
	}

	// method to get GBP Nedbank graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_Nedbank")
	public void GBP_Nedbank(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_Nedbank(email, state);
	}

	// method to get GBP Standard graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/GBP_Standard")
	public void GBP_Standard(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.GBP_Standard(email, state);
	}

	// **************************Graph GBP Settings*******************************

	// **************************Graph EUR Settings*******************************
	// method to get EUR ABSA graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_ABSA")
	public void EUR_ABSA(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_ABSA(email, state);
	}

	// method to get EUR Bidvest graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_Bidvest")
	public void EUR_Bidvest(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_Bidvest(email, state);
	}

	// method to get EUR FNB graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_FNB")
	public void EUR_FNB(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_FNB(email, state);
	}

	// method to get EUR Nedbank graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_Nedbank")
	public void EUR_Nedbank(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_Nedbank(email, state);
	}

	// method to get EUR Standard graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EUR_Standard")
	public void EUR_Standard(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.EUR_Standard(email, state);
	}
	// **************************Graph EUR Settings*******************************

	// **************************Graph JPY Settings*******************************
	// method to get JPY ABSA graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_ABSA")
	public void JPY_ABSA(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_ABSA(email, state);
	}

	// method to get JPY Bidvest graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_Bidvest")
	public void JPY_Bidvest(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_Bidvest(email, state);
	}

	// method to get JPY FNB graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_FNB")
	public void JPY_FNB(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_FNB(email, state);
	}

	// method to get JPY Nedbank graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_Nedbank")
	public void JPY_Nedbank(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_Nedbank(email, state);
	}

	// method to get JPY Standard graph
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/JPY_Standard")
	public void JPY_Standard(@RequestParam String email, @RequestParam boolean state) {
		user_implementation.JPY_Standard(email, state);
	}
	// **************************Graph JPY Settings*******************************

}
