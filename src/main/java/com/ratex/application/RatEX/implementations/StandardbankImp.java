package com.ratex.application.RatEX.implementations;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ratex.application.RatEX.daos.ExchangeRateRepo;
import com.ratex.application.RatEX.entities.Bank;
import com.ratex.application.RatEX.entities.Currency;
import com.ratex.application.RatEX.entities.ExchangeRate;
import com.ratex.application.RatEX.interfaces.ActivityBanks;

//Class bean will be managed 
@Component
//Class StandardbankImp implements interface ActivityBanks
public class StandardbankImp implements ActivityBanks {

	// Wiring the beans
	@Autowired
	Bank bank_object;
	@Autowired
	Currency currency_object;
	@Autowired
	ExchangeRateRepo exchange_repo_object;

	// Declaring class attributes
	private int bank_id = 5;
	private String buy_rate;
	private String rate;
	private int currency_id;
	private String elementsHolder;
	ExchangeRate exchange_rate_object;
	String temp[];

	@Override
	// Method add() of type void overridden from interface ActivityBanks
	public void add() {
		// Try catch block
		try {
			// Initializing doc of type Document to the below URL (HTML page)
			Document doc = Jsoup.connect("https://ws15.standardbank.co.za/finSnapShot/GetforexServlet")
					.userAgent("Mozilla/5.0").get();
			// Initializing elements of type Elements to all the tr(table rows found
			// on the document above)
			Elements elements = doc.select("tr");

			// Enhanced for loop, looping through the elements
			for (Element element : elements) {
				// Initializing holder of type String to the first element
				// Converting e to be a text
				elementsHolder = element.text();
				// Initializing array temp of type String
				// to holder(split where there are spaces to make holder indexes)
				temp = elementsHolder.split(" ");
				// For loop that will from 0 while it is less than
				// the length of the array temp
				for (int f = 0; f < temp.length; f++) {
					// If statement to check if index f in temp array match "USD"
					// if true, go inside the loop
					// if false, skip
					if (temp[f].matches("USD")) {
						// Initializing currency_id to 1
						currency_id = 1;

						// Initializing buy_rate to index 7 at temp array
						buy_rate = temp[7];

						// Set the bank_id to bank_id
						bank_object.setBank_id(bank_id);
						// Set currency_id to currency_id
						currency_object.setCurrency_id(currency_id);

						// Instantiating the object exchange_rate_object
						exchange_rate_object = new ExchangeRate(bank_object, currency_object,
								Double.parseDouble(buy_rate));
						// Saving object exchange_rate_object
						exchange_repo_object.save(exchange_rate_object);
						// Set the reference of the object to null
						// To free memory
						exchange_rate_object = null;
					}

					if (temp[f].matches("GBP")) {
						// Initializing currency_id to 2
						currency_id = 2;

						// Initializing buy_rate to index 6 at temp array
						buy_rate = temp[6];

						// Set the bank_id to bank_id
						bank_object.setBank_id(bank_id);
						// Set currency_id to currency_id
						currency_object.setCurrency_id(currency_id);

						// Instantiating the object exchange_rate_object
						exchange_rate_object = new ExchangeRate(bank_object, currency_object,
								Double.parseDouble(buy_rate));
						// Saving object exchange_rate_object
						exchange_repo_object.save(exchange_rate_object);
						// Set the reference of the object to null
						// To free memory
						exchange_rate_object = null;
					}

					if (temp[f].matches("EUR")) {
						// Initializing currency_id to 3
						currency_id = 3;

						// Initializing buy_rate to index 5 at temp array
						buy_rate = temp[5];

						// Set the bank_id to bank_id
						bank_object.setBank_id(bank_id);
						// Set currency_id to currency_id
						currency_object.setCurrency_id(currency_id);

						// Instantiating the object exchange_rate_object
						exchange_rate_object = new ExchangeRate(bank_object, currency_object,
								Double.parseDouble(buy_rate));
						// Saving object exchange_rate_object
						exchange_repo_object.save(exchange_rate_object);
						// Set the reference of the object to null
						// To free memory
						exchange_rate_object = null;
					}

					if (temp[f].matches("JPY")) {
						// Initializing currency_id to 4
						currency_id = 4;

						// Initializing buy_rate to index 6 at temp array
						buy_rate = temp[6];

						// Set the bank_id to bank_id
						bank_object.setBank_id(bank_id);
						// Set currency_id to currency_id
						currency_object.setCurrency_id(currency_id);
						// Initializing rate of type String to the value
						// of 1 divided by buy_rate
						rate = String.valueOf(1 / Double.parseDouble(buy_rate)).substring(0, 6);
						// Instantiating the object exchange_rate_object
						exchange_rate_object = new ExchangeRate(bank_object, currency_object, Double.parseDouble(rate));
						// Saving object exchange_rate_object
						exchange_repo_object.save(exchange_rate_object);
						// Set the reference of the object to null
						// To free memory
						exchange_rate_object = null;
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public int get_Standard_status() {
		Response response = null;
		try {
			response = Jsoup.connect("https://ws15.standardbank.co.za/finSnapShot/GetforexServlet")
					.userAgent("Mozilla/5.0").followRedirects(false).timeout(0).ignoreHttpErrors(true).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.statusCode();
	}
}
