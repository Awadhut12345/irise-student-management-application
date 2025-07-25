package com.in.irise.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in.irise.Repository.AdminRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	
//	@Autowired
//	private AdminRepository adminRepo;
	
	@Autowired
	private JavaMailSender sender;
	
//	public boolean emailExists(String email)
//	{
//		return adminRepo.existsByEmail(email);
//	}
	
	public boolean send1(String to, String cc, String bcc, String subject, String text, MultipartFile file) throws MessagingException
	{
		boolean isSent = false;
		
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false);
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);
		
		if(cc!=null)
		{
			helper.setCc(cc);
		}
		
		if(bcc!=null)
		{
			helper.setBcc(bcc);
		}
		
		if(file!=null)
		{
			helper.addAttachment(file.getOriginalFilename(), file);
		}
		
		sender.send(message);
		
		return isSent;
	}
	
	public boolean send2(String to, String subject, String text) throws MessagingException
	{
		return send1(to, null, null, subject, text, null);
	}

}
