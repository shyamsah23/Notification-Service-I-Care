package com.iCare.I_Care.entity;

import com.iCare.I_Care.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Related Entity Id Should Be Present - Patient/Doctor Id")
    private Long relatedEntityId;
    @Email(message = "Recipient Email Id is not valid")
    private String recipientEmailId;
    @Email(message = "cc Email Id is not valid")
    private String ccEmailId;
    private String subject;
    private String messageBody;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime sentAt;
    private String failedError;

    public Notification() {
    }

    public Notification(Long id, Long relatedEntityId, String recipientEmailId, String ccEmailId, String subject, String messageBody, Status status, LocalDateTime sentAt,String failedError) {
        this.id = id;
        this.relatedEntityId = relatedEntityId;
        this.recipientEmailId = recipientEmailId;
        this.ccEmailId = ccEmailId;
        this.subject = subject;
        this.messageBody = messageBody;
        this.status = status;
        this.sentAt = sentAt;
        this.failedError=failedError;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelatedEntityId() {
        return relatedEntityId;
    }

    public void setRelatedEntityId(Long relatedEntityId) {
        this.relatedEntityId = relatedEntityId;
    }

    public String getRecipientEmailId() {
        return recipientEmailId;
    }

    public void setRecipientEmailId(String recipientEmailId) {
        this.recipientEmailId = recipientEmailId;
    }

    public String getCcEmailId() {
        return ccEmailId;
    }

    public void setCcEmailId(String ccEmailId) {
        this.ccEmailId = ccEmailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getFailedError() {
        return failedError;
    }

    public void setFailedError(String failedError) {
        this.failedError = failedError;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", relatedEntityId=" + relatedEntityId +
                ", recipientEmailId='" + recipientEmailId + '\'' +
                ", ccEmailId='" + ccEmailId + '\'' +
                ", subject='" + subject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", status=" + status +
                ", sentAt=" + sentAt +
                ", failedError='" + failedError + '\'' +
                '}';
    }
}
