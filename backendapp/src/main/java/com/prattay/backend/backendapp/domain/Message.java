package com.prattay.backend.backendapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.Table;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String senderEmail;

    @Column
    private Date time = new Date(System.currentTimeMillis());

    @Column
    private String replymessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHAT_ID")
    private Chat chat;

    public Message() {
    }

    public Message(Long id, String senderEmail, Date time, String replymessage, Chat chat) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.time = time;
        this.replymessage = replymessage;
        this.chat = chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReplymessage() {
        return replymessage;
    }

    public void setReplymessage(String replymessage) {
        this.replymessage = replymessage;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
