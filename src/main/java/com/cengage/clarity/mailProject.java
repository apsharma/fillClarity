package com.cengage.clarity;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class mailProject {
	
	void mailScreenshots() {

    final String username = "exploratory.cengage@gmail.com";
    final String password = "neXtBook$2011";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("exploratory.cengage@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("apoorva.rattan@gmail.com"));
        message.setSubject("Clarity Timesheets - send by Automated Script");
        message.setText("PFA as timesheet for this month.");
      
       
        //1) create MimeBodyPart object and set your message text     
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("This is intial version of Timesheet email send by automated script.");  
        
        
        String filename[] ={"/Selenium/Output/screenshot_c-vthakur.jpg",
        		 "/Selenium/Output/screenshot_c-nsharma.jpg", 
        		 "/Selenium/Output/screenshot_c-ymotwani.jpg",
        		 "/Selenium/Output/screenshot_vjain.jpg",
        		 "/Selenium/Output/screenshot_vrana.jpg"};
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        for(int i=0 ; i<filename.length ; i++)
        {
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            DataSource source = new FileDataSource(filename[i]);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename[i]);
            multipart.addBodyPart(messageBodyPart2);
        }
        
        
        //2) set the multipart object to the message object
        message.setContent(multipart);

        System.out.println("Sending email...");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
	}
}