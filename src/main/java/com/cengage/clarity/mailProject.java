package com.cengage.clarity;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This is intial version of Timesheet email send by automated script.");

            String filename = "target/imageapsharma.jpg";

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);
            multipart.addBodyPart(messageBodyPart2);

            message.setContent(multipart);
            System.out.println("Sending email...");

            Transport transport = session.getTransport("smtps");
            transport.connect("smtp.gmail.com", username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}