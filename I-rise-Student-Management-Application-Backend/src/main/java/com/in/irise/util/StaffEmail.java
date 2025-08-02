package com.in.irise.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class StaffEmail {
	 @Autowired
	    private JavaMailSender mailSender;
	 
	 public void sendRegistrationEmail(String toEmail, String password, int id) {
	        try {
	            MimeMessage mimeMessage = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

	            helper.setTo(toEmail);
	            helper.setSubject("Doctor Registration Confirmation");
	            helper.setText(buildHtmlEmailBody(toEmail, password, id), true); 

	            mailSender.send(mimeMessage);
	        } catch (Exception e) {
	          
	            e.printStackTrace();
	        }
	    }
	 private String buildHtmlEmailBody(String email, String password, int id) {
	        return  "<!DOCTYPE html>" +
	        	    "<html lang='en'>" +
	        	    "<head><meta charset='UTF-8'>" +
	        	    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
	        	    "<style>" +
	        	    "  body { font-family: Arial, sans-serif; color: #333; }" +
	        	    "  .container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #e5e5e5; border-radius: 8px; background-color: #f9f9f9; }" +
	        	    "  h2 { color: #2C7A7B; }" +
	        	    "  .credentials { background-color: #edf2f7; padding: 12px; border-radius: 4px; font-size: 1.1em; color: #2D3748; margin-top: 15px; }" +
	        	    "  .footer { margin-top: 20px; font-size: 0.9em; color: #718096; }" +
	        	    
	        	    "</style>" +
	        	    "</head>" +
	        	    "<body>" +
	        	    "  <div class='container'>" +
	     	    "    <img src='https://images.app.google/bjbikSQT9Di4ziN3A' alt='Company Logo' />" +
	        	   
	        	    "    <h2>Your Login Credentials</h2>" +
	        	    "    <p>Welcome! Here are your login credentials:</p>" +
	        	    "    <div class='credentials'>" +
	        	    "      <p><a href='https://www.irisesoft.in'>Visit Website</a></p>" +
	        	    "      <p><strong>Email:</strong> " + email + "</p>" +
	        	    "      <p><strong>Password:</strong> " + password + "</p>" +
	        	    "      <p><strong>STAFF ID:</strong> " + id + "</p>" +
	        	    "    </div>" +
	        	    "    <p>Please keep this information secure. We recommend changing your password after logging in.</p>" +
	        	    "    <div class='footer'>Thank you,<br/>TEAM IRISE</div>" +
	        	    "  </div>" +
	        	    "</body>" +
	        	    "</html>";

	    }


}
