package com.iCare.I_Care.service;

import com.iCare.I_Care.enums.NotificationEnum;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${constant.email.cc}")
    private String ccEmailId;

    @Value("${constant.email.sender}")
    private String senderEmailId;

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }

    public void sendHTMLMail(String to, String subject, String type) throws Exception {
        NotificationEnum notificationEnum;
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(senderEmailId);
        helper.setCc(ccEmailId);

        logger.info("CC Email Id:- {} ", ccEmailId);

        try {
            notificationEnum = NotificationEnum.valueOf(type);
        } catch (Exception e) {
            throw new Exception("Invalid Email Template type");
        }

        ClassPathResource resource = new ClassPathResource(notificationEnum.getPath());
        String htmlContent = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
        helper.setText(htmlContent, true);
        mailSender.send(message);
    }
}
