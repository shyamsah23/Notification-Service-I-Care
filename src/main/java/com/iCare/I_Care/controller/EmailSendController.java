package com.iCare.I_Care.controller;

import com.iCare.I_Care.dto.EmailDTO;
import com.iCare.I_Care.dto.EmailWithHtmlDTO;
import com.iCare.I_Care.service.NotificationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class EmailSendController {

    @Autowired
    private NotificationServiceImpl emailService;

    Logger logger = LoggerFactory.getLogger(EmailSendController.class);

    @PostMapping("/simpleMail")
    public ResponseEntity<String> sendMail(@RequestBody EmailDTO emailDTO) {
        logger.info("Started Sending mail to = {}", emailDTO.getTo());
        emailService.sendSimpleMail(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getBody());
        return new ResponseEntity<>("Mail Send Successfully", HttpStatus.OK);
    }

    @PostMapping("/htmlMail")
    public ResponseEntity<String> sendMailWithHTML(@RequestBody EmailWithHtmlDTO emailWithHtmlDTO) throws Exception {
        logger.info("Started Sending mail to with HTML Template = {}", emailWithHtmlDTO.getTo());
        emailService.sendHTMLMail(emailWithHtmlDTO.getId(), emailWithHtmlDTO.getTo(), emailWithHtmlDTO.getSubject(), emailWithHtmlDTO.getType());
        return new ResponseEntity<>("Mail Sended Successfully", HttpStatus.OK);
    }
}
