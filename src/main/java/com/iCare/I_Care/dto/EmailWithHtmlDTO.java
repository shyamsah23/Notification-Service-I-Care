package com.iCare.I_Care.dto;

public class EmailWithHtmlDTO {
    private String to;
    private String subject;
    private String type;

    public EmailWithHtmlDTO(String to, String subject, String type) {
        this.to = to;
        this.subject = subject;
        this.type = type;
    }

    public EmailWithHtmlDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
