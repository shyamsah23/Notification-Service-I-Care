package com.iCare.I_Care.service;

import com.iCare.I_Care.dto.EmailSendDTO;
import com.iCare.I_Care.entity.Notification;
import com.iCare.I_Care.enums.NotificationEnum;
import com.iCare.I_Care.enums.Status;
import com.iCare.I_Care.repository.NotificationRepository;
import com.iCare.I_Care.utlity.NotificationConstants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.beans.Transient;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Value("${constant.email.cc}")
    private String ccEmailId;

    @Value("${constant.email.sender}")
    private String senderEmailId;

    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }

    public void sendHTMLMail(Long id, String to, String subject, String type) throws Exception {
        Notification notification = new Notification();
        notification.setRelatedEntityId(id);
        notification.setCcEmailId(ccEmailId);
        notification.setRecipientEmailId(to);
        notification.setSubject(subject);
        notification.setSentAt(LocalDateTime.now());
        try {
            NotificationEnum notificationEnum;
            notificationEnum = NotificationEnum.valueOf(type);

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(senderEmailId);
            helper.setCc(ccEmailId);

            logger.info("CC Email Id:- {} ", ccEmailId);

            ClassPathResource resource = new ClassPathResource(notificationEnum.getPath());
            String htmlContent = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
            notification.setMessageBody(type);
            helper.setText(htmlContent, true);
            mailSender.send(message);
            notification.setStatus(Status.SUCCESS);
            logger.info("Mail Sent Successfully for Related Entity id = {}", id);

        } catch (Exception e) {
            notification.setStatus(Status.FAIL);
            notification.setFailedError(e.getMessage());
            logger.warn("Email Failed with error = {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            notificationRepository.save(notification);

        }
    }

    @Transactional
    public void sendMail(@RequestBody EmailSendDTO emailSendDTO) throws Exception {
        Notification notification = new Notification();
        notification.setRelatedEntityId(emailSendDTO.getRelatedEntityId());
        notification.setRecipientEmailId(emailSendDTO.getTo());
        notification.setCcEmailId(emailSendDTO.getCc());
        // Note Message Body are not saved because message body size is too long : Added in TODO -> Fix this
        notification.setSubject(emailSendDTO.getSubject());
        notification.setSentAt(LocalDateTime.now());

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
            helper.setCc(emailSendDTO.getCc());
            helper.setTo(emailSendDTO.getTo());
            helper.setSubject(emailSendDTO.getSubject());
            helper.setFrom(senderEmailId);
            helper.setText(emailSendDTO.getBody(), true);
            mailSender.send(message);
            notification.setStatus(Status.SUCCESS);

        } catch (Exception e) {
            notification.setStatus(Status.FAIL);
            notification.setFailedError(e.getMessage());
            throw new Exception(e);
        } finally {
            notificationRepository.save(notification);
        }
    }
}
