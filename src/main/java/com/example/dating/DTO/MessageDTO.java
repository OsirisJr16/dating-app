package com.example.dating.DTO;

public class MessageDTO {
    private String message;
    private Long SenderId ;
    private Long ReceiverId ;

    public MessageDTO(String message, Long senderId, Long receiverId) {
        this.message = message;
        SenderId = senderId;
        ReceiverId = receiverId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getSenderId() {
        return SenderId;
    }
    public void setSenderId(Long senderId) {
        SenderId = senderId;
    }
    public Long getReceiverId() {
        return ReceiverId;
    }
    public void setReceiverId(Long receiverId) {
        ReceiverId = receiverId;
    }
}
