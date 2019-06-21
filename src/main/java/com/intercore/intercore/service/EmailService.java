package com.intercore.intercore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mobile.itproga01vg.dv@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}