package com.ratex.application.RatEX.interfaces;

import java.util.Date;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

//interface ActivityUsers
public interface ActivityUsers {

	// method to register
	public void register(String name, String surname, String gender, Date dOB, String email, String password,
			String user_image);

	// method to login
	public boolean login(String email, String password);

	// method to update user details
	public boolean update(String sessionEmail, String name, String surname, String email, String password);

	// method to recover password
	public boolean forgot_password(String email);
	
	//method to get report table
	public void get_report(String email, Date start_date, Date end_date, String bank,  String require);
	
	//method to get report graph
	public void get_graph(String email, Date start_date, Date end_date, String bank, String require);
	
	// method to generate line chart
	public JFreeChart generateLineChart(String code, String bank, Date start_date, Date end_date);
	
	// method to set the values of the chart
	public DefaultCategoryDataset createDataset(String code, String bank, Date start_date, Date end_date);
	
	// method to write the line chart to PDF
	public void writeChartToPDF(JFreeChart chart, int width, int height, String fileName, Date start_date, Date end_date);
	
	
	// method to logout
	public boolean logout(String email);

	// method to return session status
	public boolean get_status(String email);

	// method to get the notifications object
	public Object notifications_object(String email);
	
	//method to get weekly object
	public Object weekly_object(String email);
	
	// update password
	public boolean update_password(String sessionEmail, String password, String newPassword);

	// *****************************Notifications***********************************
	// method to change USD notification state
	public void USD_notification(String email, boolean state);

	// method to change GBP_notification state
	public void GBP_notification(String email, boolean state);

	// method to change EUR_notification state
	public void EUR_notification(String email, boolean state);

	// method to change JPY_notification state
	public void JPY_notification(String email, boolean state);

	// *****************************Notifications***********************************
	
	
	// *****************************Weekly******************************************
	// method to change weekly bank
	public void bank(String email, String bank);
	
	// method to change weekly currency
	public void currency(String email, String currency);
	
	// method to change weekly day
	public void day(String email, String day);
	
	
	
	// *****************************Weekly******************************************
	// method to get the user object
	public Object showUser(String email);

	// method to get the USD graph object
	public Object USD_graph_object(String email);

	// method to get the USD graph object
	public Object GBP_graph_object(String email);

	// method to get the USD graph object
	public Object EUR_graph_object(String email);

	// method to get the USD graph object
	public Object JPY_graph_object(String email);

	// *****************************Graph for USD***********************************
	// method to get USD ABSA graph
	public void USD_ABSA(String email, boolean state);

	// method to get USD Bidvest graph
	public void USD_Bidvest(String email, boolean state);

	// method to get USD FNB graph
	public void USD_FNB(String email, boolean state);

	// method to get USD Nedbank graph
	public void USD_Nedbank(String email, boolean state);

	// method to get USD Standard graph
	public void USD_Standard(String email, boolean state);
	// *****************************Graph for USD***********************************

	// *****************************Graph for GBP***********************************
	// method to get GBP ABSA graph
	public void GBP_ABSA(String email, boolean state);

	// method to get GBP Bidvest graph
	public void GBP_Bidvest(String email, boolean state);

	// method to get GBP FNB graph
	public void GBP_FNB(String email, boolean state);

	// method to get GBP Nedbank graph
	public void GBP_Nedbank(String email, boolean state);

	// method to get GBP Standard graph
	public void GBP_Standard(String email, boolean state);
	// *****************************Graph for GBP***********************************

	// *****************************Graph for EUR***********************************
	// method to get EUR ABSA graph
	public void EUR_ABSA(String email, boolean state);

	// method to get EUR Bidvest graph
	public void EUR_Bidvest(String email, boolean state);

	// method to get EUR FNB graph
	public void EUR_FNB(String email, boolean state);

	// method to get EUR Nedbank graph
	public void EUR_Nedbank(String email, boolean state);

	// method to get EUR Standard graph
	public void EUR_Standard(String email, boolean state);
	// *****************************Graph for EUR***********************************

	// *****************************Graph for JPY***********************************
	// method to get JPY ABSA graph
	public void JPY_ABSA(String email, boolean state);

	// method to get JPY Bidvest graph
	public void JPY_Bidvest(String email, boolean state);

	// method to get JPY FNB graph
	public void JPY_FNB(String email, boolean state);

	// method to get JPY Nedbank graph
	public void JPY_Nedbank(String email, boolean state);

	// method to get JPY Standard graph
	public void JPY_Standard(String email, boolean state);
	// *****************************Graph for JPY***********************************

}
