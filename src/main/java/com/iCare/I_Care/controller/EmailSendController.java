package com.iCare.I_Care.controller;

import com.iCare.I_Care.dto.EmailDTO;
import com.iCare.I_Care.dto.EmailWithHtmlDTO;
import com.iCare.I_Care.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/mail")
public class EmailSendController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/simpleMail")
    public void sendMail(@RequestBody EmailDTO emailDTO) {
        emailService.sendSimpleMail(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getBody());
    }

    @PostMapping("/htmlMail")
    public void sendMailWithHTML(@RequestBody EmailWithHtmlDTO emailWithHtmlDTO) throws Exception {
        emailService.sendHTMLMail(emailWithHtmlDTO.getTo(), emailWithHtmlDTO.getSubject(), emailWithHtmlDTO.getType());
    }
}
