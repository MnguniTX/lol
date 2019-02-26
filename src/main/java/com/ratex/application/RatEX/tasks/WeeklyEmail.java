package com.ratex.application.RatEX.tasks;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ratex.application.RatEX.daos.ExchangeRateRepo;
import com.ratex.application.RatEX.daos.UserRepo;
import com.ratex.application.RatEX.daos.WeeklyRepo;
import com.ratex.application.RatEX.entities.User;
import com.ratex.application.RatEX.entities.Weekly;
import com.ratex.application.RatEX.implementations.UserImp;

@Component
public class WeeklyEmail extends TimerTask {
	
	// Injecting the Beans
	@Autowired
	UserImp user_implementation_object;
	@Autowired
	ExchangeRateRepo exchange_repo_object;
	@Autowired
	User user_object;
	@Autowired
	UserRepo user_repo_object;
	@Autowired
	Weekly weekly_object;
	@Autowired
	WeeklyRepo weekly_repo_object;
	
	// Declaring the variables
	int day;
	String day_word = "";

	// Overriding the method run() of type void
	@Override
	public void run()
	{
		// The calendar instance
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_WEEK);
		LocalDate start = null;
		LocalDate end = LocalDate.now();

		//Switch to check the day in words
		switch (day) {
		case 2:
			day_word = "Monday";
			break;
		case 3:
			day_word = "Tuesday";
			break;
		case 4:
			day_word = "Wednesday";
			break;
		case 5:
			day_word = "Thursday";
			break;
		case 6:
			day_word = "Friday";
		default:
			break;
		}
		
		
		// If statement to minus the correct days to send weekly e-mails
		if(day == 6)
		{
			start = LocalDate.now().minusDays(4);
		}
		else
			if(day == 5)
			{
				start = LocalDate.now().minusDays(3);
			}
			else
				if(day == 4)
				{
					start = LocalDate.now().minusDays(2);
				}
				else
					if(day == 3)
					{
						start = LocalDate.now().minusDays(1);
					}
					else
						if(day == 2)
						{
							start = LocalDate.now().minusDays(0);
						}
		
		// Getting the correct start_date and end_date after minus the correct days
		Date start_date = java.sql.Date.valueOf(start);
		Date end_date = java.sql.Date.valueOf(end);
		
		
		
		// Enhanced for loop looping through the user table from the database
		// Sending the e-mail if all requirements are meet
				for(User object : user_repo_object.findAll())
				{
					for(Weekly week : weekly_repo_object.findAll())
					{
						if(object.getUser_id() == week.getUser_id().getUser_id())
						{
							if(week.getDay().equalsIgnoreCase(day_word))
								if(!week.getBank().equals("N/A"))
								{
									if(!week.getCurrency().equalsIgnoreCase("N/A"))
									{
										user_implementation_object.get_report(object.getEmail(),start_date, end_date, week.getBank(), week.getCurrency());
									}
								}
						}
					}
				}

	}
	

}
