package com.ratex.application.RatEX.tasks;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ratex.application.RatEX.implementations.AbsaImp;
import com.ratex.application.RatEX.implementations.BidvestbankImp;
import com.ratex.application.RatEX.implementations.FnbImp;
import com.ratex.application.RatEX.implementations.NedbankImp;
import com.ratex.application.RatEX.implementations.StandardbankImp;
import com.ratex.application.RatEX.initializer.Initializer;

@Component
public class LoadingData extends TimerTask {
	// Injecting the Beans
	@Autowired
	Initializer initialize;
	@Autowired
	AbsaImp absaIplementation;
	@Autowired
	BidvestbankImp bidvestIplementation;
	@Autowired
	FnbImp fnbIplementation;
	@Autowired
	NedbankImp nedbankIplementation;
	@Autowired
	StandardbankImp standardbankIplementation;
	
	// Overriding the method run() of type void
	public void run()
	{
		// Getting the beans
//				Initializer initialize = c.getBean(Initializer.class);
//				AbsaImp absaIplementation = c.getBean(AbsaImp.class);
//				BidvestbankImp bidvestIplementation = c.getBean(BidvestbankImp.class);
//				NedbankImp nedbankIplementation = c.getBean(NedbankImp.class);
//				StandardbankImp standardbankIplementation = c.getBean(StandardbankImp.class);
//				FnbImp fnbIplementation = c.getBean(FnbImp.class);
//				email email_object =  c.getBean(email.class);
				
				
				

				// Calling the method initialize() from class initializer
				initialize.init();

				// Class attributes
				int day;
				int hour;

				long milSecsDay;
				long sleepSatSun;

				long milSecsBeforeNine;
				long sleepBeforeNine;

				long sleepAfterFour;

				long secondsToMs;
				long minutesToMs;
				long hoursToMs;
				long total;
				LocalTime localTime;

					// Set cal of Calendar to the instance of the calendar
					Calendar cal = Calendar.getInstance();
					// Initializing day of type int to the current day of the week
					day = cal.get(Calendar.DAY_OF_WEEK);
					// Initializing min to the current minute
					hour = cal.get(Calendar.HOUR_OF_DAY);
					// If statement to check if the day is not 1(Sunday) and 7(Saturday)
					// If true, go inside
					// If false, skip
					if (day != 1 && day != 7) {
						// If statement to check if hour is greater than 8
						// If true, go inside
						// If false, skip
						if (hour > 7) {
							// If statement to check if hour is less than 16
							// If true, go inside
							// If false, skip
							if (hour < 16) {

								// Try catch block
//								try {
									if (absaIplementation.get_ABSA_status() == 200
											&& bidvestIplementation.get_Bidvest_status() == 200
											&& nedbankIplementation.get_Nedbank_status() == 200
											&& standardbankIplementation.get_Standard_status() == 200
											&& fnbIplementation.get_FNB_status() == 200) {
										 //Calling the methods
										absaIplementation.add();
										bidvestIplementation.add();
										nedbankIplementation.add();
										standardbankIplementation.add();
										fnbIplementation.add();
									}
							}
						}
					}

									// Thread to sleep for 10 minutes (600000 milliseconds)
									//Thread.sleep(60000);
//								} catch (Exception e) {
//									System.out.println(e.getMessage());
//								}
//							} else {
//								// Milliseconds to sleep after 16:00
//								milSecsDay = (24 * 3600000);
//								localTime = LocalTime.now();
//								secondsToMs = localTime.getSecond() * 1000;
//								minutesToMs = localTime.getMinute() * 60000;
//								hoursToMs = localTime.getHour() * 3600000;
//								total = secondsToMs + minutesToMs + hoursToMs;
//								sleepAfterFour = milSecsDay - total;
//								try {
//									Thread.sleep(sleepAfterFour);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//
//							}
//						} else {
//							// Milliseconds to sleep before 09:00
//							milSecsBeforeNine = (9 * 3600000);
//							localTime = LocalTime.now();
//							secondsToMs = localTime.getSecond() * 1000;
//							minutesToMs = localTime.getMinute() * 60000;
//							hoursToMs = localTime.getHour() * 3600000;
//							total = secondsToMs + minutesToMs + hoursToMs;
//							sleepBeforeNine = milSecsBeforeNine - total;
//							try {
//								Thread.sleep(sleepBeforeNine);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					} else {
//						// Milliseconds to sleep on a Saturday and Sunday
//						milSecsDay = (24 * 3600000);
//						localTime = LocalTime.now();
//						secondsToMs = localTime.getSecond() * 1000;
//						minutesToMs = localTime.getMinute() * 60000;
//						hoursToMs = localTime.getHour() * 3600000;
//						total = secondsToMs + minutesToMs + hoursToMs;
//						sleepSatSun = milSecsDay - total;
//						try {
//							Thread.sleep(sleepSatSun);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//					}
					


				//}
	}

}
