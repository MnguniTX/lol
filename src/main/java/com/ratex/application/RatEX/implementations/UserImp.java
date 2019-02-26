package com.ratex.application.RatEX.implementations;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.ratex.application.RatEX.config.WebSecurityConfig;
import com.ratex.application.RatEX.daos.ExchangeRateRepo;
import com.ratex.application.RatEX.daos.GraphEURRepo;
import com.ratex.application.RatEX.daos.GraphGBPRepo;
import com.ratex.application.RatEX.daos.GraphJPYRepo;
import com.ratex.application.RatEX.daos.GraphUSDRepo;
import com.ratex.application.RatEX.daos.NotificationsRepo;
import com.ratex.application.RatEX.daos.SessionRepo;
import com.ratex.application.RatEX.daos.UserRepo;
import com.ratex.application.RatEX.daos.WeeklyRepo;
import com.ratex.application.RatEX.entities.ExchangeRate;
import com.ratex.application.RatEX.entities.GraphEUR;
import com.ratex.application.RatEX.entities.GraphGBP;
import com.ratex.application.RatEX.entities.GraphJPY;
import com.ratex.application.RatEX.entities.GraphUSD;
import com.ratex.application.RatEX.entities.Notifications;
import com.ratex.application.RatEX.entities.Session;
import com.ratex.application.RatEX.entities.User;
import com.ratex.application.RatEX.entities.Weekly;
import com.ratex.application.RatEX.interfaces.ActivityUsers;

//Class bean will be managed 
@Component
//Class UserImp that Implements ActivityUsers
//Overrides all the Methods in the ActivityUsers
public class UserImp implements ActivityUsers {

	// Wiring the beans
	@Autowired
	UserRepo user_repo_object;
	@Autowired
	User user_object;
	@Autowired
	WebSecurityConfig encoding;
	@Autowired
	SendEmailImp send_mail;
	@Autowired
	Session session_object;
	@Autowired
	SessionRepo session_repo_object;
	@Autowired
	Notifications notification_object;
	@Autowired
	NotificationsRepo notification_object_repo;

	@Autowired
	GraphUSD graph_usd_object;
	@Autowired
	GraphUSDRepo graph_usd_repo_object;
	@Autowired
	GraphGBP graph_gbp_object;
	@Autowired
	GraphGBPRepo graph_gbp_repo_object;
	@Autowired
	GraphEUR graph_eur_object;
	@Autowired
	GraphEURRepo graph_eur_repo_object;
	@Autowired
	GraphJPY graph_jpy_object;
	@Autowired
	GraphJPYRepo graph_jpy_repo_object;
	
	@Autowired
	ExchangeRateRepo exchange_repo_object;
	
	@Autowired
	Weekly weekly_object;
	@Autowired
	WeeklyRepo weekly_repo_object;
	
	

	// register method
	public void register(String first_name, String last_name, String gender, Date DOB, String email, String password,
			String user_image) {

		user_object = new User(first_name, last_name, gender, DOB, email, password, user_image);
		user_repo_object.save(user_object);

		session_object = new Session(user_object, true);
		session_repo_object.save(session_object);

		notification_object = new Notifications(user_object, true, true, true, true);
		notification_object_repo.save(notification_object);

		graph_usd_object = new GraphUSD(user_object, true, true, true, true, true, false);
		graph_usd_repo_object.save(graph_usd_object);

		graph_gbp_object = new GraphGBP(user_object, true, true, true, true, true, false);
		graph_gbp_repo_object.save(graph_gbp_object);

		graph_eur_object = new GraphEUR(user_object, true, true, true, true, true, false);
		graph_eur_repo_object.save(graph_eur_object);

		graph_jpy_object = new GraphJPY(user_object, true, true, true, true, true, false);
		graph_jpy_repo_object.save(graph_jpy_object);
		
		weekly_object = new Weekly("N/A", "N/A", "N/A" ,user_object);
		weekly_repo_object.save(weekly_object);

		user_object = null;
		session_object = null;
		notification_object = null;
		graph_usd_object = null;
		graph_gbp_object = null;
		graph_eur_object = null;
		graph_jpy_object = null;
		weekly_object = null;

		System.out.println("Success");

	}

	// login method
	public boolean login(String email, String password) {
		boolean result = false;
		User user;
		user = user_repo_object.findByemail(email);

		if (user.getEmail().matches(email) && user.getPassword().matches(password)) {
			for (Session object : session_repo_object.findAll()) {
				if (email.equals(object.getUser_id().getEmail())) {
					object.setSession_state(true);
					object.setUser_id(user);
					session_repo_object.save(object);
					result = true;
				}
			}
		}

		return result;

	}

	// logout method
	public boolean logout(String email) {
		boolean result = false;

		for (Session object : session_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				object.setSession_state(false);
				object.setUser_id(object.getUser_id());
				session_repo_object.save(object);
				result = true;
			}
		}

		return result;

	}

	// return session status method
	public boolean get_status(String email) {
		boolean result = false;
		for (Session object : session_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				if (object.isSession_state() == true) {
					result = true;
				}
			}
		}

		return result;
	}

	// method to update user details
	public boolean update(String sessionEmail, String name, String surname, String email, String password) {
		boolean result = false;
		User user = user_repo_object.findByemail(sessionEmail);
		if (user != null) {
			if (user.getPassword().matches(password)) {
				if (!name.matches("")) {
					user.setFirst_name(name);
				}
				if (!surname.matches("")) {
					user.setLast_name(surname);
				}
				if (!email.matches("")) {
					user.setEmail(email);
				}

				result = true;
			}
		}
		user.setGender(user.getGender());
		user.setDOB(user.getDOB());

		user_repo_object.save(user);

		return result;
	}
	
	// update password
	public boolean update_password(String sessionEmail, String password, String newPassword)
	{
		boolean result = false;
		User user = user_repo_object.findByemail(sessionEmail);
		if (user != null) {
			if (user.getPassword().matches(password)) {
				user.setPassword(newPassword);
				result = true;
				
			}
			
			}
		
		user_repo_object.save(user);
		return result;
	}

	// method to return notification object
	public Object notifications_object(String email) {
		Object result = null;
		for (Notifications object : notification_object_repo.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				result = object;
			}
		}
		return result;
	}
	
	//method to get weekly object
	public Object weekly_object(String email)
	{
		Object result = null;
		for(Weekly object : weekly_repo_object.findAll())
		{
			if(email.equals(object.getUser_id().getEmail()))
			{
				result = object;
			}
		}
		return result;
	}

	// method to recover password
	public boolean forgot_password(String email) {
		boolean result = false;
		String password;
		User user = user_repo_object.findByemail(email);
		if (user != null) {
			password = user.getPassword();
			send_mail.send("ratexdevs@gmail.com", "Kaysto2#", email, "Recover Your Password",
					"Your Password Is: " + password + "\n\n\n" + "Regards,\n" + "RateXdevs");
			result = true;

		}

		return result;
	}
	//method to get report table based on the date
	public void get_report(String email, Date start_date, Date end_date, String bank, String require)
	{
	
	
    try
    {
      
       Document document = new Document();
		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
		 document.open();
		 Image img = Image.getInstance("logo.png");
		 Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
		 img.setAbsolutePosition(200f, 750f);
		 img.scalePercent(10f);
		 document.add(img);
		 document.add(new Paragraph("\n\n\n\n"));
		 document.add(new Paragraph("From: " + start_date.getDate()+"/"+(start_date.getMonth()+1) + "/" + (start_date.getYear() + 1900)));
		 document.add(new Paragraph("To: " + end_date.getDate()+"/"+(end_date.getMonth()+1) + "/" + (end_date.getYear() + 1900)));
		 document.add(new Paragraph("\n\n"));
		 PdfPTable table = new PdfPTable(5);
		 PdfPCell cell = new PdfPCell(new Phrase("BANK", boldFont));
		 table.addCell(cell);
		 cell = new PdfPCell(new Phrase("CODE", boldFont));
		 table.addCell(cell);
		 cell = new PdfPCell(new Phrase("SELL RATE", boldFont));
		 table.addCell(cell);
		 cell = new PdfPCell(new Phrase("DATE", boldFont));
		 table.addCell(cell);
		 cell = new PdfPCell(new Phrase("TIME", boldFont));
		 table.addCell(cell);
		 document.add(table);
		 PdfPTable table2 = new PdfPTable(5);
		 
		 for (ExchangeRate object : exchange_repo_object.findAll()) {
			 if (start_date.before(object.getCreated_Date()) || start_date.equals(object.getCreated_Date())) {
					if (end_date.after(object.getCreated_Date()) || end_date.equals(object.getCreated_Date())) {
						if(bank.equals("All"))
						{
							if(require.contains("All"))
							{
								table2.addCell(object.getBank_id().getBank_name());
								table2.addCell(object.getCurrency_id().getCode());
								table2.addCell(String.valueOf(object.getBuy_rate()));
								table2.addCell(object.getCreated_Date().toString());
								table2.addCell(object.getCreated_Time().toString());
							}
							else
							if(require.contains(object.getCurrency_id().getCode()))
							{
								table2.addCell(object.getBank_id().getBank_name());
								table2.addCell(object.getCurrency_id().getCode());
								table2.addCell(String.valueOf(object.getBuy_rate()));
								table2.addCell(object.getCreated_Date().toString());
								table2.addCell(object.getCreated_Time().toString());
							}
						}
						else
						if(bank.contains(object.getBank_id().getBank_name()))
						{
							if(require.contains("All"))
							{
								table2.addCell(object.getBank_id().getBank_name());
								table2.addCell(object.getCurrency_id().getCode());
								table2.addCell(String.valueOf(object.getBuy_rate()));
								table2.addCell(object.getCreated_Date().toString());
								table2.addCell(object.getCreated_Time().toString());
							}
							else
							if(require.contains(object.getCurrency_id().getCode()))
							{
								table2.addCell(object.getBank_id().getBank_name());
								table2.addCell(object.getCurrency_id().getCode());
								table2.addCell(String.valueOf(object.getBuy_rate()));
								table2.addCell(object.getCreated_Date().toString());
								table2.addCell(object.getCreated_Time().toString());
							}
						}
					
					}
					}
		 }
		 document.add(table2);
		 document.close();
		 writer.close();
		 send_mail.send_report("ratexdevs@gmail.com", "Kaysto2#", email, "Report", "Good day,\n\nPlease find your report attached.\n\nKind regards,\nRateXdevs");
       
       System.out.println("Done");
    } catch (DocumentException e)
    {
       e.printStackTrace();
    } catch (FileNotFoundException e)
    {
       e.printStackTrace();
    } catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	     
	}
	
	
	// method to generate line chart
	public JFreeChart generateLineChart(String code, String bank, Date start_date, Date end_date)
	{
		
		JFreeChart chart = ChartFactory.createLineChart("USD graph", "Time", "Rates",
				createDataset(code, bank, start_date, end_date), PlotOrientation.VERTICAL, false, true, false);

		return chart;
	}
		
	// method to set the values of the chart
	public DefaultCategoryDataset createDataset(String code, String bank, Date start_date, Date end_date)
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (ExchangeRate object : exchange_repo_object.findAll()) {
			 if (start_date.before(object.getCreated_Date()) || start_date.equals(object.getCreated_Date())) {
					if (end_date.after(object.getCreated_Date()) || end_date.equals(object.getCreated_Date())) {
						if(bank.contains("ABSA"))
						{
							if(bank.contains(object.getBank_id().getBank_name()))
							{
						
								if(code.contains(object.getCurrency_id().getCode()))
								{
									dataset.addValue(object.getBuy_rate() , "ABSA" , object.getCreated_Time().toString().substring(0, 5));
								}
							
							//dataset.addValue(object.getBuy_rate() , "Nedbank" , object.getCreated_Time().toString().substring(0, 5));
								
						
//						if(code.equals("Nedbank"))
//						{
//							dataset.addValue(object.getBuy_rate() , "Nedbank" , object.getCreated_Time().toString().substring(0, 5));
						
						
//						}
							}
						}
						if(bank.contains("Bidvest"))
						{
							//if(bank.contains(object.getBank_id().getBank_name()))
							//{
								//if(code.contains(object.getCurrency_id().getCode()))
								//{
									//dataset.addValue(object.getBuy_rate() , "Bidvest" , object.getCreated_Time().toString().substring(0, 5));
									dataset.addValue(10 , "FNB" , "16:53");
									dataset.addValue(12 , "FNB" , "16:55");
									dataset.addValue(15 , "FNB" , "16:56");
									dataset.addValue(15 , "FNB" , "16:57");
								//}
							//}
						}
//						else
//						if(bank.contains("Nedbank"))
//						{
//						if(code.equals("USD"))
//						{
//							dataset.addValue(object.getBuy_rate() , "Nedbank" , object.getCreated_Time().toString().substring(0, 5));
//						}
////						else
////							if(bank.equals("All"))
////							{
////								if(object.getCurrency_id().getCode().equals(code))
////								{
////									dataset.addValue(object.getBuy_rate() , "ABSA" , object.getCreated_Time().toString().substring(0, 5) );
////								}
////							}
//						
//					}
					
			 		}
			 }
		}
//		dataset.addValue(10 , "FNB" , "16:53");
//		dataset.addValue(12 , "FNB" , "16:55");
//		dataset.addValue(15 , "FNB" , "16:57");
		
//		dataset.addValue(8 , "wer" , "16:53");
//		dataset.addValue(5 , "wer" , "16:55");
//		dataset.addValue(15 , "wer" , "16:57");
//		
//		dataset.addValue(0 , "w" , "16:53");
//		dataset.addValue(2 , "w" , "16:55");
//		dataset.addValue(15 , "w" , "16:57");
//		
//		dataset.addValue(0 , "e" , "16:53");
//		dataset.addValue(4 , "e" , "16:55");
//		dataset.addValue(15 , "e" , "16:57");
//		
//		
//		dataset.addValue(0 , "r" , "16:53");
//		dataset.addValue(8 , "r" , "16:55");
//		dataset.addValue(15 , "r" , "16:57");
	
	      return dataset;
	}
		
	// method to write the line chart to PDF
	public void writeChartToPDF(JFreeChart chart, int width, int height, String fileName, Date start_date, Date end_date)
	{
		PdfWriter writer = null;

		Document document = new Document();

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(
					fileName));
			document.open();
			Image img = Image.getInstance("logo.png");
			 img.setAbsolutePosition(200f, 750f);
			 img.scalePercent(10f);
			 document.add(img);
			 document.add(new Paragraph("\n\n\n\n"));
			 document.add(new Paragraph("From: " + start_date.getDate()+"/"+(start_date.getMonth()+1) + "/" + (start_date.getYear() + 1900)));
			 document.add(new Paragraph("To: " + end_date.getDate()+"/"+(end_date.getMonth()+1) + "/" + (end_date.getYear() + 1900)));
			PdfContentByte contentByte = writer.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(width, height);
			@SuppressWarnings("deprecation")
			Graphics2D graphics2d = template.createGraphics(width, height,
					new DefaultFontMapper());
			Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
					height);

			chart.draw(graphics2d, rectangle2d);
			
			graphics2d.dispose();
			contentByte.addTemplate(template, 50, 400);

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}
	
	//method to get report graph
	public void get_graph(String email, Date start_date, Date end_date, String bank, String require)
	{
		writeChartToPDF(generateLineChart(require, bank , start_date, end_date), 500, 300, "linechart.pdf", start_date, end_date);
		send_mail.send_graph("ratexdevs@gmail.com", "Kaysto2#", email, "Report", "Good day,\n\nPlease find your report attached.\n\nKind regards,\nRateXdevs");
	}

	// method to return user object
	public Object showUser(String email) {
		return user_repo_object.findByemail(email);
	}

	// method to return USD graph object
	public Object USD_graph_object(String email) {
		Object result = null;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				result = object;
			}
		}
		return result;
	}

	// method to return GBP graph object
	public Object GBP_graph_object(String email) {
		Object result = null;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				result = object;
			}
		}
		return result;
	}

	// method to return EUR graph object
	public Object EUR_graph_object(String email) {
		Object result = null;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				result = object;
			}
		}
		return result;
	}

	// method to return JPY graph object
	public Object JPY_graph_object(String email) {
		Object result = null;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				result = object;
			}
		}
		return result;
	}

	// *****************************Notifications***********************************
	// method to get USD notification
	public void USD_notification(String email, boolean state) {
		Notifications notifications;

		for (Notifications object : notification_object_repo.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				notifications = object;
				notifications.setUSD(state);
				notification_object_repo.save(notifications);
			}
		}

	}

	// method to GBP_notification
	public void GBP_notification(String email, boolean state) {
		Notifications notifications;

		for (Notifications object : notification_object_repo.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				notifications = object;
				notifications.setGBP(state);
				notification_object_repo.save(notifications);
			}
		}
	}

	// method to EUR_notification
	public void EUR_notification(String email, boolean state) {
		Notifications notifications;

		for (Notifications object : notification_object_repo.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				notifications = object;
				notifications.setEUR(state);
				notification_object_repo.save(notifications);
			}
		}
	}

	// method to JPY_notification
	public void JPY_notification(String email, boolean state) {
		Notifications notifications;

		for (Notifications object : notification_object_repo.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				notifications = object;
				notifications.setJPY(state);
				notification_object_repo.save(notifications);
			}
		}
	}
	// *****************************Notifications***********************************
	
	// *****************************Weekly******************************************
	// method to change weekly bank
		public void bank(String email, String bank)
		{
			Weekly weekly;
			for (Weekly object : weekly_repo_object.findAll())
			{
				if(email.equals(object.getUser_id().getEmail()))
				{
					weekly = object;
					weekly.setBank(bank);
					weekly_repo_object.save(weekly);
				}
			}
		}
		
		// method to change weekly currency
		public void currency(String email, String currency)
		{
			Weekly weekly;
			for (Weekly object : weekly_repo_object.findAll())
			{
				if(email.equals(object.getUser_id().getEmail()))
				{
					weekly = object;
					weekly.setCurrency(currency);
					weekly_repo_object.save(weekly);
				}
			}
		}
		
		// method to change weekly day
		public void day(String email, String day)
		{
			Weekly weekly;
			for (Weekly object : weekly_repo_object.findAll())
			{
				if(email.equals(object.getUser_id().getEmail()))
				{
					weekly = object;
					weekly.setDay(day);
					weekly_repo_object.save(weekly);
				}
			}
		}
		
		
	
	// *****************************Weekly******************************************

	// *****************************Graph for USD***********************************
	// method to get USD ABSA graph
	public void USD_ABSA(String email, boolean state) {
		GraphUSD graph_usd;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_usd = object;
				graph_usd.setABSA(state);
				graph_usd_repo_object.save(graph_usd);
			}
		}
	}

	// method to get USD Bidvest graph
	public void USD_Bidvest(String email, boolean state) {
		GraphUSD graph_usd;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_usd = object;
				graph_usd.setBidvest(state);
				graph_usd_repo_object.save(graph_usd);
			}
		}
	}

	// method to get USD FNB graph
	public void USD_FNB(String email, boolean state) {
		GraphUSD graph_usd;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_usd = object;
				graph_usd.setFNB(state);
				graph_usd_repo_object.save(graph_usd);
			}
		}
	}

	// method to get USD Nedbank graph
	public void USD_Nedbank(String email, boolean state) {
		GraphUSD graph_usd;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_usd = object;
				graph_usd.setNedbank(state);
				graph_usd_repo_object.save(graph_usd);
			}
		}
	}

	// method to get USD Standard graph
	public void USD_Standard(String email, boolean state) {
		GraphUSD graph_usd;
		for (GraphUSD object : graph_usd_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_usd = object;
				graph_usd.setStandard(state);
				graph_usd_repo_object.save(graph_usd);
			}
		}
	}
	// *****************************Graph for USD***********************************

	// *****************************Graph for GBP***********************************
	// method to get GBP ABSA graph
	public void GBP_ABSA(String email, boolean state) {
		GraphGBP graph_gbp;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_gbp = object;
				graph_gbp.setABSA(state);
				graph_gbp_repo_object.save(graph_gbp);
			}
		}
	}

	// method to get GBP Bidvest graph
	public void GBP_Bidvest(String email, boolean state) {
		GraphGBP graph_gbp;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_gbp = object;
				graph_gbp.setBidvest(state);
				graph_gbp_repo_object.save(graph_gbp);
			}
		}
	}

	// method to get GBP FNB graph
	public void GBP_FNB(String email, boolean state) {
		GraphGBP graph_gbp;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_gbp = object;
				graph_gbp.setFNB(state);
				graph_gbp_repo_object.save(graph_gbp);
			}
		}
	}

	// method to get GBP Nedbank graph
	public void GBP_Nedbank(String email, boolean state) {
		GraphGBP graph_gbp;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_gbp = object;
				graph_gbp.setNedbank(state);
				graph_gbp_repo_object.save(graph_gbp);
			}
		}
	}

	// method to get GBP Standard graph
	public void GBP_Standard(String email, boolean state) {
		GraphGBP graph_gbp;
		for (GraphGBP object : graph_gbp_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_gbp = object;
				graph_gbp.setStandard(state);
				graph_gbp_repo_object.save(graph_gbp);
			}
		}
	}
	// *****************************Graph for GBP***********************************

	// *****************************Graph for EUR***********************************
	// method to get EUR ABSA graph
	public void EUR_ABSA(String email, boolean state) {
		GraphEUR graph_eur;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_eur = object;
				graph_eur.setABSA(state);
				graph_eur_repo_object.save(graph_eur);
			}
		}
	}

	// method to get EUR Bidvest graph
	public void EUR_Bidvest(String email, boolean state) {
		GraphEUR graph_eur;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_eur = object;
				graph_eur.setBidvest(state);
				graph_eur_repo_object.save(graph_eur);
			}
		}
	}

	// method to get EUR FNB graph
	public void EUR_FNB(String email, boolean state) {
		GraphEUR graph_eur;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_eur = object;
				graph_eur.setFNB(state);
				graph_eur_repo_object.save(graph_eur);
			}
		}
	}

	// method to get EUR Nedbank graph
	public void EUR_Nedbank(String email, boolean state) {
		GraphEUR graph_eur;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_eur = object;
				graph_eur.setNedbank(state);
				graph_eur_repo_object.save(graph_eur);
			}
		}
	}

	// method to get EUR Standard graph
	public void EUR_Standard(String email, boolean state) {
		GraphEUR graph_eur;
		for (GraphEUR object : graph_eur_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_eur = object;
				graph_eur.setStandard(state);
				graph_eur_repo_object.save(graph_eur);
			}
		}
	}
	// *****************************Graph for EUR***********************************

	// *****************************Graph for JPY***********************************
	// method to get JPY ABSA graph
	public void JPY_ABSA(String email, boolean state) {
		GraphJPY graph_jpy;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_jpy = object;
				graph_jpy.setABSA(state);
				graph_jpy_repo_object.save(graph_jpy);
			}
		}
	}

	// method to get JPY Bidvest graph
	public void JPY_Bidvest(String email, boolean state) {
		GraphJPY graph_jpy;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_jpy = object;
				graph_jpy.setBidvest(state);
				graph_jpy_repo_object.save(graph_jpy);
			}
		}
	}

	// method to get JPY FNB graph
	public void JPY_FNB(String email, boolean state) {
		GraphJPY graph_jpy;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_jpy = object;
				graph_jpy.setFNB(state);
				graph_jpy_repo_object.save(graph_jpy);
			}
		}
	}

	// method to get JPY Nedbank graph
	public void JPY_Nedbank(String email, boolean state) {
		GraphJPY graph_jpy;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_jpy = object;
				graph_jpy.setNedbank(state);
				graph_jpy_repo_object.save(graph_jpy);
			}
		}
	}

	// method to get JPY Standard graph
	public void JPY_Standard(String email, boolean state) {
		GraphJPY graph_jpy;
		for (GraphJPY object : graph_jpy_repo_object.findAll()) {
			if (email.equals(object.getUser_id().getEmail())) {
				graph_jpy = object;
				graph_jpy.setStandard(state);
				graph_jpy_repo_object.save(graph_jpy);
			}
		}
	}
	// *****************************Graph for JPY***********************************

}
