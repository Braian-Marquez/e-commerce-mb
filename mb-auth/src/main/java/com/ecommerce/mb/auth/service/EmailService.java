package com.ecommerce.mb.auth.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
@Service
public class EmailService {

    private  JavaMailSender sender;
  
    private TemplateEngine templateEngine;
    
    @Value("${spring.mail.username}")
    private String from;

    

    public EmailService(JavaMailSender sender, TemplateEngine templateEngine) {
		super();
		this.sender = sender;
		this.templateEngine = templateEngine;
	}

	private static final String SUBJECT = "Bienvenido";
    private static final String SUBJECT_VALIDATE = "Codigo de validacion";
    private static final String NOTIFICATION = "Notificación!";
    private static final String NOTIFICATION_MESSAGE = "You just logged in successfully!";

    public void sendWelcome(String email) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject(SUBJECT);
        Context context = new Context();
        String htmlContent = templateEngine.process("email-bienvenida", context);
        helper.setText(htmlContent, true);
        sender.send(message);
    }
    
    public void sendNotification(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(NOTIFICATION);
        message.setText(NOTIFICATION_MESSAGE);
        sender.send(message);
    }
	
	public void sendCodeEmail(String email, String validationCode) {
    SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(from);
        message.setSubject(SUBJECT_VALIDATE);
        message.setText(validationCode);
        sender.send(message);
		
	}
}