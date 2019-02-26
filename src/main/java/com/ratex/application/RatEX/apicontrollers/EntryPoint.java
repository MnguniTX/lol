package com.ratex.application.RatEX.apicontrollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ratex.application.RatEX.implementations.DisplayImp;

//RESTFul web service
@RestController
//Map web requests to spring controller methods
@RequestMapping("/Methods")
public class EntryPoint {
	// Wiring the bean
	@Autowired
	DisplayImp display;

	// method oldData() that returns latest before latest data
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Old")
	public List<Object> oldData() {
		return display.oldData();
	}

	// method newData() that returns latest data
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/New")
	public List<Object> newData() {
		return display.newData();
	}

	// method Eur() that returns lowest EURO
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Eur")
	public Object EUR() {
		return display.EUR();
	}

	// method Usd() that returns lowest USD
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Usd")
	public Object USD() {
		return display.USD();
	}

	// method Gbp() that returns lowest GBP
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Gbp")
	public Object GBP() {
		return display.GBP();
	}

	// method Jpy() that returns lowest JPY
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Jpy")
	public Object JPY() {
		return display.JPY();
	}

	// method date() that returns the current date
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/date")
	public Object date() {
		return display.date();
	}

	// method time() that returns the list of time
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/time")
	public List<Object> time() {
		return display.time();
	}

	// method new_time() that returns the new time
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/new_time")
	public Object new_time() {
		return display.new_time();
	}

	// ****************History methods for USD*********
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ABSA_Usd")
	public List<Object> ABSA_USD() {
		return display.ABSA_USD();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Bidvest_Usd")
	public List<Object> Bidvest_USD() {
		return display.Bidvest_USD();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/FNB_Usd")
	public List<Object> FNB_USD() {
		return display.FNB_USD();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Nedbank_Usd")
	public List<Object> Nedbank_USD() {
		return display.Nedbank_USD();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Standard_Usd")
	public List<Object> Standard_USD() {
		return display.Standard_USD();
	}
	// ****************History methods for USD*********

	// ****************History methods for GBP*********
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ABSA_Gbp")
	public List<Object> ABSA_GBP() {
		return display.ABSA_GBP();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Bidvest_Gbp")
	public List<Object> Bidvest_GBP() {
		return display.Bidvest_GBP();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/FNB_Gbp")
	public List<Object> FNB_GBP() {
		return display.FNB_GBP();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Nedbank_Gbp")
	public List<Object> Nedbank_GBP() {
		return display.Nedbank_GBP();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Standard_Gbp")
	public List<Object> Standard_GBP() {
		return display.Standard_GBP();
	}
	// ****************History methods for GBP*********

	// ****************History methods for EUR*********
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ABSA_Eur")
	public List<Object> ABSA_EUR() {
		return display.ABSA_EUR();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Bidvest_Eur")
	public List<Object> Bidvest_EUR() {
		return display.Bidvest_EUR();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/FNB_Eur")
	public List<Object> FNB_EUR() {
		return display.FNB_EUR();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Nedbank_Eur")
	public List<Object> Nedbank_EUR() {
		return display.Nedbank_EUR();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Standard_Eur")
	public List<Object> Standard_EUR() {
		return display.Standard_EUR();
	}
	// ****************History methods for EUR*********

	// ****************History methods for JPY*********
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ABSA_Jpy")
	public List<Object> ABSA_JPY() {
		return display.ABSA_JPY();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Bidvest_Jpy")
	public List<Object> Bidvest_JPY() {
		return display.Bidvest_JPY();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/FNB_Jpy")
	public List<Object> FNB_JPY() {
		return display.FNB_JPY();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Nedbank_Jpy")
	public List<Object> Nedbank_JPY() {
		return display.Nedbank_JPY();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Standard_Jpy")
	public List<Object> Standard_JPY() {
		return display.Standard_JPY();
	}
	// ****************History methods for JPY*********

	// return all rates
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public List<Object> find() {
		return display.find();
	}

	// return rates between two dates(start and end date)
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/per_date")
	public Iterable<Object> find_per_date(
			@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
			@RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date) {
		return display.find_per_date(start_date, end_date);
	}
	
	// method to find today's date
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/today_date")
	public Object today_date()
	{
		return display.today_date();
	}
	
	// method to find today's day
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/today_day")
	public Object today_day()
	{
		return display.today_day();
	}
	
	// method to find now time
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/now_time")
	public Object now_time()
	{
		return display.now_time();
	}

}
