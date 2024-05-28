package com.example.dating.service;

import com.example.dating.entity.Message;
import com.example.dating.repository.MessageRepository;
import com.example.dating.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessagingService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessagingService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public void saveMessage(String senderUsername, String receiverUsername, String content) {
        Message message = new Message();
        message.setSender(userRepository.findByUsername(senderUsername));
        message.setReceiver(userRepository.findByUsername(receiverUsername));
        message.setMessage(content);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }
}
