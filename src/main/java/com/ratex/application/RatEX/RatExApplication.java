package com.ratex.application.RatEX;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import com.ratex.application.RatEX.tasks.LoadingData;
import com.ratex.application.RatEX.tasks.WeeklyEmail;

@SpringBootApplication
public class RatExApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(RatExApplication.class);

	}

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext c = SpringApplication.run(RatExApplication.class, args);
		
		
		// Calendar instance
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,10);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 0);
		
		// Alarm time to start the task
		Date alarmTime = calendar.getTime();
		
		// Injecting the Beans
		LoadingData load_object = c.getBean(LoadingData.class);
		WeeklyEmail email_object =  c.getBean(WeeklyEmail.class);
		
		
		// Instantiating the timer to start the task
		Timer timer = new Timer();
		// Starting the task every 10 minutes
        timer.schedule(load_object, 1000,300000);
        // Starting the task base on the alarm time
        timer.schedule(email_object, alarmTime);
	
	}
}




