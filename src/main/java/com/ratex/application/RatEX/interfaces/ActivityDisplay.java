package com.ratex.application.RatEX.interfaces;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;

//Interface ActivityDisplay that will be Implemented by one class
//1. Display
public interface ActivityDisplay {
	// All these methods will be overridden in the display class

	// *******************Old and new data**************************
	// Method oldData() of type List<Object> that will return a List of old
	// arrays/objects
	public List<Object> oldData();

	// Method newData() of type List<Object> that will return a List of new
	// arrays/objects
	public List<Object> newData();
	// *******************Old and new data**************************

	// *******************Lowest************************************
	// Method USD() of type object that will return an array/object
	public Object USD();

	// Method GBP() of type object that will return an array/object
	public Object GBP();

	// Method EUR() of type object that will return an array/object
	public Object EUR();

	// Method JPY() of type object that will return an array/object
	public Object JPY();
	// *******************Lowest************************************

	// *******************Time for history**************************
	// Method time() of type List<Object> that will return a List of ABSA USD
	// arrays/objects
	public Object date();
	// *******************Time for history**************************

	// *******************new time**************************
	// Method old_time() of type Object that will old time
	// arrays/objects
	public Object new_time();
	// *******************new time**************************

	// *******************Time for history**************************
	// Method time() of type List<Object> that will return a List of ABSA USD
	// arrays/objects
	public List<Object> time();
	// *******************Time for history**************************

	// *******************All USD's from different banks**************************
	// Method ABSA_USD() of type List<Object> that will return a List of ABSA USD
	// arrays/objects
	public List<Object> ABSA_USD();

	// Method Bidvest_USD() of type List<Object> that will return a List of Bidvest
	// USD
	// arrays/objects
	public List<Object> Bidvest_USD();

	// Method FNB_USD() of type List<Object> that will return a List of FNB USD
	// arrays/objects
	public List<Object> FNB_USD();

	// Method Nedbank_USD() of type List<Object> that will return a List of Nedbank
	// USD
	// arrays/objects
	public List<Object> Nedbank_USD();

	// Method Standard_USD() of type List<Object> that will return a List of
	// Standard USD
	// arrays/objects
	public List<Object> Standard_USD();
	// *******************All USD's from different banks**************************

	// *******************All GBP's from different banks**************************
	// Method ABSA_GBP() of type List<Object> that will return a List of ABSA GBP
	// arrays/objects
	public List<Object> ABSA_GBP();

	// Method Bidvest_GBP() of type List<Object> that will return a List of Bidvest
	// GBP
	// arrays/objects
	public List<Object> Bidvest_GBP();

	// Method FNB_GBP() of type List<Object> that will return a List of FNB GBP
	// arrays/objects
	public List<Object> FNB_GBP();

	// Method Nedbank_GBP() of type List<Object> that will return a List of Nedbank
	// GBP
	// arrays/objects
	public List<Object> Nedbank_GBP();

	// Method Standard_GBP() of type List<Object> that will return a List of
	// Standard GBP
	// arrays/objects
	public List<Object> Standard_GBP();
	// *******************All GBP's from different banks**************************

	// *******************All EUR's from different banks**************************
	// Method ABSA_EUR() of type List<Object> that will return a List of ABSA EUR
	// arrays/objects
	public List<Object> ABSA_EUR();

	// Method Bidvest_EUR() of type List<Object> that will return a List of Bidvest
	// EUR
	// arrays/objects
	public List<Object> Bidvest_EUR();

	// Method FNB_EUR()) of type List<Object> that will return a List of FNB EUR
	// arrays/objects
	public List<Object> FNB_EUR();

	// Method Nedbank_EUR() of type List<Object> that will return a List of Nedbank
	// EUR
	// arrays/objects
	public List<Object> Nedbank_EUR();

	// Method Standard_EUR() of type List<Object> that will return a List of
	// Standard EUR
	// arrays/objects
	public List<Object> Standard_EUR();
	// *******************All EUR's from different banks**************************

	// *******************All JPY's from different banks**************************
	// Method ABSA_JPY() of type List<Object> that will return a List of ABSA JPY
	// arrays/objects
	public List<Object> ABSA_JPY();

	// Method Bidvest_JPY() of type List<Object> that will return a List of Bidvest
	// JPY
	// arrays/objects
	public List<Object> Bidvest_JPY();

	// Method FNB_JPY() of type List<Object> that will return a List of FNB JPY
	// arrays/objects
	public List<Object> FNB_JPY();

	// Method Nedbank_JPY() of type List<Object> that will return a List of Nedbank
	// JPY
	// arrays/objects
	public List<Object> Nedbank_JPY();

	// Method Standard_JPY() of type List<Object> that will return a List of
	// Standard JPY
	// arrays/objects
	public List<Object> Standard_JPY();
	// *******************All JPY's from different banks**************************
	// public List<ExchangeRate> pro();

	// method to sort
	public Sort sortByIdDesc();
	
	// method to find a list of objects
	public List<Object> find();
	
	// method to find objects based on start and end date
	public Iterable<Object> find_per_date(Date start_date, Date end_date);
	
	// method to find today's date
	public Object today_date();
	
	// method to find today's day
	public Object today_day();
	
	// method to find now time
	public Object now_time();

}
