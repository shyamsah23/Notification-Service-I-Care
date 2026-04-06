package com.iCare.I_Care.dto;

public class EmailSendDTO {

    private Long relatedEntityId;
    private String to;
    private String cc;
    private String body;
    private String subject;

    public EmailSendDTO(Long relatedEntityId, String to, String cc, String body, String subject) {
        this.relatedEntityId = relatedEntityId;
        this.to = to;
        this.cc = cc;
        this.body = body;
        this.subject = subject;
    }

    public EmailSendDTO() {
    }

    public Long getRelatedEntityId() {
        return relatedEntityId;
    }

    public void setRelatedEntityId(Long relatedEntityId) {
        this.relatedEntityId = relatedEntityId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
