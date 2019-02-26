package com.ratex.application.RatEX.implementations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ratex.application.RatEX.daos.ExchangeRateRepo;
import com.ratex.application.RatEX.entities.ExchangeRate;
import com.ratex.application.RatEX.interfaces.ActivityDisplay;

//Class bean will be managed 
@Component
//Class Display that Implements ActivityDisplay
//Overrides all the Methods in the ActivityDisplay
public class DisplayImp implements ActivityDisplay {
	// Injecting the ExchangeRateRepo Bean
	@Autowired
	ExchangeRateRepo exchange_repo_object;

	// Injecting an EntityManager instance for persisting entities to and loading
	// entities from the database
	@PersistenceContext
	private EntityManager entityManager;

	// ************** Procedures for old and new data*******************
	// Old Data Stored Procedure
	@Override
	public List<Object> oldData() {
		// "old_Data" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("old_Data");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing arrOld of type List<Object> to the results of the Stored
		// Procedure
		List<Object> arrOld = query.getResultList();

		// Returning the List of arrays/Objects
		return arrOld;
	}

	// Latest Data Stored Procedure
	@Override
	public List<Object> newData() {
		// "latest_Data" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("latest_Data");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing arrNew of type List<Object> to the results of the Stored
		// Procedure
		List<Object> arrNew = query.getResultList();

		// Returning the List of arrays/Objects
		return arrNew;
	}
	// ************** Procedures for old and new data*******************

	// ************** Procedures for lowest buy rates*******************
	// Lowest USD Stored Procedure
	@Override
	public Object USD() {
		// "cheap_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("cheap_USD");

		// Execute query
		query.execute();

		// Initializing the Results of a Query at index 0 to obj
		Object obj = query.getResultList().get(0);

		// Return The The First Index in Array(Since GBP Values might be the
		// same in Different Banks.
		return obj;
	}

	// Lowest GBP Stored Procedure
	@Override
	public Object GBP() {
		// "cheap_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("cheap_GBP");

		// Execute query
		query.execute();

		// Initializing the Results of a Query at index 0 to obj
		Object obj = query.getResultList().get(0);
		// Initializing the Results of a Query to obj

		// Return The The First Index in Array(Since GBP Values might be the
		// same in Different Banks.
		return obj;
	}

	// Lowest EUR Stored Procedure
	@Override
	public Object EUR() {

		// "cheap_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("cheap_EUR");

		// Execute query
		query.execute();

		// Initializing the Results of a Query at index 0 to obj
		Object obj = query.getResultList().get(0);

		// Return The The First Index in Array(Since GBP Values might be the
		// same in Different Banks.
		return obj;
	}

	// Lowest JPY Stored Procedure
	@Override
	public Object JPY() {
		// "cheap_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("cheap_JPY");

		// Execute query
		query.execute();

		// Initializing the Results of a Query at index 0 to obj
		Object obj = query.getResultList().get(0);

		// Return The The First Index in Array(Since JPY Values might be the
		// same in Different Banks.
		return obj;

	}
	// ************** Procedures for lowest buy rates*******************

	// ******************* Procedure for current date from the exchange rate table**************************
	@Override
	public Object date() {
		// "date" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("date");

		// Execute query
		query.execute();

		// Initializing obj to the results of the Stored
		// Procedure
		Object obj = query.getResultList();

		// Returning the obj
		return obj;
	}
	// ******************* Procedure for current date from the exchange rate table**************************

	// ******************* Procedure for new time**************************
	@Override
	public Object new_time() {
		// "new_time" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("new_time");

		// Execute query
		query.execute();

		// Initializing obj to the results of the Stored
		// Procedure
		Object obj = query.getResultList();

		// Returning the obj
		return obj;
	}
	// ******************* Procedure for new time**************************

	// ******************* Procedure for time history**************************
	public List<Object> time() {
		// "time" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("time");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects

		return array;
	}
	// ******************* Procedure for time history**************************

	// ************** Procedures for USD history************************
	// ABSA USD history Stored Procedure
	public List<Object> ABSA_USD() {
		// "ABSA_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ABSA_USD");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Bidvest USD history Stored Procedure
	public List<Object> Bidvest_USD() {
		// "Bidvest_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Bidvest_USD");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// FNB USD history Stored Procedure
	public List<Object> FNB_USD() {
		// "FNB_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FNB_USD");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Nedbank USD history Stored Procedure
	public List<Object> Nedbank_USD() {
		// "Nedbank_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Nedbank_USD");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Standard USD history Stored Procedure
	public List<Object> Standard_USD() {
		// "Standard_USD" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Standard_USD");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}
	// ************** Procedures for USD history************************

	// ************** Procedures for GBP history************************
	// ABSA GBP history Stored Procedure
	public List<Object> ABSA_GBP() {
		// "ABSA_GBP" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ABSA_GBP");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Bidvest GBP history Stored Procedure
	public List<Object> Bidvest_GBP() {
		// "Bidvest_GBP" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Bidvest_GBP");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// FNB GBP history Stored Procedure
	public List<Object> FNB_GBP() {
		// "FNB_GBP" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FNB_GBP");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Nedbank GBP history Stored Procedure
	public List<Object> Nedbank_GBP() {
		// "Nedbank_GBP" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Nedbank_GBP");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Standard GBP history Stored Procedure
	public List<Object> Standard_GBP() {
		// "Standard_GBP" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Standard_GBP");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}
	// ************** Procedures for GBP history************************

	// ************** Procedures for EUR history************************
	// ABSA EUR history Stored Procedure
	public List<Object> ABSA_EUR() {
		// "ABSA_EUR" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ABSA_EUR");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Bidvest EUR history Stored Procedure
	public List<Object> Bidvest_EUR() {
		// "Bidvest_EUR" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Bidvest_EUR");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// FNB EUR history Stored Procedure
	public List<Object> FNB_EUR() {
		// "FNB_EUR" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FNB_EUR");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Nedbank EUR history Stored Procedure
	public List<Object> Nedbank_EUR() {
		// "Nedbank_EUR" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Nedbank_EUR");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Standard EUR history Stored Procedure
	public List<Object> Standard_EUR() {
		// "Standard_EUR" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Standard_EUR");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}
	// ************** Procedures for EUR history************************

	// ************** Procedures for JPY history************************
	// ABSA JPY history Stored Procedure
	public List<Object> ABSA_JPY() {
		// "ABSA_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ABSA_JPY");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Bidvest JPY history Stored Procedure
	public List<Object> Bidvest_JPY() {
		// "Bidvest_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Bidvest_JPY");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// FNB JPY history Stored Procedure
	public List<Object> FNB_JPY() {
		// "FNB_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FNB_JPY");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Nedbank JPY history Stored Procedure
	public List<Object> Nedbank_JPY() {
		// "Nedbank_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Nedbank_JPY");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}

	// Standard JPY history Stored Procedure
	public List<Object> Standard_JPY() {
		// "Standard_JPY" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Standard_JPY");

		// Execute query
		query.execute();

		// Ignoring Warnings That are Unchecked
		@SuppressWarnings("unchecked")

		// Initializing array of type List<Object> to the results of the Stored
		// Procedure
		List<Object> array = query.getResultList();

		// Returning the List of arrays/Objects
		return array;
	}
	// ************** Procedures for JPY history************************
	
	//methodto sort in descending
	public Sort sortByIdDesc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	//method to return all data
	public List<Object> find() {
		List<Object> arr = new ArrayList<>();

		for (ExchangeRate object : exchange_repo_object.findAll(sortByIdDesc())) {
			HashMap<String, String> map = new HashMap<>();
			map.put("bank_name", object.getBank_id().getBank_name());
			map.put("code", object.getCurrency_id().getCode());
			map.put("buy_rate", String.valueOf(object.getBuy_rate()));
			map.put("created_date", String.valueOf(object.getCreated_Date()));
			map.put("created_time", String.valueOf(object.getCreated_Time()));
			arr.add(map);
		}

		return arr;
	}
	
	
	//method to return data per date
	public Iterable<Object> find_per_date(Date start_date, Date end_date) {
		List<Object> all = new ArrayList<>();
		for (ExchangeRate object : exchange_repo_object.findAll(sortByIdDesc())) {
			if (start_date.before(object.getCreated_Date()) || start_date.equals(object.getCreated_Date())) {
				if (end_date.after(object.getCreated_Date()) || end_date.equals(object.getCreated_Date())) {
					HashMap<String, String> map = new HashMap<>();
					map.put("bank_name", object.getBank_id().getBank_name());
					map.put("code", object.getCurrency_id().getCode());
					map.put("buy_rate", String.valueOf(object.getBuy_rate()));
					map.put("created_date", String.valueOf(object.getCreated_Date()));
					map.put("created_time", String.valueOf(object.getCreated_Time()));
					all.add(map);
				}
			} else if (start_date.toString().isEmpty() || end_date.toString().isEmpty()) {
				all.add(null);
			}

		}

		return all;
	}
	
	// method to find today's date
	public Object today_date()
	{
		// "today_date" this is the name of my procedure
				StoredProcedureQuery query = entityManager.createStoredProcedureQuery("today_date");

				// Execute query
				query.execute();

				// Initializing obj to the results of the Stored
				// Procedure
				Object obj = query.getResultList();

				// Returning the obj
				return obj;
	}
	
	// method to find today's day
	public Object today_day()
	{
		// "today_day" this is the name of my procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("today_day");

		// Execute query
		query.execute();

		// Initializing obj to the results of the Stored
		// Procedure
		Object obj = query.getResultList();

		// Returning the obj
		return obj;
	}
	
	// method to find now time
	public Object now_time()
	{
		// "now_time" this is the name of my procedure
				StoredProcedureQuery query = entityManager.createStoredProcedureQuery("now_time");

				// Execute query
				query.execute();

				// Initializing obj to the results of the Stored
				// Procedure
				Object obj = query.getResultList();

				// Returning the obj
				return obj;
	}

}
