package com.ratex.application.RatEX.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ratex.application.RatEX.daos.BankRepo;
import com.ratex.application.RatEX.daos.CurrencyRepo;
import com.ratex.application.RatEX.entities.Bank;
import com.ratex.application.RatEX.entities.Currency;

//Class bean will be managed in the spring container
@Component

//Class (Initializer) to initialize the names of Banks and Currencies
public class Initializer {
	// Injecting the BankRepo bean
	@Autowired
	BankRepo bank_repo_object;
	// Injecting the CurrencyRepo bean
	@Autowired
	CurrencyRepo currency_repo_object;

	// Injecting the Bank bean
	@Autowired
	Bank bank_object;

	// Injecting the Currency Bean
	@Autowired
	Currency currency_object;

	// Array banks of type String that holds five different Banks
	String[] banks = { "ABSA", "First National Bank", "Bidvest Bank", "Nedbank", "Standard Bank" };
	// Array currency_codes of type String that holds four different bank codes
	String[] currency_codes = { "USD", "GBP", "EUR", "JPY" };
	// Array currency_descriptions of type String that holds four Different bank
	// descriptions
	String[] currency_descriptions = { "US Dollar", "British Sterling", "European Euro", "Japanese Yen" };

	// Method countBank() of type boolean to check if the Bank entity in the
	// database is empty
	// or not empty
	// If empty it returns true, if not it returns false
	public boolean countBank() {
		boolean result = false;

		if (bank_repo_object.count() == 0) {
			result = true;
		}

		return result;
	}

	// Method countCurrency() of type boolean to check if the Currency entity in the
	// database
	// is empty or not
	// If empty it returns true, if not it returns false
	public boolean countCurrency() {
		boolean result = false;

		if (currency_repo_object.count() == 0) {
			result = true;
		}

		return result;
	}

	// Method init() of type void to initialize values in the Bank and Currency
	// entities
	public void init() {
		// If statement to check if the method is true or not
		// If true, it will get inside the if statement
		// If false, it will skip the if statement
		if (countBank() == true) {
			// Initializing variable temp of type int to 1
			int temp = 1;

			// for loop that will loop from 0 to the length of the bank array
			// Will loop from 0 to 4
			for (int i = 0; i < banks.length; i++) {
				// Setting bank_id to temp
				bank_object.setBank_id(temp);
				// Setting bank_name to index i in the banks array
				bank_object.setBank_name(banks[i]);
				// Saving the Bank object,
				// To put the values in the database
				bank_repo_object.save(bank_object);
				// Incrementing temp by 1
				temp++;
			}
		}

		// If statement to check if the method is true or not
		// If true, it will get inside the if statement
		// If false, it will skip the if statement
		if (countCurrency() == true) {
			// Initializing variable temp of type int to 1
			int temp = 1;

			// for loop that will loop from 0 to the length of the currency_code array
			// Will loop from 0 to 3
			for (int i = 0; i < currency_codes.length; i++) {
				// Setting currency_id to temp
				currency_object.setCurrency_id(temp);
				// Setting code to index i in the currency_codes array
				currency_object.setCode(currency_codes[i]);
				// Setting code to index i in the currency_descriptions array
				currency_object.setDescription(currency_descriptions[i]);
				// Saving the currency object,
				// To put the values in the database
				currency_repo_object.save(currency_object);
				// Incrementing temp by 1
				temp++;
			}

		}
	}

}
