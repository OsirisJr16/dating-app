package com.example.dating.service;

import com.example.dating.entity.Message;
import com.example.dating.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public List<Message> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        return messageRepository.findMessageBetweenUsers(senderId , receiverId);
    }
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
