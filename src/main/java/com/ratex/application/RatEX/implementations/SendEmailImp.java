package com.ratex.application.RatEX.implementations;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

import com.ratex.application.RatEX.interfaces.Email;

@Component
public class SendEmailImp implements Email {
	
	public void send(String from, String password, String to, String sub, String msg) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			// System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		// return "message sent successfully";
	}
	
	// method to send report table
		public void send_report(String from, String password, String to, String sub, String msg){
			//Get properties object
	    	
	          Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //get Session   
	          Session session = Session.getDefaultInstance(props,    
	           new javax.mail.Authenticator() {    
	           protected PasswordAuthentication getPasswordAuthentication() {    
	           return new PasswordAuthentication(from,password);  
	           }    
	          });    
	          //compose message    
	          try {    
	           MimeMessage message = new MimeMessage(session);    
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	           message.setSubject(sub);  
	           
	           
	           BodyPart messageBodyPart = new MimeBodyPart();

	           // Now set the actual message
	           messageBodyPart.setText(msg);

	           // Create a multipar message
	           Multipart multipart = new MimeMultipart();

	           // Set text message part
	           multipart.addBodyPart(messageBodyPart);
	           
	           
	       
	           // Set the email attachment file
	           FileDataSource fileDataSource = new FileDataSource("report.pdf");

	           MimeBodyPart attachmentPart = new MimeBodyPart();
	           attachmentPart.setDataHandler(new DataHandler(fileDataSource));
	           attachmentPart.setFileName(fileDataSource.getName());

	           // Create Multipart E-Mail.
	           //Multipart multipart = new MimeMultipart();
	           multipart.addBodyPart(attachmentPart);

	           message.setContent(multipart);
	           
	        

	           
	           //send message  
	           Transport.send(message);    
	           //System.out.println("message sent successfully");    
	          } catch (MessagingException e) {throw new RuntimeException(e);}    
	           
		}
		
		
		// method to send report graph
		public void send_graph(String from, String password, String to, String sub, String msg)
		{
			//Get properties object
	    	
	          Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //get Session   
	          Session session = Session.getDefaultInstance(props,    
	           new javax.mail.Authenticator() {    
	           protected PasswordAuthentication getPasswordAuthentication() {    
	           return new PasswordAuthentication(from,password);  
	           }    
	          });    
	          //compose message    
	          try {    
	           MimeMessage message = new MimeMessage(session);    
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	           message.setSubject(sub);  
	           
	           
	           BodyPart messageBodyPart = new MimeBodyPart();

	           // Now set the actual message
	           messageBodyPart.setText(msg);

	           // Create a multipar message
	           Multipart multipart = new MimeMultipart();

	           // Set text message part
	           multipart.addBodyPart(messageBodyPart);
	           
	           
	       
	           // Set the email attachment file
	           FileDataSource fileDataSource = new FileDataSource("linechart.pdf");

	           MimeBodyPart attachmentPart = new MimeBodyPart();
	           attachmentPart.setDataHandler(new DataHandler(fileDataSource));
	           attachmentPart.setFileName(fileDataSource.getName());

	           // Create Multipart E-Mail.
	           //Multipart multipart = new MimeMultipart();
	           multipart.addBodyPart(attachmentPart);

	           message.setContent(multipart);
	           
	        

	           
	           //send message  
	           Transport.send(message);    
	           //System.out.println("message sent successfully");    
	          } catch (MessagingException e) {throw new RuntimeException(e);}    
	          
		}
}
