package com.iCare.I_Care.service;

import com.iCare.I_Care.dto.EmailSendDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotificationService {

    public void sendSimpleMail(String to, String subject, String text);

    public void sendHTMLMail(Long id, String to, String subject, String type) throws Exception;

    public void sendMail(@RequestBody EmailSendDTO emailSendDTO) throws Exception;
}
