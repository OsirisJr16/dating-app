package com.example.dating.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    @ManyToOne
    @JoinColumn(name = "senderID")
    private  User sender ;
    @ManyToOne
    @JoinColumn(name = "receiverID")
    private User receiver ;
    @Column(name = "message",nullable = false)
    private String message ;
    @Column(name = "timestamp",nullable = false)
    private LocalDateTime timestamp ;

    public Message() {

    }
    public Message(Long messageID, User sender, User receiver, String message, LocalDateTime timestamp) {
        this.messageID = messageID;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
