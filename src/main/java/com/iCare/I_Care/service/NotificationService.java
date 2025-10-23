package com.iCare.I_Care.service;

public interface NotificationService {

     public void sendSimpleMail(String to, String subject, String text);
     public void sendHTMLMail(Long id, String to, String subject, String type) throws Exception;
}
